package br.com.danieldlj.festaapp.ui.invite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.ui.invite.NotStudent.NotStudentInviteHostFragment
import br.com.danieldlj.festaapp.ui.invite.Student.StudentInviteHostFragment
import kotlinx.android.synthetic.main.fragment_invite.*

class InviteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_invite, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        initItems()
    }

    private fun initItems(){

        //Criando o adaptador de fragmentos que ficarão expostos no ViewPager.
        val sectionsPagerAdapter = getSectionsAdapter()

        /*
         * Acessando o ViewPager e vinculando o adaptador de
         * fragmentos a ele.
         * */
        view_pager.adapter = sectionsPagerAdapter

        /*
         * Acessando o TabLayout e vinculando ele ao ViewPager
         * para que haja sincronia na escolha realizada em
         * qualquer um destes componentes visuais.
         * */
        tabs.setupWithViewPager( view_pager )
    }

    fun getSectionsAdapter()
            = InviteSectionsAdapter((activity as MainActivity), (activity as MainActivity).getSupportFragmentManager(),
        StudentInviteHostFragment(), NotStudentInviteHostFragment()
    )

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).updateToolbarTitleInFragment( R.string.title_frag_invite_fragment )
    }
}