package br.com.danieldlj.festaapp.ui.rotation

import android.os.Bundle
import android.view.View
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import kotlinx.android.synthetic.main.fragment_new_rotation_time.*

class FormUpdateRotationTimeFragment : FormNewRotationTimeFragment() {

    override fun getLayoutResourceID() = R.layout.fragment_update_rotation_time

    override fun backEndFakeDelay() {
        backEndFakeDelay(true, getString( R.string.valid ))
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_rotation_time.text =
            if( status )
                getString( R.string.update_rotation_time_going )
            else
                getString( R.string.update_rotation_time )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()
        bt_nu_rotation_time.text = getString( R.string.update_rotation_time )



        bt_nu_rotation_time.setOnClickListener{
            mainAction()
        }
        bt_cancel_rotation_time.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).onBackPressed()
            }
        )


        fillForm()
    }
    private fun fillForm(){
        /*var rotation = arguments!!.getParcelable<Post>(RotationTimeFragment.KEY)
        id = post.id
        post.id_party = (activity as MainActivity).user.party.id*/
    }


}
