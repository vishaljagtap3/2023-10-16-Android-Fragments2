package com.bitcodetech.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var edtCounterFragmentTitle : EditText
    private lateinit var btnAddFragment : Button
    private lateinit var btnRemoveFragment : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

        initListeners()
    }

    private fun initListeners() {
        btnAddFragment.setOnClickListener {
            val counterFragment = CounterFragment()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainContainer, counterFragment, null)
            fragmentTransaction.commit()
        }
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        edtCounterFragmentTitle = findViewById(R.id.edtFragmentCounterTitle)
        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment)
    }
}