package com.angellira.gabrielaPP

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angellira.gabrielaPP.databinding.ActivityCadastroMedidasBinding

class CadastroMedidasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroMedidasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCadastroMedidasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val proximaPagina = Intent(this, CadastroRestricaoMedActivity::class.java)
        val nomeUsuario = intent.getStringExtra("nameUser")
        val emailUsuario = intent.getStringExtra("emailUser")
        val senhaUsuario = intent.getStringExtra("passwordUser")
        binding.botaoContinuar2.setOnClickListener {
            Log.d("TELA DE CADASTRO MEDIDAS - NOME", nomeUsuario.toString())
            Log.d("TELA DE CADASTRO MEDIDAS - EMAIL", emailUsuario.toString())
            Log.d("TELA DE CADASTRO MEDIDAS - SENHA", senhaUsuario.toString())
            proximaPagina.putExtra("nameUser", nomeUsuario)
            proximaPagina.putExtra("emailUser", emailUsuario)
            proximaPagina.putExtra("passwordUser", senhaUsuario)
            startActivity(proximaPagina)
        }
    }
}