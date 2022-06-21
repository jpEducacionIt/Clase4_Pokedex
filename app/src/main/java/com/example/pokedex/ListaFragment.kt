package com.example.pokedex

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

class ListaFragment : Fragment() {

    private lateinit var listener: PokemonSelectedListener
    private lateinit var recyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = try {
            context as PokemonSelectedListener
        } catch (e: ClassCastException) {
            throw  ClassCastException("$context debe implementar el listener")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_lista, container, false)
        recyclerView = myView.findViewById(R.id.list_recyclerview)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recyclerView.adapter = adapter

        adapter.onItemClickListener = {
            //(activity as MainActivity).metodoMasSimple(pokemon = it)
            listener.onPokemonSelected(pokemon = it)
        }

        val pokemonLista = listadePokemones()
        adapter.submitList(pokemonLista)
    }

    private fun listadePokemones(): MutableList<Pokemon> {
        return mutableListOf(
            Pokemon(1, "Bulbasaur",45,49,49,45,Pokemon.PokemonTipo.PLANTA, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftwinfinite.net%2Fwp-content%2Fuploads%2F2019%2F11%2Fbulbasaur.jpg&f=1&nofb=1"),
            Pokemon(2, "Ivysaur",60,62,63,60,Pokemon.PokemonTipo.PLANTA,"https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2FShauna_Ivysaur-1180x664.png&f=1&nofb=1"),
            Pokemon(3,"Venuasaur",80,82,83,80,Pokemon.PokemonTipo.PLANTA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2F951.png&f=1&nofb=1"),
            Pokemon(4, "Charmander",39,52,43,65, Pokemon.PokemonTipo.FUEGO, "https://areajugones.sport.es/wp-content/uploads/2020/10/Charmander-Poke%CC%81mon-1080x609.jpg.webp"),
            Pokemon(5,"Charmeleon",58,64,58,80,Pokemon.PokemonTipo.FUEGO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FZBIO411y9IE%2Fmaxresdefault.jpg&f=1&nofb=1"),
            Pokemon(6, "Charizzard",78,84,78,100, Pokemon.PokemonTipo.FUEGO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fassets.primagames.com%2Fmedia%2Fimages%2Fnews%2Fcharizard-counters-pokemon-go.jpg&f=1&nofb=1"),
            Pokemon(7,"Squirtle",44,48,46,47,Pokemon.PokemonTipo.AGUA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2FTierno_Squirtle-1.png&f=1&nofb=1"),
            Pokemon(8, "Wartotle",59,63,80,58,Pokemon.PokemonTipo.AGUA, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2F1octPQi1w4A%2Fmaxresdefault.jpg&f=1&nofb=1"),
            Pokemon(9,"Blastoise",79,84,100,78,Pokemon.PokemonTipo.AGUA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fvignette4.wikia.nocookie.net%2Fpokemon%2Fimages%2F4%2F49%2FBlue_Blastoise_Generations.png%2Frevision%2Flatest%3Fcb%3D20160923172932&f=1&nofb=1"),
            Pokemon(10,"Pikachu",35,55,40,90,Pokemon.PokemonTipo.ELECTRICO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi2.wp.com%2Fmetro.co.uk%2Fwp-content%2Fuploads%2F2016%2F06%2Fash_s_pikachu-0.png%3Fquality%3D90%26strip%3Dall%26zoom%3D1%26resize%3D899%252C580%26ssl%3D1&f=1&nofb=1"),
            Pokemon(11, "Raichu",60,90,110,110,Pokemon.PokemonTipo.ELECTRICO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvignette.wikia.nocookie.net%2Fpokemon%2Fimages%2F4%2F4b%2FGoh_Raichu.png%2Frevision%2Flatest%3Fcb%3D20200906115835&f=1&nofb=1"),
            Pokemon(12, "Machop",70,67,76,54,Pokemon.PokemonTipo.LUCHA,"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.vvI6hvzMDz5CYaYMbuG5vwHaFO%26pid%3DApi&f=1"),
            Pokemon(13,"Hitmonlee",67,54,78,65,Pokemon.PokemonTipo.LUCHA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F12%2FBarry_Hitmonlee-1180x664.png&f=1&nofb=1"),
        )
    }
}