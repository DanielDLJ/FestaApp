package br.com.danieldlj.festaapp.ui.expenses.Fixed

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
import br.com.danieldlj.festaapp.domain.FixedExpenses
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface

class FixedExpensesAdapter(private val fragment : FixedExpensesFragment,
                           private val items: List<FixedExpenses>?,val adapterOnClick: PriceAlterInterface) :
    RecyclerView.Adapter<FixedExpensesAdapter.FixedExpensesViewHolder>() {
    private var total: Float = 0F

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixedExpensesViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_fixed_expenses, parent, false)
        return FixedExpensesViewHolder(
            layout
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
        holder.itemView.setOnClickListener { updateFixedExpenses(position) }
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

    private fun updateFixedExpenses( position: Int ){

        val updateFrag = FormUpdateFixedExpensesFragment()

        //Colocando como dado de transição o item selecionado para atualização.
        val bundle = Bundle()
        bundle.putParcelable(FixedExpenses.KEY, items?.get(position))
        updateFrag.arguments = bundle

        val transaction = fragment
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root_fixed, updateFrag)

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