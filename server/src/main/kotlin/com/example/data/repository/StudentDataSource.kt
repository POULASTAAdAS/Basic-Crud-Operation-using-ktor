package com.example.data.repository

import com.example.model.Student

interface StudentDataSource {
    suspend fun insertStudent(student: Student): Boolean
    suspend fun deleteOneStudent(id: String): Boolean
    suspend fun updateOne(student: Student): Boolean
}