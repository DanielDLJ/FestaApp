package br.com.danieldlj.festaapp.ui.expenses.Drink

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.DrinkExpenses
import br.com.danieldlj.festaapp.domain.FixedExpenses
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class DrinkExpensesAdapter(context: Context, data: List<DrinkExpenses>?, val adapterOnClick: PriceAlterInterface) :
    RecyclerView.Adapter<DrinkExpensesAdapter.DrinkExpensesViewHolder>() {
    private var total: Float = 0F
    private var mContext: Context = context
    private var items: List<DrinkExpenses>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkExpensesViewHolder {
        val view = inflater.inflate(R.layout.item_drink_expenses, parent, false)
        return DrinkExpensesViewHolder(
            view
        )
    }

    override
    fun onBindViewHolder(holder: DrinkExpensesViewHolder, position: Int) {
        val item = items?.get(position)

        Picasso.get()
            .load( item?.image )
            .into( holder.riv_item )

        holder.tvItemName.text = item?.item
        /*val valor = "R$ " + item?.price
        holder.tvPrice.text = valor

        if(item!!.paid){
            holder.tvPrice.setTextColor(Color.parseColor("#000000"))
            total += item.price
        }else{
            holder.tvPrice.setTextColor(Color.parseColor("#FF0000"))
            total += - item.price
        }*/
        //adapterOnClick.alterPrice(total)
        holder.itemView.setOnClickListener { onItemClicked(item) }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(drinkExpensesModel: DrinkExpenses?) {
        //adapterOnClick.alterPrice(total)
        notifyDataSetChanged()
    }

    class DrinkExpensesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var riv_item: RoundedImageView = itemView.findViewById(R.id.riv_item)
        var tvItemName: TextView = itemView.findViewById(R.id.tvItemName)

    }
}