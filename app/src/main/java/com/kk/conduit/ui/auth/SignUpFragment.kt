package com.kk.conduit.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.kk.conduit.R
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.android.synthetic.main.fragment_signin.view.*

class SignUpFragment : Fragment() {

    val _authViewModel : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_signin,container,false)
        //  _authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        root.usernameEditText.isVisible  = true
        root.loginButton.text = "SignUp"

        root.loginButton.setOnClickListener {
            _authViewModel.signup(usernameEditText.text.toString(),emailEditText.text.toString(),passwordEditText.text.toString())
        }
/*
        _authViewModel.user.observe({ lifecycle }){
            Toast.makeText(context,"Logged inb as ${it.username}",Toast.LENGTH_LONG).show()
        }
*/
        return root
    }

}