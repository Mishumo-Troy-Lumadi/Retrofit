package com.devsa.retrofit

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.textfield.TextInputLayout


class SignInFragment : Fragment() {

    val userId: String = ""
    val userName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val pager = activity?.findViewById<ViewPager2>(R.id.accountsPager)

        view.findViewById<Button>(R.id.btnSignIn).setOnClickListener {

            val email = view.findViewById<TextInputLayout>(R.id.signInEmail).editText?.text
            val password = view.findViewById<TextInputLayout>(R.id.signInPassword).editText?.text
            val rememberMe = view.findViewById<CheckBox>(R.id.chkRememberMe).isChecked

            login(email, password, rememberMe)

        }

        view.findViewById<TextView>(R.id.txtRegister).setOnClickListener {
            pager?.currentItem = 1
        }

        return view
    }

    private fun onRemember() {
        val sharedPreferences =
            requireActivity().getSharedPreferences("Logging", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("RememberMe", true)
        editor.apply()
    }

    private fun login(email: Editable?, password: Editable?, rememberMe: Boolean): Boolean {

        if (rememberMe) {
            onRemember()
        }

        findNavController().navigate(R.id.action_accountFragment_to_homeActivity)

        return true
    }


}