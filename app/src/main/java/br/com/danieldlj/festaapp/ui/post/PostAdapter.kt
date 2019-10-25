package br.com.danieldlj.festaapp.ui.post

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Post

class PostAdapter(context: Context, data: List<Post>?) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var mContext: Context = context
    private var items: List<Post>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = inflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvWhat.text = item?.what
        val schedule = item?.date + "\n" + item?.time
        holder.tvTime.text = schedule

        if(item?.done!!){
            holder.tvTime.setTextColor(Color.parseColor("#000000"))
        }else{
            holder.tvTime.setTextColor(Color.parseColor("#FF0000"))
        }

        holder.itemView.setOnClickListener { onItemClicked(item) }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(postModel: Post?) {
        notifyDataSetChanged()
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvWhat: TextView = itemView.findViewById(R.id.tvWhat)
        var tvTime: TextView = itemView.findViewById(R.id.tvTime)

    }
}