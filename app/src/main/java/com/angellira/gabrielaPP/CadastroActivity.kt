package com.angellira.gabrielaPP

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angellira.gabrielaPP.databinding.ActivityCadastroBinding
import com.angellira.gabrielaPP.models.User

class CadastroActivity : AppCompatActivity() {
    var usuario = User()
    private lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val proximaPagina = Intent(this, CadastroObjetivoActivity::class.java)

        binding.botaoContinuar1.setOnClickListener {
            val email = binding.campoEmail.text.toString()
            val password = binding.campoSenha.text.toString()
            val name = binding.campoNome.text.toString()
            val confirmPassword = binding.campoConfirmarSenha.text.toString()
            if (name != "" && email != "" && password != "" && confirmPassword != "" && confirmPassword == password) {
                usuario.setAttributes(
                    name,
                    email,
                    password
                )
                Log.d("TELA DE CADASTRO", usuario.toString()) //ok
                proximaPagina.putExtra("nameUser", usuario.nameUser)
                proximaPagina.putExtra("emailUser", usuario.emailUser)
                proximaPagina.putExtra("passwordUser", usuario.passwordUser)
                startActivity(proximaPagina)
            }
        }
    }
}





