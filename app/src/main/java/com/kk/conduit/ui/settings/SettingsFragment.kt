package com.kk.conduit.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.kk.conduit.R
import com.kk.conduit.ui.auth.AuthViewModel
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import java.util.*

class SettingsFragment : Fragment(){

  //  private lateinit var _settingViewModel : SettingViewModel

    private val _authViewModel by activityViewModels<AuthViewModel>()

   private lateinit var roots  : View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          roots = inflater.inflate(R.layout.fragment_settings,container,false)
       // _authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)


        return  roots
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _authViewModel.user.observe({lifecycle}){
           roots.apply {
               bioEditText.setText(it?.bio)
               imageEditText.setText(" $it.image" )
               emailEditText.setText(it.email ?:" ")
               usernameEditText.setText(it.username ?: " ")


           }
        }

        roots.submitButton.setOnClickListener {
            _authViewModel.update(bioEditText.text.toString(),
                usernameEditText.text.toString().takeIf { it.isNotBlank() },
                imageEditText.text.toString(),
                emailEditText.text.toString().takeIf { it.isNotBlank() },
                passwordEditText.text.toString().takeIf { it.isNotBlank() })
        }
    }
}