package com.example.plugins

import com.example.data.repository.StudentDataSource
import com.example.route.deleteOne
import com.example.route.insertOne
import com.example.route.rootRoute
import com.example.route.updateOne
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    routing {
        val studentDataSource: StudentDataSource by inject(StudentDataSource::class.java)

        rootRoute()
        insertOne(application, studentDataSource)
        updateOne(application , studentDataSource)
        deleteOne(application, studentDataSource)
    }
}
