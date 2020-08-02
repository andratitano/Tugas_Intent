package com.andra.tugas_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_parcelable.*

class ParcelableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) { }


        val dataParcel = intent.getParcelableExtra<ParcelName>("PARCEL_ID") as ParcelName
        val outputNama = dataParcel.nama
        val outputumur = dataParcel.umur.toString()

        tv_nama_parcelable.setText("Nama: $outputNama")
        tv_umur_parcelable.setText("Umur: $outputumur Tahun")

        btn_back_parcelable.setOnClickListener {
            finish()
        }

    }
}