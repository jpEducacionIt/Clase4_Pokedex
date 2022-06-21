package com.example.pokedex

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class DetailFragment : Fragment() {

    private lateinit var ataqueTextView: TextView
    private lateinit var defensaTextView: TextView
    private lateinit var velocidadTextView: TextView
    private lateinit var vidaTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_detail, container, false)

        ataqueTextView = myView.findViewById(R.id.detail_ataque)
        defensaTextView = myView.findViewById(R.id.detaildefense)
        velocidadTextView = myView.findViewById(R.id.detailvelocidad)
        vidaTextView = myView.findViewById(R.id.detail_text_vida)
        imageView = myView.findViewById(R.id.list_imageView)
        progressBar = myView.findViewById(R.id.detail_progressBar)

        return myView
    }

    fun setDatosPokemon(pokemon: Pokemon) {

        progressBar.visibility = View.VISIBLE

        Glide.with(this).load(pokemon.url).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.visibility = View.GONE
                imageView.setImageResource(R.drawable.pokemon)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.visibility = View.GONE
                return false
            }

        }).into(imageView)

        ataqueTextView.text = "Atq: ${pokemon.ataque}"
        defensaTextView.text = "Def: ${pokemon.defensa}"
        velocidadTextView.text = "Vel: ${pokemon.velocidad}"
        vidaTextView.text = "HP: ${pokemon.vida}"
    }
}