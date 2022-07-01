package com.example.actors

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyCharacterMap.load
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.lang.System.load

class ActorRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_recycler)

        val list = findViewById<RecyclerView>(R.id.actorList)
        val actors = generateActors()
        val adapter = ActorsAdapter(this, actors)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }

    data class Actor(
        val name: String,
        val avatar: Int,
        val hasOscar: Boolean
    )

    fun generateActors(): List<Actor> {
        return listOf(
            Actor(
                "Alicia Vikander",
                R.drawable.alicia_vikander,
                true
            ),
            Actor(
                "Amanda Seyfried",
                R.drawable.amanda_seyfried,
                false
            ),
            Actor(
                "Anne Hathaway",
                R.drawable.anne_hathaway,
                true
            ),
            Actor(
                "Emma Stone",
                R.drawable.emma_stone,
                false
            ),
            Actor(
                "George Clooney",
                R.drawable.george_clooney,
                false
            ),
            Actor(
                "Leonardo DiCaprio",
                R.drawable.leonardo_dicaprio,
                true
            ),
            Actor(
                "John Cristopher Depp",
                R.drawable.john_cristopher_depp,
                false
            ),
            Actor(
                "Robert John Downey Jr",
                R.drawable.robert_john_downey,
                false
            ),

        )
    }

    class ActorsAdapter(
        context: Context,
        var actors: List<Actor>
    ) : RecyclerView.Adapter<ActorViewHolder>() {

        private val inflater: LayoutInflater = LayoutInflater.from(context)

        override fun getItemCount(): Int = actors.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
            val view = inflater.inflate(R.layout.list_item_actor, parent, false)
            return ActorViewHolder(view)
        }

        override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        fun getItem(position: Int): Actor = actors[position]
    }

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val avatar: ImageView = itemView.findViewById(R.id.avatar)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val oscar: ImageView = itemView.findViewById(R.id.oscar)

        fun bind(actor: Actor) {
            loadImageAsync(actor.avatar, avatar)
            name.text = actor.name
            oscar.visibility = if (actor.hasOscar) View.VISIBLE else View.GONE
        }

        private fun loadImageAsync(avatar: Int, avatarView: ImageView) {
        // Загружаем картинку
            Glide.with(itemView)
                .load(avatar)
                .into(avatarView);
        }
    }
}