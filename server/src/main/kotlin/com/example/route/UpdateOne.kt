package com.example.route

import com.example.data.repository.StudentDataSource
import com.example.model.ApiRequest
import com.example.model.ApiResponse
import com.example.model.Endpoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.updateOne(
    app: Application,
    studentDataSource: StudentDataSource
) {
    post(Endpoint.UpdateOne.route) {
        val result = call.receive<ApiRequest>().student

        if (result != null) {
            try {
                if (studentDataSource.updateOne(student = result)) {
                    call.respond(
                        message = ApiResponse(
                            status = true,
                            message = "updated"
                        ),
                        status = HttpStatusCode.OK
                    )
                } else {
                    call.respond(
                        message = ApiResponse(
                            status = false,
                            message = "unable to update"
                        ),
                        status = HttpStatusCode.BadRequest
                    )
                }
            } catch (e: Exception) {
                app.log.info(e.message)

                call.respond(
                    message = ApiResponse(
                        status = false,
                        message = "internal server error"
                    ),
                    status = HttpStatusCode.ExpectationFailed
                )
            }
        }
    }
}