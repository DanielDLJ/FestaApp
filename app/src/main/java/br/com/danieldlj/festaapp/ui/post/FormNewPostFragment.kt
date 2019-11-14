package br.com.danieldlj.festaapp.ui.post

import android.os.Bundle
import android.view.View
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import kotlinx.android.synthetic.main.fragment_new_post.*
import kotlinx.android.synthetic.main.fragment_new_rotation_time.*

open class FormNewPostFragment : FormFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_new_post

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun blockFields(status: Boolean) {
        et_post_what.isEnabled = !status
        et_post_notice.isEnabled = !status
        et_post_date.isEnabled = !status
        et_post_horary.isEnabled = !status
        et_post_who.isEnabled = !status
        et_post_description.isEnabled = !status
        bt_nu_post.isEnabled = !status
        bt_cancel_post.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_post.text =
            if( status )
                getString( R.string.update_post_going )
            else
                getString( R.string.update_post )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()


        bt_nu_post.setOnClickListener{
            mainAction()
        }
        bt_cancel_post.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).onBackPressed()
            }
        )

        initItems()
    }
    private fun initItems(){
    }

}