package br.com.danieldlj.festaapp.ui.expenses.Fixed

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.FixedExpenses
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface

class FixedExpensesAdapter(context: Context, data: List<FixedExpenses>?,val adapterOnClick: PriceAlterInterface) :
    RecyclerView.Adapter<FixedExpensesAdapter.FixedExpensesViewHolder>() {
    private var total: Float = 0F
    private var mContext: Context = context
    private var items: List<FixedExpenses>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixedExpensesViewHolder {
        val view = inflater.inflate(R.layout.item_fixed_expenses, parent, false)
        return FixedExpensesViewHolder(
            view
        )
    }

    override
    fun onBindViewHolder(holder: FixedExpensesViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvWhat.text = item?.item
        val valor = "R$ " + item?.price
        holder.tvPrice.text = valor

        if(item!!.paid){
            holder.tvPrice.setTextColor(Color.parseColor("#000000"))
            total += item.price
        }else{
            holder.tvPrice.setTextColor(Color.parseColor("#FF0000"))
            total += - item.price
        }
        adapterOnClick.alterPrice(total)
        holder.itemView.setOnClickListener { onItemClicked(item) }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(fixedExpensesModel: FixedExpenses?) {
        adapterOnClick.alterPrice(total)
        notifyDataSetChanged()
    }

    class FixedExpensesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvWhat: TextView = itemView.findViewById(R.id.tvWhat)
        var tvPrice: TextView = itemView.findViewById(R.id.tvPrice)

    }
}