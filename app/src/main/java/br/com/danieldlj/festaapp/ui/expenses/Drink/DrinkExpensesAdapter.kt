package br.com.danieldlj.festaapp.ui.expenses.Drink

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.DrinkExpenses
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class DrinkExpensesAdapter(private val fragment : DrinkExpensesFragment,
                           private val items: List<DrinkExpenses>?, val adapterOnClick: PriceAlterInterface) : RecyclerView.Adapter<DrinkExpensesAdapter.DrinkExpensesViewHolder>() {
    private var total: Float = 0F

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkExpensesViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_drink_expenses, parent, false)
        return DrinkExpensesViewHolder(layout)
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
        holder.itemView.setOnClickListener { updateDrinkExpenses(position) }
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


    private fun updateDrinkExpenses( position: Int ){

        val updateFrag = FormUpdateDrinkExpensesFragment()

        //Colocando como dado de transição o item selecionado para atualização.
        val bundle = Bundle()
        bundle.putParcelable(DrinkExpenses.KEY, items?.get(position))
        updateFrag.arguments = bundle

        val transaction = fragment
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root_drink, updateFrag)

        /*
         * Com o setTransition() e addToBackStack() nós estamos,
         * respectivamente permitindo uma transição entre fragmentos
         * e os colocando em uma pilha de fragmentos para que seja
         * possível voltar ao fragmento anteriormente apresentado
         * na mesma janela.
         * */
        transaction
            .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN )
            .addToBackStack( null )
            .commit()
    }
}