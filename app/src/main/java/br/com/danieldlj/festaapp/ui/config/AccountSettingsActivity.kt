package br.com.danieldlj.festaapp.ui.config

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.AccountSettingsItemsDataBase
import br.com.danieldlj.festaapp.domain.User
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_account_settings.*


class AccountSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled( true )
        supportActionBar?.setDisplayShowHomeEnabled( true )

        val user = getUser()
        tv_user_connected.text = String.format("%s %s", getString(R.string.connected), user.name)

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
        rv_account_settings_items.setHasFixedSize( false )

        val layoutManager = LinearLayoutManager(this)
        rv_account_settings_items.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.getOrientation())
        divider.setDrawable(ContextCompat.getDrawable(this,
            R.drawable.light_grey_divider_line
        )!!)
        rv_account_settings_items.addItemDecoration( divider )

        rv_account_settings_items.adapter =
            AccountSettingsListAdapter(
                AccountSettingsItemsDataBase.getItems(
                    this
                )
            )
    }

    fun getUser() = intent.getParcelableExtra<User>( User.KEY )

}
