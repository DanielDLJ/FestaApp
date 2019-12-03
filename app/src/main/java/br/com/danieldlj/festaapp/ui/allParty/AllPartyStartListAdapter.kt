package br.com.danieldlj.festaapp.ui.allParty

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Party
import com.squareup.picasso.Picasso


class AllPartyStartListAdapter(private val context: Context,
                               private val items: List<Party>?) : RecyclerView.Adapter<AllPartyStartListAdapter.AllPartyViewHolder>() {

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllPartyViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.party_item, parent, false)
        return AllPartyViewHolder(layout)
    }

    override
    fun onBindViewHolder(holder: AllPartyViewHolder, position: Int) {
        val item = items?.get(position)

        Picasso.get()
            .load( item?.image )
            .into( holder.ivPartyFlyer )
        println(item?.image)

        holder.tvName.text = item?.name
        holder.tvName.setTextColor(Color.parseColor(item?.textColor))
        holder.itemView.setOnClickListener { onItemClicked(position) }
    }

    private fun onItemClicked(position: Int) {
        (context as AllPartyStartActivity).leave(items?.get(position)!!)
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(postModel: Party?) {
        notifyDataSetChanged()
    }

    class AllPartyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivPartyFlyer:ImageView = itemView.findViewById( R.id.iv_party_flyer )
        var tvName:TextView = itemView.findViewById( R.id.tv_name )

    }
}