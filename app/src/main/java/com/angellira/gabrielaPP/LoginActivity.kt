package com.angellira.gabrielaPP

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angellira.gabrielaPP.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val proximaPagina = Intent(this, testeActivity::class.java)
        val nomeUsuario = intent.getStringExtra("nameUser")
        val emailUsuario = intent.getStringExtra("emailUser")
        val senhaUsuario = intent.getStringExtra("passwordUser")

        binding.botaoCriarConta.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
        binding.botaoContinuar.setOnClickListener {
            val emailConta = binding.caixaDeEmail.text.toString()
            val senhaConta = binding.caixaDeSenha.text.toString()
            if (emailConta == emailUsuario && senhaUsuario == senhaConta) {
                proximaPagina.putExtra("nameUser", nomeUsuario)
                startActivity(proximaPagina)
            } else {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }
    }
}

