package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRequest(
    val id: String? = null,
    val student: Student? = null,
    val listOfStudent: List<Student>? = emptyList()
)
