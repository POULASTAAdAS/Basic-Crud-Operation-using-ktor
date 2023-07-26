package com.example.data.repository

import com.example.model.Student
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class StudentDataSourceImpl(
    database: CoroutineDatabase
) : StudentDataSource {
    private val studentCollection = database.getCollection<Student>()

    override suspend fun insertStudent(student: Student): Boolean =
        studentCollection.insertOne(student).wasAcknowledged()

    override suspend fun deleteOneStudent(id: String): Boolean =
        studentCollection.deleteOne(filter = Student::id eq id).wasAcknowledged()

    override suspend fun updateOne(student: Student): Boolean =
        studentCollection.updateOne(filter = Student::id eq student.id, target = student).wasAcknowledged()
}