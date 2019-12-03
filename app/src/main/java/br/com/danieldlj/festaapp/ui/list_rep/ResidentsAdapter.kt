package br.com.danieldlj.festaapp.ui.list_rep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Republic
import br.com.danieldlj.festaapp.domain.Resident


class ResidentsAdapter(context: Context, data: List<Resident>?) :
    RecyclerView.Adapter<ResidentsAdapter.ResidentsViewHolder>() {
    private var items: List<Resident>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentsViewHolder {
        val view = inflater.inflate(R.layout.item_residents, parent, false)
        return ResidentsViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: ResidentsViewHolder, position: Int) {
        val item = items?.get(position)

        holder.cbChecked.isChecked = item?.check!!
        holder.tvTitle.text = item.name

        holder.cbChecked.setOnClickListener { onItemClicked(item) }

    }

    override
    fun getItemCount(): Int {
        return items?.size?:0
    }

    private fun onItemClicked(residentModel: Resident?) {
        residentModel?.check = !residentModel?.check!!
        notifyDataSetChanged()
    }

    class ResidentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cbChecked: CheckBox = itemView.findViewById(R.id.cbChecked)
        var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }
}