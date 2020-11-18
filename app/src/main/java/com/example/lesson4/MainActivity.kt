package com.example.lesson4

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val REQUEST = 1000
private const val COUNT_PREF = "COUNT_PREF"

class MainActivity : AppCompatActivity() {

    private var count = 0
    private var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = PreferenceManager.getDefaultSharedPreferences(this)

        start_btn_name.setOnClickListener {
            val name = edit_text.text.toString()
            val age: String = edit_text2.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            startActivityForResult(intent, REQUEST)
        }

        start_btn_fac.setOnClickListener {
            val n = factorial.text.toString()
            val nInt: Int = n.toInt()
            var count: Double = 1.0
            for (i in 1..nInt) {
                count *= i
            }
            startActivity(Intent(this, MainActivity3::class.java))
        }

        count = prefs?.getInt(COUNT_PREF, count)!!
        answer.text = "Count: $count"

    }

    private fun startService() {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("name", count)
        startService(intent)
    }



}

