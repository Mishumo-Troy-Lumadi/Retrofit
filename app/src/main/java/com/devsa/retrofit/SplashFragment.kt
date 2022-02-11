package com.devsa.retrofit

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({
            if (onBoardingFinished()) {
                if (loggedIn()) {
                    if (rememberMe()) {
                        gotoHomeActivity()
                    } else {
                        gotoAccounts()
                    }
                } else {
                    gotoAccounts()
                }
            } else {
                gotoOnBoarding()
            }
        }, 3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun gotoOnBoarding() {
        findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
    }

    private fun gotoHomeActivity() {
        findNavController().navigate(R.id.action_splashFragment_to_homeActivity)
    }

    private fun gotoAccounts() {
        findNavController().navigate(R.id.action_splashFragment_to_accountFragment)
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPreferences =
            requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("Finished", false)
    }

    private fun loggedIn(): Boolean {
        val sharedPreferences =
            requireActivity().getSharedPreferences("Logging", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("LoggedIn", false)
    }

    private fun rememberMe(): Boolean {
        val sharedPreferences =
            requireActivity().getSharedPreferences("Logging", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("RememberMe", false)
    }

}