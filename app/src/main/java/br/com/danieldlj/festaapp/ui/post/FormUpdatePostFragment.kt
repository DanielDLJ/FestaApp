package br.com.danieldlj.festaapp.ui.post

import android.os.Bundle
import android.view.View
import android.widget.Button
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Post
import kotlinx.android.synthetic.main.fragment_new_post.*
import kotlinx.android.synthetic.main.fragment_new_rotation_time.*

class FormUpdatePostFragment : FormNewPostFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_update_post

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
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
        bt_nu_post.text = getString( R.string.update_post )

        bt_nu_post.setOnClickListener{
            mainAction()
        }
        bt_cancel_post.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).onBackPressed()
            }
        )


        fillForm()
    }
    private fun fillForm(){
        val post = arguments!!.getParcelable<Post>(Post.KEY)

        et_post_what.setText( post.what )
        et_post_notice.setText( post.notice )
        et_post_date.setText( post.date )
        et_post_horary.setText( post.time )
        et_post_who.setText( post.who )
        et_post_description.setText( post.description )
    }


}
