package com.example.pokedex

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val vida: Int,
    val ataque: Int,
    val defensa: Int,
    val velocidad: Int,
    val tipo: PokemonTipo,
    val url: String
) : Parcelable {

    enum class PokemonTipo {
        PLANTA, FUEGO, AGUA, LUCHA, ELECTRICO
    }
}
