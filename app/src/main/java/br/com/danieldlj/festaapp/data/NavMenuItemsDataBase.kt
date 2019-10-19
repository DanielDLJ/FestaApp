package br.com.danieldlj.festaapp.data

import android.content.Context
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.NavMenuItem


class NavMenuItemsDataBase ( context: Context){
    val items = listOf(
        NavMenuItem(
            R.id.item_dashboard.toLong(), context.getString(R.string.item_dashboard)
        ),
        NavMenuItem(
            R.id.item_expenses.toLong(), context.getString(R.string.item_expenses)
        ),
        NavMenuItem(
            R.id.item_invite.toLong(), context.getString(R.string.item_invite)
        ),
        NavMenuItem(
            R.id.item_rotation.toLong(), context.getString(R.string.item_rotation)
        ),
        NavMenuItem(
            R.id.item_post.toLong(), context.getString(R.string.item_post)
        ),
        NavMenuItem(
            R.id.item_list_rep.toLong(), context.getString(R.string.item_list_rep)
        )
    )

    val itemsLogged = listOf(
        NavMenuItem(
            R.id.item_all_party.toLong(), context.getString(R.string.item_all_party), R.drawable.ic_format_list_numbered_black_24dp
        ),
        NavMenuItem(
            R.id.item_settings.toLong(), context.getString(R.string.item_settings), R.drawable.ic_settings_black_24dp
        ),
        NavMenuItem(
            R.id.item_sign_out.toLong(), context.getString(R.string.item_sign_out), R.drawable.ic_power_settings_new_black_24dp
        )
    )

    fun getLastItemId() = items.last().id

    fun getFirstItemLoggedId() = itemsLogged.first().id


    companion object{
        const val SP_NAME = "SP_NAV_MENU"
        const val SP_ITEM_ID_KEY = "item-id"
        const val SP_IS_ACTIVITY_KEY = "is-activity"
    }

    private fun getSP( context: Context) = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    /*
     * Salva o ID do último item de menu selecionado que
     * aciona um fragmento.
     * */
    fun saveLastSelectedItemFragmentID(context: Context, itemID: Long ){
        val sp = getSP( context )
        sp.edit().putLong( SP_ITEM_ID_KEY, itemID ).apply()
    }

    /*
     * Retorna o ID do último item de menu selecionado que
     * aciona um fragmento.
     * */
    fun getLastSelectedItemFragmentID( context: Context) : Long {
        val sp = getSP( context )
        return sp.getLong( SP_ITEM_ID_KEY, 0 )
    }

    /*
     * Salva se o último item de menu acionado foi ou não
     * um item que aciona uma atividade.
     * */
    fun saveIsActivityItemFired(context: Context, isActivity: Boolean ){
        val sp = getSP( context )
        sp.edit()
            .putBoolean( SP_IS_ACTIVITY_KEY, isActivity )
            .apply()
    }

    /*
     * Informa se o último item de menu acionado foi ou não
     * um item que aciona uma atividade.
     * */
    fun wasActivityItemFired( context: Context) : Boolean {
        val sp = getSP( context )
        return sp.getBoolean( SP_IS_ACTIVITY_KEY, false )
    }


}