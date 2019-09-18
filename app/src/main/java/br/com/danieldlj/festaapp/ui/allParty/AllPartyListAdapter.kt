package br.com.danieldlj.festaapp.ui.allParty

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Party
import com.squareup.picasso.Picasso


class AllPartyListAdapter(private val partiesList: List<Party>) :
    RecyclerView.Adapter<AllPartyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int ): ViewHolder {

        val layout = LayoutInflater
            .from( parent.context )
            .inflate(R.layout.party_item, parent, false)

        return ViewHolder( layout )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ) {

        holder.setData( partiesList[ position ] )
    }

    override fun getItemCount() = partiesList.size

    inner class ViewHolder( itemView: View) :
        RecyclerView.ViewHolder( itemView ) {

        private val context : Context

        private val ivPartyFlyer : ImageView
        private val tvName : TextView



        init{
            context = itemView.context

            ivPartyFlyer = itemView.findViewById( R.id.iv_party_flyer )
            tvName = itemView.findViewById( R.id.tv_name )
        }

        fun setData( parties: Party ){

            Picasso.get()
                .load( parties.image )
                .into( ivPartyFlyer )
            println(parties.image)
            tvName.text = parties.name
            tvName.setTextColor(Color.parseColor(parties.textColor))

        }
    }

}