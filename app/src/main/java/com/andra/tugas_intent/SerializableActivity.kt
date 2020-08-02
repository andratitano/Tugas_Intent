package com.andra.tugas_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_serializable.*

class SerializableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) { }

        val dataSeri = intent.getSerializableExtra("SERIALIZE_ID") as SerializeName
        val outputNama = dataSeri.nama
        val outputumur = dataSeri.umur.toString()

        tv_nama_serializable.setText("Nama: $outputNama")
        tv_umur_serializable.setText("Umur: $outputumur Tahun")

        btn_back_serializable.setOnClickListener {
            finish()
        }
    }
}