package br.com.danieldlj.festaapp.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.ListRepDataBase
import br.com.danieldlj.festaapp.data.PostDataBase
import br.com.danieldlj.festaapp.domain.Rotation
import br.com.danieldlj.festaapp.ui.list_rep.RepublicAdapter
import br.com.danieldlj.festaapp.ui.rotation.RotationTimeFragment
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_post, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        fab_add_post.setOnClickListener{
            addPost()
        }

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let { PostAdapter(this, PostDataBase.getItems()) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun addPost(){

        val newFrag = FormNewPostFragment()

        val transaction = this
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root, newFrag)

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