package br.com.danieldlj.festaapp.ui.rotation

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
import br.com.danieldlj.festaapp.domain.Post
import br.com.danieldlj.festaapp.domain.Rotation

class RotationAdapter(private val fragment : RotationFragment,
                      private val items: List<Rotation>?) : RecyclerView.Adapter<RotationAdapter.RotationViewHolder>() {

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RotationViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rotation, parent, false)
        return RotationViewHolder(layout)
    }

    override
    fun onBindViewHolder(holder: RotationViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvName.text = item?.name

        holder.itemView.setOnClickListener { openRotationTime( position ) }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(rotationModel: Rotation?) {
        notifyDataSetChanged()
    }

    class RotationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)

    }

    private fun openRotationTime( position: Int ){

        val updateFrag = RotationTimeFragment()

        //Colocando como dado de transição o item selecionado para atualização.
        val bundle = Bundle()
        bundle.putParcelable(Rotation.KEY, items?.get(position))
        updateFrag.arguments = bundle

        val transaction = fragment
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root, updateFrag)

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