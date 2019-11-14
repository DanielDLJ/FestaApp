package br.com.danieldlj.festaapp.ui.expenses.Fixed

import android.os.Bundle
import android.view.View
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import kotlinx.android.synthetic.main.fragment_new_expenses_fixed.*

open class FormNewFixedExpensesFragment : FormFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_new_expenses_fixed

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun blockFields(status: Boolean) {
        et_drink_name.isEnabled = !status
        et_fixed_price.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_fixed.text =
            if( status )
                getString( R.string.update_fixed_going )
            else
                getString( R.string.update_fixed )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()


        bt_nu_fixed.setOnClickListener{
            mainAction()
        }
        bt_cancel_fixed.setOnClickListener(View.OnClickListener {
                (activity as MainActivity).onBackPressed()
            }
        )

        initItems()
    }
    private fun initItems(){
    }

}