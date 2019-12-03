package br.com.danieldlj.festaapp.ui.allParty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.LoginActivity
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.api.ApiClient
import br.com.danieldlj.festaapp.data.AccountSettingsItemsDataBase
import br.com.danieldlj.festaapp.data.AllPartyDataBase
import br.com.danieldlj.festaapp.domain.Party
import br.com.danieldlj.festaapp.ui.config.AccountSettingsListAdapter
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_account_settings.*
import kotlinx.android.synthetic.main.content_all_party.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllPartyStartActivity : AppCompatActivity(){

    val allparty = ArrayList<Party>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_all_party )
        setSupportActionBar( toolbar )

        supportActionBar?.setDisplayHomeAsUpEnabled( true )
        supportActionBar?.setDisplayShowHomeEnabled( true )

        initItems()
    }

    override fun onOptionsItemSelected( item: MenuItem): Boolean {
        if( item.itemId == android.R.id.home ){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected( item )
    }

    private fun initItems(){
        rv_parties.setHasFixedSize( false )

        val layoutManager = LinearLayoutManager(this)
        rv_parties.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.getOrientation())
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.light_grey_divider_line)!!)
        rv_parties.addItemDecoration( divider )
        rv_parties.adapter = AllPartyStartListAdapter(this,allparty)
        getData()
    }


    fun getData() {
        println("list")
        val call: Call<List<Party>> = ApiClient.getClient.getAllParty()
        call.enqueue(object : Callback<List<Party>> {
            override fun onResponse(call: Call<List<Party>>?, response: Response<List<Party>>?) {
                allparty.addAll(response!!.body()!!)
                rv_parties.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Party>>?, t: Throwable?) {
                println("onFailure")
            }
        })
    }


    override fun onBackPressed() {
        var intent : Intent  = Intent(this, LoginActivity::class.java)
        startActivity( intent )
        finish()
    }


    fun leave(returnParty:Party) {
        if(returnParty.id != -1) {
            var intent : Intent  = Intent(this, MainActivity::class.java)
            intent.putExtra(Party.KEY, returnParty)
            startActivity( intent )
            finish()
        }else{
            finish()
        }
    }


}