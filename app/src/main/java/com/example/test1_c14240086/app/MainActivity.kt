package com.example.test1_c14240086.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _item1 = findViewById<LinearLayout>(R.id.item1)
        val _item2 = findViewById<LinearLayout>(R.id.item2)
        val _item3 = findViewById<LinearLayout>(R.id.item3)
        val _item4 = findViewById<LinearLayout>(R.id.item4)

        val _detail1 = findViewById<ImageView>(R.id.detail1)
        val _detail2 = findViewById<ImageView>(R.id.detail2)
        val _detail3 = findViewById<ImageView>(R.id.detail3)
        val _detail4 = findViewById<ImageView>(R.id.detail4)

        _item1.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _item2.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _item3.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _item4.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _detail1.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _detail2.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _detail3.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }
        _detail4.setOnClickListener {
            val _itemIntent= Intent (
                this@MainActivity, Detail::class.java)
            startActivity(_itemIntent)
        }

        val _about = findViewById<LinearLayout>(R.id.about)
        val _email = findViewById<LinearLayout>(R.id.email)

        _about.setOnClickListener {
            val _aboutIntent = Intent(
                this@MainActivity, About::class.java
            )
            startActivity(_aboutIntent)
        }

        _email.setOnClickListener {
            val _emailIntent = Intent (Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:C14240086@john.petra.ac.id")
                putExtra(Intent.EXTRA_SUBJECT,"[Campus Activity] ask")
                putExtra(Intent.EXTRA_EMAIL,"Saya ingin bertanya tentang applikasi ini bisa apa ya")
            }
            startActivity(_emailIntent)
        }
    }
}