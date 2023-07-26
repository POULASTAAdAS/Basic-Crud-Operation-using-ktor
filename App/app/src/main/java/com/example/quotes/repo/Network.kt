package com.example.quotes.repo

import com.example.quotes.model.ApiRequest
import com.example.quotes.model.ApiResponse

interface Network {
    suspend fun insertOne(apiRequest: ApiRequest): ApiResponse
    suspend fun updateOne(apiRequest: ApiRequest): ApiResponse
    suspend fun deleteOne(apiRequest: ApiRequest): ApiResponse
}