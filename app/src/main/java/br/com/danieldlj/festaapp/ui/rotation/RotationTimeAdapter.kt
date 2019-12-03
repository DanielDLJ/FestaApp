package br.com.danieldlj.festaapp.ui.rotation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Post
import br.com.danieldlj.festaapp.domain.Rotation
import br.com.danieldlj.festaapp.domain.RotationTime

class RotationTimeAdapter(private val fragment : RotationTimeFragment,
                          private val items:  List<RotationTime>?) : RecyclerView.Adapter<RotationTimeAdapter.RotationTimeViewHolder>() {

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RotationTimeViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rotation_time, parent, false)
        return RotationTimeViewHolder(layout)
    }

    override
    fun onBindViewHolder(holder: RotationTimeViewHolder, position: Int) {
        val item = items?.get(position)

        val time = item?.timeStart + "\n" + "até" + "\n" + item?.timeTo
        holder.tvTime.text = time

        val adapter = fragment?.let { fragment.context?.let { it1 -> RotationTimeNameAdapter(it1, item?.persons!!) } }
        holder.recyclerView.adapter = adapter
        holder.recyclerView.layoutManager = LinearLayoutManager(fragment.context)

        holder.itemView.setOnClickListener { editRotationTime(position) }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(rotationTimeModel: RotationTime?) {

        notifyDataSetChanged()
    }

    class RotationTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTime: TextView = itemView.findViewById(R.id.tvTime)
        var recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)

    }


    private fun editRotationTime( position: Int ){

        val updateFrag = FormUpdateRotationTimeFragment()

        //Colocando como dado de transição o item selecionado para atualização.
        val bundle = Bundle()
        val rotation = items?.let { Rotation(1,"x", it) }

        bundle.putParcelable(Rotation.KEY, rotation)
        bundle.putInt(Rotation.POSITION, position)
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
