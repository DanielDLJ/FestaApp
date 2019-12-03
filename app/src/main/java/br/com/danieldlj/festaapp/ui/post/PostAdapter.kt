package br.com.danieldlj.festaapp.ui.post

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
import br.com.danieldlj.festaapp.uitl.getDate
import br.com.danieldlj.festaapp.uitl.getTime

class PostAdapter(private val fragment : PostFragment,
                  private val items: List<Post>?) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(layout)
    }

    override
    fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = items?.get(position)

        holder.tvWhat.text = item?.what
        val schedule = item?.date?.getDate() + "\n" + item?.date?.getTime()
        holder.tvTime.text = schedule

        if(item?.done!!){
            holder.tvTime.setTextColor(Color.parseColor("#000000"))
        }else{
            holder.tvTime.setTextColor(Color.parseColor("#FF0000"))
        }

        holder.itemView.setOnClickListener { updatePost(position) }
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

    private fun updatePost( position: Int ){

        val updateFrag = FormUpdatePostFragment()

        //Colocando como dado de transição o item selecionado para atualização.
        val bundle = Bundle()
        bundle.putParcelable(Post.KEY, items?.get(position))
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