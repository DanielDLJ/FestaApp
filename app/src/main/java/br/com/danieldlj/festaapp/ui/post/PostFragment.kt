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
import br.com.danieldlj.festaapp.api.ApiClient
import br.com.danieldlj.festaapp.domain.Post
import kotlinx.android.synthetic.main.fragment_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFragment : Fragment() {


    val posts = ArrayList<Post>()
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

        val adapter = context?.let { PostAdapter(this, posts) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        getData()
    }

    fun getData() {
        println("list")
        posts.clear()
        val call: Call<List<Post>> = ApiClient.getClient.getAllPost((activity as MainActivity).user.party)
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                posts.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                println("onFailure")
            }
        })
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