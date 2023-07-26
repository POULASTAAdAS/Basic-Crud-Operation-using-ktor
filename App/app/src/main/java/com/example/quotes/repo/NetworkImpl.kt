package com.example.quotes.repo

import android.util.Log
import com.example.quotes.model.ApiRequest
import com.example.quotes.model.ApiResponse
import com.example.quotes.remote.Api
import javax.inject.Inject

class NetworkImpl @Inject constructor(
    private val api: Api
) : Network {
    override suspend fun insertOne(apiRequest: ApiRequest): ApiResponse {
        return try {
            api.insertOne(apiRequest)
        } catch (e: Exception) {
            Log.d("insertOne", "${e.message} error")
            ApiResponse(
                status = false
            )
        }
    }

    override suspend fun updateOne(apiRequest: ApiRequest): ApiResponse {
        return try {
            api.updateOne(apiRequest)
        } catch (e: Exception) {
            Log.d("updateOne", "${e.message} error")
            ApiResponse(
                status = false
            )
        }
    }

    override suspend fun deleteOne(apiRequest: ApiRequest): ApiResponse {
        return try {
            api.deleteOne(apiRequest)
        } catch (e: Exception) {
            Log.d("deleteOne", "${e.message} error")
            ApiResponse(
                status = false
            )
        }
    }
}