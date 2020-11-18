package com.example.lesson4

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.answer
import kotlinx.android.synthetic.main.activity_main3.*

private const val COUNT_PREF = "COUNT_PREF"

class MainActivity3 : AppCompatActivity() {

    private var count = 0
    private var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        prefs = PreferenceManager.getDefaultSharedPreferences(this)

        start_btn_fac.setOnClickListener {
            val n = factorial.text.toString()
            val nInt: Int = n.toInt()
            var count: Double = 1.0
            for (i in 1..nInt) {
                count *= i
            }
            answers.text = count.toString()
        }

        count = prefs?.getInt(COUNT_PREF, count)!!
        answers.text = "Count: $count"
    }


    override fun onDestroy() {
        val editor = prefs?.edit()
        editor?.putInt(COUNT_PREF, count)
        editor?.apply()
        super.onDestroy()
    }
}