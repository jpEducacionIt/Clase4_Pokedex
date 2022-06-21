package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter: ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Pokemon) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val idPokemon: TextView = view.findViewById(R.id.textViewId)
        private val nombrePokemon: TextView = view.findViewById(R.id.textViewNombre)
        private val imagenTipo: ImageView = view.findViewById(R.id.list_imageView)

        fun bind (pokemon: Pokemon) {
            idPokemon.text = pokemon.id.toString()
            nombrePokemon.text = pokemon.name

            val image = when(pokemon.tipo) {
                Pokemon.PokemonTipo.AGUA -> R.drawable.agua
                Pokemon.PokemonTipo.PLANTA -> R.drawable.planta
                Pokemon.PokemonTipo.FUEGO -> R.drawable.fuego
                Pokemon.PokemonTipo.ELECTRICO -> R.drawable.electrico
                Pokemon.PokemonTipo.LUCHA -> R.drawable.fighter
            }

            imagenTipo.setImageResource(image)

            view.setOnClickListener {
                onItemClickListener(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}
