package com.example.pokedex

data class Pokemon(
    val id: Int,
    val name: String,
    val vida: Int,
    val ataque: Int,
    val defensa: Int,
    val velocidad: Int,
    val tipo: PokemonTipo,
    val url: String
)
enum class PokemonTipo {
    PLANTA, FUEGO, AGUA, LUCHA, ELECTRICO
}
