package com.example.di

import com.example.data.repository.StudentDataSource
import com.example.data.repository.StudentDataSourceImpl
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val koinModule = module {
    single {
        KMongo
            .createClient()
            .coroutine
            .getDatabase("student_db")
    }

    single<StudentDataSource> {
        StudentDataSourceImpl(get())
    }
}