package com.unisabana.wordle.data

val words = listOf<String>(
    "cielo",
    "perro",
    "gatos",
    "luzca",
    "piano",
    "silla",
    "nubes",
    "flaco",
    "plaza",
    "verde"
)

fun getRandomWord (): String {
    return words.random()
}