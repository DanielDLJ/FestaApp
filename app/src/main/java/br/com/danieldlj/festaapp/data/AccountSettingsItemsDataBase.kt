package br.com.danieldlj.festaapp.data

import android.content.Context
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.AccountSettingItem
import br.com.danieldlj.festaapp.ui.config.connectiondata.ConnectDataActivity
import br.com.danieldlj.festaapp.ui.config.profile.ProfileActivity


class AccountSettingsItemsDataBase {

    companion object{

        fun getItems( context: Context) = listOf(
            AccountSettingItem(
                context.getString( R.string.setting_item_profile ),
                context.getString( R.string.setting_item_profile_desc ),
                ProfileActivity::class.java
            ),
            AccountSettingItem(
                context.getString( R.string.setting_item_login ),
                context.getString( R.string.setting_item_login_desc ),
                ConnectDataActivity::class.java
            )
        )
    }
}