package br.com.danieldlj.festaapp.ui.rotation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Person
import br.com.danieldlj.festaapp.domain.Post
import br.com.danieldlj.festaapp.domain.Rotation
import br.com.danieldlj.festaapp.domain.RotationTime


class RotationTimeNameAdapter(context: Context, data: List<Person>?) :
    RecyclerView.Adapter<RotationTimeNameAdapter.RotationTimeNameViewHolder>() {
    private var mContext: Context = context
    private var items: List<Person>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RotationTimeNameViewHolder {
        val view = inflater.inflate(R.layout.item_name, parent, false)
        return RotationTimeNameViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: RotationTimeNameViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvName.text = item?.name

    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class RotationTimeNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.tvName)

    }
}