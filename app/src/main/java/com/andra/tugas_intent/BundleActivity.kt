package com.andra.tugas_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bundle.*

class BundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) { }

        val bundle = intent.extras
        val outputNama = bundle!!.getString("nama")
        val outputUmur = bundle!!.getInt("umur").toString()

        tv_nama_bundle.setText("Nama: $outputNama")
        tv_umur_bundle.setText("Umur: $outputUmur Tahun")

        btn_back_bundle.setOnClickListener {
            finish()
        }
    }
}