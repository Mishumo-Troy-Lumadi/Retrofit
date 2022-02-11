package com.devsa.retrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class OnbordingPageTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onbording_page_two, container, false)

        val pager = activity?.findViewById<ViewPager2>(R.id.onboardPager)

        view.findViewById<TextView>(R.id.next2).setOnClickListener {
            pager?.currentItem = 2
        }


        return view
    }


}