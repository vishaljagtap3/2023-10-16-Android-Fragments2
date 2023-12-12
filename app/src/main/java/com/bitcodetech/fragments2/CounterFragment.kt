package com.bitcodetech.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment : Fragment() {

    private lateinit var txtTitle : TextView
    private lateinit var txtCount : TextView
    private lateinit var btnPlus : Button
    private lateinit var btnMinus : Button

    var count = 0
        set(value) {
            field = value
            txtCount.text = "$count"
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.counter_fragment, null)
        initViews(view)

        initListeners()

        return view
    }

    private fun initListeners() {
        btnPlus.setOnClickListener {
            count++
        }

        btnMinus.setOnClickListener {
            count--
        }
    }

    private fun initViews(view : View) {
        txtTitle = view.findViewById(R.id.txtTitle)
        txtCount = view.findViewById(R.id.txtCount)
        btnPlus = view.findViewById(R.id.btnPlus)
        btnMinus = view.findViewById(R.id.btnMinus)
    }

}