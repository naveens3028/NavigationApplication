package com.example.navigationapplication.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

object KtorModuleClass {

    val BASE_URL= "https://howtodoandroid.com/"

    val client = HttpClient(CIO) {
        // Logging
        install(Logging) {
            level = LogLevel.ALL
        }
/*
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
*/
/*
        install(DefaultRequest) {
            headers.append("Accept","application/json")
            headers.append("Authorization","Bearer token")
        }
*/
        defaultRequest {
            // Parameter("api_key", "some_api_key")
            // Content Type
            if (method != HttpMethod.Get) contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }


}