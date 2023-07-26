package com.example.route

import com.example.model.ApiResponse
import com.example.model.Endpoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.rootRoute() {
    get(Endpoint.RootRoute.route) {
        call.respond(
            message = ApiResponse(
                message = "root",
                status = true
            ),
            status = HttpStatusCode.OK
        )
    }
}