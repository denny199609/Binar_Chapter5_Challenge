package com.example.chapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter5.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityHomeBinding
    private val name by lazy {
        intent.getStringExtra("nama")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            txtPVP.text = "$name vs Player"
            txtPVC.text = "$name vs CPU"
            val welcome = Snackbar.make(binding.root,"Selamat Datang $name",Snackbar.LENGTH_INDEFINITE)
            welcome.setAction("Tutup"){
                welcome.dismiss()
            }
            welcome.show()
            imgPVC.setOnClickListener {
                navigateToGame(false)
            }
            imgPVP.setOnClickListener {
                navigateToGame(true)
            }
        }
    }

    private fun navigateToGame(mode: Boolean){
        val intent = Intent(Intent(this,MainActivity::class.java)).apply {
            putExtra("nama","$name")
            putExtra("mode",mode)
        }
        startActivity(intent)
    }
//mode 0 pvc, else pvp
}