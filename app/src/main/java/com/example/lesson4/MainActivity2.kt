package com.example.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ages: Int = 10
        val name = intent?.getStringExtra("name").orEmpty()
        val age = intent?.getStringExtra("age").orEmpty()
        val ageInt: Int = age.toInt()
        if (ageInt >= ages) {
            name_2.text = "Приветствую друг мой $name"
        } else name_2.text = "Вам еще нет 10 $name"
    }
}