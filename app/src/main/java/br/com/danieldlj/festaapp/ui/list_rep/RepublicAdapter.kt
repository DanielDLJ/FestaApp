package br.com.danieldlj.festaapp.ui.list_rep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Republic
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso


class RepublicAdapter(context: Context, data: List<Republic>?) :
    RecyclerView.Adapter<RepublicAdapter.RepublicViewHolder>() {
    private var mContext: Context = context
    private var items: List<Republic>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var headlineAdapter: ResidentsAdapter? = null

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepublicViewHolder {
        val view = inflater.inflate(R.layout.item_republic, parent, false)
        return RepublicViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: RepublicViewHolder, position: Int) {
        val item = items?.get(position)

        Picasso.get()
            .load( item?.image )
            .into( holder.rivRep )
        holder.tvName.text = item?.name
        headlineAdapter = ResidentsAdapter(this.mContext, item?.residents)
        holder.rvHeadlines.adapter = headlineAdapter
        holder.rvHeadlines.layoutManager = LinearLayoutManager(mContext)

        holder.itemView.setOnClickListener { onItemClicked(item) }
        if (item?.isExpanded!!) {
            holder.rvHeadlines.visibility = View.VISIBLE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.rvHeadlines.visibility = View.GONE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_down)
        }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(republicModel: Republic?) {
        republicModel?.isExpanded = !republicModel?.isExpanded!!
        notifyDataSetChanged()
    }

    class RepublicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rivRep: RoundedImageView = itemView.findViewById(R.id.riv_rep)
        var tvName: TextView = itemView.findViewById(R.id.tvPaperName)
        var rvHeadlines: RecyclerView = itemView.findViewById(R.id.rvHeadlines)
        var ivArrow: ImageView = itemView.findViewById(R.id.ivArrow)

    }
}