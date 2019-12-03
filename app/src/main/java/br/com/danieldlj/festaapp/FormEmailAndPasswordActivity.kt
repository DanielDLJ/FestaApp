package br.com.danieldlj.festaapp

import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import com.blankj.utilcode.util.KeyboardUtils


abstract class FormEmailAndPasswordActivity: FormActivity() {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
    }

    // Método idêntico.
    override fun onDestroy() {
        KeyboardUtils.unregisterSoftInputChangedListener( this )
        super.onDestroy()
    }

    //Método gancho
    open fun isAbleToCallChangePrivacyPolicyConstraints() = true




    //Método único.
    abstract fun isConstraintToSiblingView( isKeyBoardOpened: Boolean ) : Boolean

    //Método único.
    abstract fun setConstraintsRelativeToSiblingView(constraintSet: ConstraintSet, privacyId: Int ) : Unit


}