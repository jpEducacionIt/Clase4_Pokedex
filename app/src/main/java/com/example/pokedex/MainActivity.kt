package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), PokemonSelectedListener {

    private lateinit var detailFragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detailFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentDetailView) as DetailFragment
    }

    override fun onPokemonSelected(pokemon: Pokemon) {
        detailFragment.setDatosPokemon(pokemon)
    }

    /*
    fun metodoMasSimple(pokemon: Pokemon) {
        detailFragment.setDatosPokemon(pokemon)
    }

     */
}
