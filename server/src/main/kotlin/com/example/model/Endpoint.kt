package com.example.model

sealed class Endpoint(val route: String) {
    data object RootRoute: Endpoint(route = "/")
    data object InsertOneData: Endpoint(route = "/insert_one")
    data object DeleteOneStudent: Endpoint(route = "/delete_one")
    data object UpdateOne: Endpoint(route = "/update_one")
}