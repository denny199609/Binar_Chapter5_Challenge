package com.example.chapter5

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar

class ThirdLanding : Fragment() {
    var txtNama:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt = view.findViewById<EditText>(R.id.textName)
        val btn = view.findViewById<ImageView>(R.id.btnNext)
        btn.setOnClickListener { viewnew ->
            navigateToHome(txt.text.toString())
        }
    }
    private fun navigateToHome(nama:String){
        if (nama.trim() == "" || nama == null) {

            val snackbar = Snackbar.make(view!!.rootView,"Isikan nama dulu",Snackbar.LENGTH_SHORT)
            snackbar.show()
            return
        }
        val intent = Intent(Intent(context, HomeActivity::class.java)).apply {
            putExtra("nama",nama)
        }
        startActivity(intent)
    }

}