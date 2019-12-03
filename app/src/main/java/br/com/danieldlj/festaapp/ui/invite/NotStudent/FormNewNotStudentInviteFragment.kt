package br.com.danieldlj.festaapp.ui.invite.NotStudent

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.api.ApiClient
import br.com.danieldlj.festaapp.domain.Invite
import br.com.danieldlj.festaapp.domain.ServerResponse
import br.com.danieldlj.festaapp.uitl.isValidString
import br.com.danieldlj.festaapp.uitl.validate
import kotlinx.android.synthetic.main.fragment_new_invite_not_student.*
import kotlinx.android.synthetic.main.proxy_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class FormNewNotStudentInviteFragment : FormFragment() {

    lateinit var invite: Invite
    override fun getLayoutResourceID() = R.layout.fragment_new_invite_not_student

    override fun backEndFakeDelay() {

        //Atualizando a variavel post com os itens digitados no form
        getItens()



        val containerForm = fl_proxy_container.parent as ViewGroup

        //backEndFakeDelay(false, getString( R.string.invalid ))
        val call: Call<ServerResponse> = ApiClient.getClient.createInvite(invite)
        call.enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call: Call<ServerResponse>?, response: Response<ServerResponse>?) {
                val serverResponse = (response!!.body()!!)

                blockFields( false )
                isMainButtonSending( false )
                showProxy( false )

                //1 | 0 (1 caso de certo e 0 caso de algo errado)
                if (serverResponse.created <= 0){
                    snackBarFeedback(containerForm, false, getString( R.string.invalid ))
                }else{
                    snackBarFeedback(containerForm, true, getString( R.string.valid ))
                }
            }

            override fun onFailure(call: Call<ServerResponse>?, t: Throwable?) {

                blockFields( false )
                isMainButtonSending( false )
                showProxy( false )

                println("onFailure")
                snackBarFeedback(containerForm, false, getString( R.string.invalid ))
            }
        })
    }

    override fun blockFields(status: Boolean) {
        et_not_student_name.isEnabled = !status
        et_not_student_valor.isEnabled = !status
        et_not_student_expected_sales.isEnabled = !status
        bt_cancel_not_student.isEnabled = !status
        bt_nu_not_student.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_not_student.text =
            if( status )
                getString( R.string.update_invite_going )
            else
                getString( R.string.update_invite )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()

        et_not_student_name.validate({
            it.isValidString() }, getString( R.string.invalid_invite_name ))

        bt_nu_not_student.setOnClickListener{
            mainAction()
        }
        bt_cancel_not_student.setOnClickListener(View.OnClickListener {
                (activity as MainActivity).onBackPressed()
            }
        )

        initItems()
    }
    private fun initItems(){

    }


    fun getItens(){
        invite = Invite(1,(activity as MainActivity).user.party.id,"",1f,1,1f,0)
        invite.name = et_not_student_name.text.toString()
        invite.valor = et_not_student_valor.text.toString().toFloat()
        invite.expectedSales = et_not_student_expected_sales.text.toString().toInt()
        invite.total = txt_not_student_total.text.toString().toFloat()
        invite.student = 0
    }

}