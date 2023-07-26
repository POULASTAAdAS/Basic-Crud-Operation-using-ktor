package com.example.quotes.remote

import com.example.quotes.model.ApiRequest
import com.example.quotes.model.ApiResponse
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.POST

interface Api {
    @POST("/insert_one")
    suspend fun insertOne(
        @Body apiRequest: ApiRequest
    ): ApiResponse

    @HTTP(method = "DELETE", path = "/delete_one", hasBody = true)
    suspend fun deleteOne(
        @Body apiRequest: ApiRequest
    ): ApiResponse

    @POST("/update_one")
    suspend fun updateOne(
        @Body apiRequest: ApiRequest
    ): ApiResponse
}