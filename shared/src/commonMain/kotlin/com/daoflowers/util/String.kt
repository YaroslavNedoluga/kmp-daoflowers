package com.daoflowers.util

fun String?.replaceHttp(): String? {
    if (this == null) return null
    return if (contains("http") && !contains("https")) {
        replace("http", "https")
    } else {
        this
    }
}