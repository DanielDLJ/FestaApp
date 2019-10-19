package br.com.danieldlj.festaapp.ui.allParty

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.AccountSettingsItemsDataBase
import br.com.danieldlj.festaapp.data.AllPartyDataBase
import br.com.danieldlj.festaapp.ui.config.AccountSettingsListAdapter
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_account_settings.*
import kotlinx.android.synthetic.main.content_all_party.*

class AllPartyActivity : AppCompatActivity(){

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
            finish()
            return true
        }
        return super.onOptionsItemSelected( item )
    }

    private fun initItems(){
        rv_parties.setHasFixedSize( false )

        val layoutManager = LinearLayoutManager(this)
        rv_parties.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.getOrientation())
        divider.setDrawable(
            ContextCompat.getDrawable(this,
                R.drawable.light_grey_divider_line
            )!!)
        rv_parties.addItemDecoration( divider )

        rv_parties.adapter =
            AllPartyListAdapter(
                AllPartyDataBase.getItems()
            )
    }


}