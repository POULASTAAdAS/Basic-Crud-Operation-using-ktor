package com.example.quotes.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val status: Boolean,
    val message: String? = null,
    val student: Student? = null,
    val listOfStudent: List<Student>? = emptyList()
)