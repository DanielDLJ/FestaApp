package br.com.danieldlj.festaapp.ui.invite.Student

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.api.ApiClient
import br.com.danieldlj.festaapp.domain.Invite
import br.com.danieldlj.festaapp.domain.ServerResponse
import br.com.danieldlj.festaapp.uitl.isValidString
import br.com.danieldlj.festaapp.uitl.validate
import kotlinx.android.synthetic.main.fragment_new_invite_student.*
import kotlinx.android.synthetic.main.proxy_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormUpdatetStudentInviteFragment : FormNewStudentInviteFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_update_invite_sudent

    override fun backEndFakeDelay() {

        //Atualizando a variavel post com os itens digitados no form
        getItens()



        blockFields( false )
        isMainButtonSending( false )
        showProxy( false )

        val containerForm = fl_proxy_container.parent as ViewGroup

        //backEndFakeDelay(false, getString( R.string.invalid ))
        val call: Call<ServerResponse> = ApiClient.getClient.updateInvite(invite)
        call.enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call: Call<ServerResponse>?, response: Response<ServerResponse>?) {
                val serverResponse = (response!!.body()!!)


                //1 | 0 (1 caso de certo e 0 caso de algo errado)
                if (serverResponse.updated == false){
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

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_student.text =
            if( status )
                getString( R.string.update_invite_going )
            else
                getString( R.string.update_invite )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()

        et_student_name.validate({
            it.isValidString() }, getString( R.string.invalid_invite_name ))

        bt_nu_student.text = getString( R.string.update_invite )

        bt_nu_student.setOnClickListener{
            mainAction()
        }
        bt_cancel_student.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).onBackPressed()
            }
        )


        fillForm()
    }
    private fun fillForm(){
        invite = arguments!!.getParcelable<Invite>(Invite.KEY)

        et_student_name.setText( invite.name )
        et_student_valor.setText(invite.valor.toString())
        et_student_expected_sales.setText( invite.expectedSales.toString() )
        txt_student_total.setText( invite.total.toString())
    }


}
