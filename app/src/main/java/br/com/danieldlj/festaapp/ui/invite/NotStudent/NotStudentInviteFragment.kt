package br.com.danieldlj.festaapp.ui.invite.NotStudent

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
import br.com.danieldlj.festaapp.data.NotStudentInviteDataBase
import br.com.danieldlj.festaapp.domain.Invite
import kotlinx.android.synthetic.main.fragment_invite_not_student.*
import kotlinx.android.synthetic.main.fragment_invite_not_student.recyclerView
import kotlinx.android.synthetic.main.fragment_list_rep.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NotStudentInviteFragment : Fragment() {

    fun title() = R.string.not_student_invite_fragment_tab_list
    val invites = ArrayList<Invite>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_invite_not_student, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        fab_add_not_student.setOnClickListener{
            addNotStudentInvite()
        }

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let { NotStudentInviteAdapter(tv_total_price,this, NotStudentInviteDataBase.getItems()) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        //getData()
    }

    fun getData() {
        println("list")
        invites.clear()
        val call: Call<List<Invite>> = ApiClient.getClient.getAllInvite((activity as MainActivity).user.party)
        call.enqueue(object : Callback<List<Invite>> {
            override fun onResponse(call: Call<List<Invite>>?, response: Response<List<Invite>>?) {
                val invites_aux = ArrayList<Invite>()
                invites_aux.addAll(response!!.body()!!)

                invites_aux.forEach {
                    if(it.student == 0)
                        invites.add(it)
                    println("it.student = " +it.student)
                }

                invites_aux.clear()
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Invite>>?, t: Throwable?) {
                println("onFailure")
            }
        })
    }


    private fun addNotStudentInvite(){

        val updateFrag = FormNewNotStudentInviteFragment()

        val transaction = this
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