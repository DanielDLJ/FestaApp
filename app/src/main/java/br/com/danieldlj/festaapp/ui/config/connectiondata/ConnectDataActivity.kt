package br.com.danieldlj.festaapp.ui.config.connectiondata

import br.com.danieldlj.festaapp.ui.config.ConfigFormActivity
import br.com.danieldlj.festaapp.ui.config.ConfigSectionsAdapter

class ConnectDataActivity : ConfigFormActivity() {

    override fun getSectionsAdapter()
            = ConfigSectionsAdapter(this, supportFragmentManager, FormEmailFragment(), FormPasswordFragment())

}