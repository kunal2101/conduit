package com.kk.conduit.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.tabs.TabLayout
import com.kk.conduit.R
import kotlinx.android.synthetic.main.fragment_auth.view.*

class AuthFragment : Fragment() {

     private var navController : NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_auth,container,false)

        navController = root.let { Navigation.findNavController(it.findViewById(R.id.nav_auth_host_fragment)) }
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_auth_host_fragment) as NavHostFragment
//         navController = navHostFragment.navController

        root.auth_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
             when(tab?.position) {
                 0 -> {
                     navController?.navigate(R.id.gotoLoginFragmnet)
                 }
                 1 -> {
                     navController?.navigate(R.id.gotoSignUpFragmnet)
                 }
             }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        return root
    }
}