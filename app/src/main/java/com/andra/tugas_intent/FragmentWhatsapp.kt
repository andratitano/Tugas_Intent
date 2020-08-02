package com.andra.tugas_intent

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_whatsapp.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentWhatsapp.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentWhatsapp : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whatsapp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_whatsapp.setOnClickListener {
            val code = "62"
            val phoneNumb = et_no_whatsapp.text.toString()
            if (et_no_whatsapp.text.toString().isEmpty() && et_msg_whatsapp.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(
                    context,
                    "Masukkan nomor dan pesan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (phoneNumb.length <= 0) {
                    Toast.makeText(this.context, "Masukkan nomor", Toast.LENGTH_SHORT).show()
                } else {
                    val isWhatsappInstalled: Boolean = whatsappInstalledOrNot("com.whatsapp")

                    if (isWhatsappInstalled) {
                        val pesan = et_msg_whatsapp.text
                        val sendIntent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(
                                "https://wa.me/$code$phoneNumb?text=$pesan"
                            )
                        }
                        startActivity(sendIntent)
                        et_no_whatsapp.setText("")
                        et_msg_whatsapp.setText("")
                    } else {
                        Toast.makeText(
                            this.context,
                            "WhatsApp belum terinstall",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun whatsappInstalledOrNot(uri: String): Boolean {
        val packageManager = activity!!.packageManager
        var app_installed = false
        try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            app_installed = true
        } catch (e: PackageManager.NameNotFoundException) {
            app_installed = false
        }
        return app_installed
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentWhatsapp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentWhatsapp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}