package com.thangadurai.animeapp.extenstions

fun String.parseError(): String {
    return when {
        this.contains("ConnectException") -> "Server Unavailable!"
        this.contains("Socket") -> "Internet Unavailable!"
        else -> "Unknown Error!"
    }
}