package com.kk.conduit

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.kk.api.models.entites.User
import com.kk.conduit.ui.auth.AuthViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val  PREF_AUTH = "pref_auth"
        const val  PREF_TOKEN ="pref_token"
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var authViewModel: AuthViewModel
    private  lateinit var  sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        sharedPref = getSharedPreferences(PREF_AUTH, Context.MODE_PRIVATE)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)



        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        //  val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_feed,
                R.id.nav_my_feed,
                R.id.nav_home,
                R.id.nav_gallery,
                R.id.nav_slideshow
            ), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
        NavigationUI.setupWithNavController(toolbar, navController, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navController)
        //  nav_view.setupWithNavController(navController)


        sharedPref.getString(PREF_TOKEN, null)?.let {
            authViewModel.getCurrentUser(it)
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        }
        authViewModel.user.observe({ lifecycle }) {
            updateMenu(it)
          //  Toast.makeText(this,"Logged in as ${it.username}",Toast.LENGTH_LONG).show()
            navController.navigateUp()
            it?.token?.let { t->
              sharedPref.edit().putString(PREF_TOKEN,t)
                Toast.makeText(this,t+"    put",Toast.LENGTH_LONG).show()
            }

        }
        /* it?.token?.let { t ->

                }
            } ?: run {

                }
            }*/
        //   navController.navigateUp()


    }
    private fun updateMenu(user: User?) {
        when (user) {
            is User -> {
                nav_view.menu.clear()
                nav_view.inflateMenu(R.menu.menu_main_user)
            }
            else -> {
                nav_view.menu.clear()
                nav_view.inflateMenu(R.menu.menu_main_guest)
            }
        }

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
       // val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}