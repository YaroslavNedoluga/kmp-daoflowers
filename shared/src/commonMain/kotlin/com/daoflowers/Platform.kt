package com.daoflowers

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform