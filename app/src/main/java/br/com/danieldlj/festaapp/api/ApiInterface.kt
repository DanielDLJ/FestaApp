package br.com.danieldlj.festaapp.api

import br.com.danieldlj.festaapp.domain.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("party")
    fun getAllParty(): Call<List<Party>>


    //Request para CRUD de DrinkExpenses
    @POST("/party/drink")
    fun getAllDrinkExpenses(@Body party: Party): Call<List<DrinkExpenses>>

    @POST("drink")
    fun getDrinkExpenses(@Body drink: DrinkExpenses): Call<DrinkExpenses>

    @POST("drink/create")
    fun createDrinkExpenses(@Body drink: DrinkExpenses)

    @POST("drink/update")
    fun updateDrinkExpenses(@Body drink: DrinkExpenses)

    @POST("drink/delete")
    fun deleteDrinkExpenses(@Body drink: DrinkExpenses)



    //Request para CRUD de Post
    @POST("party/post")
    fun getAllPost(@Body party: Party): Call<List<Post>>

    @POST("post")
    fun getPost(@Body drink: Post): Call<Post>

    @POST("post/create")
    fun createPost(@Body post: Post): Call<ServerResponse>

    @POST("post/update")
    fun updatePost(@Body post: Post): Call<ServerResponse>

    @POST("post/delete")
    fun deletePost(@Body post: Post)



    //Request para CRUD de Invite
    @POST("party/invite")
    fun getAllInvite(@Body party: Party): Call<List<Invite>>

    @POST("post")
    fun getNotStudentInvite(@Body invite: Invite): Call<Invite>

    @POST("invite/create")
    fun createInvite(@Body invite: Invite): Call<ServerResponse>

    @POST("invite/update")
    fun updateInvite(@Body invite: Invite): Call<ServerResponse>

    @POST("invite/delete")
    fun deleteInvite(@Body invite: Invite)
}