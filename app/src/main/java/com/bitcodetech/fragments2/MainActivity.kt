package com.bitcodetech.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var edtCounterFragmentTitle : EditText
    private lateinit var edtCount : EditText
    private lateinit var btnAddFragment : Button
    private lateinit var btnRemoveFragment : Button

    private val counterFragments = ArrayList<CounterFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        btnAddFragment.setOnClickListener {
            val counterFragment = CounterFragment()

            counterFragments.add(counterFragment)

            val inputBundle = Bundle()
            inputBundle.putString("title", edtCounterFragmentTitle.text.toString())
            inputBundle.putInt("count", edtCount.text.toString().toInt())

            counterFragment.arguments = inputBundle

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainContainer, counterFragment, null)
            fragmentTransaction.commit()
        }

        btnRemoveFragment.setOnClickListener {

            if(counterFragments.size == 0) {
                return@setOnClickListener
            }

            supportFragmentManager.beginTransaction()
                .remove(counterFragments.removeLast())
                .commit()

            /*supportFragmentManager.beginTransaction()
                .remove(counterFragments[counterFragments.size - 1])
                .commit()

            counterFragments.removeLast()*/
        }
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        edtCounterFragmentTitle = findViewById(R.id.edtFragmentCounterTitle)
        edtCount = findViewById(R.id.edtCount)
        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment)
    }
}