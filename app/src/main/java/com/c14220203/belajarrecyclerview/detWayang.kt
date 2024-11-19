package com.c14220203.belajarrecyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class detWayang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_det_wayang)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _ivFoto = findViewById<ImageView>(R.id.ivFoto)
        val _tvNama = findViewById<android.widget.TextView>(R.id.tvNama)
        val _tvDetail = findViewById<android.widget.TextView>(R.id.tvDetail)

        val dataIntent = intent.getParcelableExtra<wayang>("kirimData",
            wayang::class.java)
        if(dataIntent != null){
            Picasso.get()
                .load(dataIntent.foto)
                .into(_ivFoto)
            _tvNama.setText(dataIntent.nama)
            _tvDetail.setText(dataIntent.deskripsi)
        }
    }
}