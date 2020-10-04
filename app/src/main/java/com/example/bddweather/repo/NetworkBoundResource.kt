package com.example.bddweather.repo

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.example.bddweather.api.ApiErrorResponse
import com.example.bddweather.api.ApiResponse
import com.example.bddweather.api.ApiSuccessResponse
import com.example.bddweather.vo.Resource
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    fun asFlow() = flow<Resource<ResultType>> {
        emit(Resource.loading(null))
        val dbFlow = loadFromDb()
        val dbValue = dbFlow.first()
        if (shouldFetch(dbValue)) {
            emit(Resource.loading(dbValue))
            when (val apiResponse = fetchFromNetwork()) {
                is ApiSuccessResponse -> {
                    saveNetworkResult(processResponse(apiResponse))
                    emitAll(loadFromDb().map {
                        Resource.success(it)
                    })
                }
                is ApiErrorResponse -> {
                    onFetchFailed()
                    emitAll(loadFromDb().map { Resource.error(apiResponse.errorMessage, it) })
                }
            }
        } else {
            emitAll(dbFlow.map { Resource.success(it) })
        }
    }

    protected open fun onFetchFailed() {
        // Implement in sub-classes to handle errors
    }

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<RequestType>) = response.body

    @WorkerThread
    protected abstract suspend fun saveNetworkResult(item: RequestType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract suspend fun loadFromDb(): Flow<ResultType>

    @MainThread
    protected abstract suspend fun fetchFromNetwork(): ApiResponse<RequestType>
}

