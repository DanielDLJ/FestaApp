package br.com.danieldlj.festaapp

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.TextView
import br.com.danieldlj.festaapp.domain.User
import com.makeramen.roundedimageview.RoundedImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    val user = User("Daniel Leme Junior",R.drawable.user,"Tequilada")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_dashboard, R.id.nav_expenses, R.id.nav_invite,
                R.id.nav_rotation, R.id.nav_post, R.id.nav_all_party,
                R.id.nav_settings
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        fillUserHeaderNavMenu()

    }

    private fun fillUserHeaderNavMenu(){
        System.out.println("USeer image: "+user.image)
        System.out.println(user.name)


        val navigationView : NavigationView  = findViewById(R.id.nav_view)
        val headerView : View = navigationView.getHeaderView(0)
        val roundedImageView : RoundedImageView = headerView.findViewById(R.id.iv_user)
        val nameUser : TextView = headerView.findViewById(R.id.tv_user)
        val nameParty : TextView = headerView.findViewById(R.id.tv_party)

        roundedImageView.setImageResource(user.image)
        nameUser.text = user.name
        nameParty.text = user.partyName
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
