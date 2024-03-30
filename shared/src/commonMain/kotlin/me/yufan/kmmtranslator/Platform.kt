package me.yufan.kmmtranslator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform