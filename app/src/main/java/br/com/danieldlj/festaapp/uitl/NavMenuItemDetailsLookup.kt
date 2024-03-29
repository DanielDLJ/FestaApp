package br.com.danieldlj.festaapp.uitl

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup


/*
 * ItemDetailsLookup permite que a biblioteca de seleção acesse
 * informações sobre os itens do RecyclerView que receberam um
 * MotionEvent. Ele é efetivamente uma factory para instâncias
 * de ItemDetails que são submetidas a backup (ou extraídas)
 * de uma ocorrência de RecyclerView.ViewHolder.
 * */
class NavMenuItemDetailsLookup( val rvMenuItems: androidx.recyclerview.widget.RecyclerView) : ItemDetailsLookup<Long>() {

    /*
     * Retorna o ItemDetails para o item sob o evento
     * (MotionEvent) ou nulo caso não haja um.
     * */
    override fun getItemDetails( event: MotionEvent): ItemDetails<Long>? {

        val view = rvMenuItems.findChildViewUnder( event.x, event.y )

        if( view != null ){
            val holder = rvMenuItems.getChildViewHolder( view )
            return (holder as NavMenuItemsAdapter.ViewHolder).itemDetails
        }

        return null
    }
}