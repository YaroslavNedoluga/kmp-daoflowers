package com.daoflowers.catalog.data.repo

import com.daoflowers.catalog.data.model.FlowerSearchRequest
import com.daoflowers.catalog.data.model.FlowerSort
import com.daoflowers.catalog.data.model.FlowerType
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface CatalogRepo {
    @Throws(Exception::class)
    suspend fun flowerTypes(): List<FlowerType>

    @Throws(Exception::class)
    suspend fun flowerSearch(quarry: String): List<FlowerSort>
}

class CatalogRepoImpl : CatalogRepo {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    override suspend fun flowerTypes(): List<FlowerType> {
        return httpClient
            .get("https://testmobile.daoflowers.com:8443/catalog/flowers/types")
            .body()
    }

    override suspend fun flowerSearch(quarry: String): List<FlowerSort> {
        return httpClient
            .post(
                "https://testmobile.daoflowers.com:8443/catalog/search/flowers"
            ) {
                contentType(ContentType.Application.Json)
                setBody(FlowerSearchRequest(nameOrAbr = quarry))
            }.body()
    }
}