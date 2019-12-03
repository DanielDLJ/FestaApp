package br.com.danieldlj.festaapp.ui.invite.NotStudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Invite

class NotStudentInviteAdapter(private val textView: TextView,
                              private val fragment : NotStudentInviteFragment,
                              private val items: List<Invite>?) : RecyclerView.Adapter<NotStudentInviteAdapter.NotStudentInviteViewHolder>() {
    private var total: Float = 0F

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotStudentInviteViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_invite, parent, false)
        return NotStudentInviteViewHolder(layout)
    }

    override
    fun onBindViewHolder(holder: NotStudentInviteViewHolder, position: Int) {
        val item = items?.get(position)
        holder.tvName.text = item?.name
        var valor = "R$ " + item?.valor
        holder.tvPrice.text = valor
        holder.itemView.setOnClickListener { updateNotStudentInvite(position) }

        total += item?.valor!!
        valor = "R$ " + total
        textView.text = valor
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(inviteModel: Invite?) {
        notifyDataSetChanged()
    }

    class NotStudentInviteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }


    private fun updateNotStudentInvite (position: Int ){

        val updateFrag = FormUpdateNotStudentInviteFragment()

        //Colocando como dado de transição o item selecionado para atualização.
        val bundle = Bundle()
        bundle.putParcelable(Invite.KEY, items?.get(position))
        updateFrag.arguments = bundle

        val transaction = fragment
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root_not_student, updateFrag)

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