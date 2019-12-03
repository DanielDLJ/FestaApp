package br.com.danieldlj.festaapp.ui.post

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.api.ApiClient
import br.com.danieldlj.festaapp.domain.Post
import br.com.danieldlj.festaapp.domain.ServerResponse
import br.com.danieldlj.festaapp.uitl.*
import kotlinx.android.synthetic.main.fragment_new_post.*
import kotlinx.android.synthetic.main.fragment_new_rotation_time.*
import kotlinx.android.synthetic.main.proxy_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class FormNewPostFragment : FormFragment() {

    lateinit var post: Post
    var id: Int? = -1

    override fun getLayoutResourceID() = R.layout.fragment_new_post

    override fun backEndFakeDelay() {

        //Atualizando a variavel post com os itens digitados no form
        getItens()

        blockFields( false )
        isMainButtonSending( false )
        showProxy( false )

        val containerForm = fl_proxy_container.parent as ViewGroup

        //backEndFakeDelay(false, getString( R.string.invalid ))
        val call: Call<ServerResponse> = ApiClient.getClient.createPost(post)
        call.enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call: Call<ServerResponse>?, response: Response<ServerResponse>?) {
                val serverResponse = (response!!.body()!!)


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

        et_post_date.validate({
            it.isValidDate() }, getString( R.string.invalid_date ))

        et_post_horary.validate({
            it.isValidHour() }, getString( R.string.invalid_hour ))


        et_post_what.validate({
            it.isValidString() }, getString( R.string.invalid_what ))
        et_post_notice.validate({
            it.isValidString() }, getString( R.string.invalid_notice ))
        et_post_who.validate({
            it.isValidString() }, getString( R.string.invalid_who ))

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

    fun getItens(){
        post = Post(1,(activity as MainActivity).user.party.id,"","","","","",false)
        post.what = et_post_what.text.toString()
        post.notice = et_post_notice.text.toString()
        post.date = et_post_date.text.toString() + " " + et_post_horary.text.toString()
        post.who = et_post_who.text.toString()
        post.description = et_post_description.text.toString()

        post.date = post.date.getDateTimeBD()
    }

}