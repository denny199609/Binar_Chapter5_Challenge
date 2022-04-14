package com.example.chapter5

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast

fun EditText.getEditText(): String{
    var textedit:String = ""
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textedit =  p0.toString()
        }

        override fun afterTextChanged(p0: Editable?) {
            TODO("Not yet implemented")
        }

    })
    return  textedit
}

fun Context.toast(toastmsg:String){
    Toast.makeText(this,toastmsg,Toast.LENGTH_SHORT).show()
}

//fun Context.intent(activity: Activity, extra:String){
//    Intent(Intent(this,activity::class.java)).apply {
//        putExtra("extra",extra)
//    }
//
//}