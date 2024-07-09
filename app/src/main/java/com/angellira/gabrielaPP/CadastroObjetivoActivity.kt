package com.angellira.gabrielaPP

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angellira.gabrielaPP.databinding.ActivityCadastroObjetivoBinding
import com.angellira.gabrielaPP.models.User

class CadastroObjetivoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroObjetivoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCadastroObjetivoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val proximaPagina = Intent(this, CadastroMedidasActivity::class.java)
        val nomeUsuario = intent.getStringExtra("nameUser")
        val emailUsuario = intent.getStringExtra("emailUser")
        val senhaUsuario = intent.getStringExtra("passwordUser")
        binding.botaoContinuar2.setOnClickListener {
            Log.d("TELA DE CADASTRO OBJETIVO - NOME", nomeUsuario.toString())
            Log.d("TELA DE CADASTRO OBJETIVO - EMAIL", emailUsuario.toString())
            Log.d("TELA DE CADASTRO OBJETIVO - SENHA", senhaUsuario.toString())
            proximaPagina.putExtra("nameUser", nomeUsuario)
            proximaPagina.putExtra("emailUser", emailUsuario)
            proximaPagina.putExtra("passwordUser", senhaUsuario)
            startActivity(proximaPagina)
        }
    }
}