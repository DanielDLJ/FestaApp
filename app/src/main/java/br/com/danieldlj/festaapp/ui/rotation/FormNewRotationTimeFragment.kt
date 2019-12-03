package br.com.danieldlj.festaapp.ui.rotation

import android.annotation.SuppressLint
import android.os.Bundle
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.R
import kotlinx.android.synthetic.main.fragment_new_rotation_time.*

open class FormNewRotationTimeFragment : FormFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_new_rotation_time

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun blockFields(status: Boolean) {
        txt_hour.isEnabled = !status
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



        initItems()
    }
    private fun initItems(){
    }

}