package com.example.mediunorder

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform