package br.com.danieldlj.festaapp.ui.invite.NotStudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.NotStudentInviteDataBase
import kotlinx.android.synthetic.main.fragment_invite_not_student.*


class NotStudentInviteFragment : Fragment() {

    fun title() = R.string.not_student_invite_fragment_tab_list

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_invite_not_student, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        fab_add_not_student.setOnClickListener{
            //addNotStudentInvite()
        }

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let { NotStudentInviteAdapter(this, NotStudentInviteDataBase.getItems()) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        val string:String = R.string.total.toString() + 0
        tv_total_price.text = string
    }


   /* private fun addNotStudentInvite(){

        val updateFrag = FormNewNotStudentInviteFragment()

        val transaction = this
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root_not_students, updateFrag)

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
    }*/
}