package br.com.talita.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

        val name = minhaPreferencia.getString("nome", "Erro : sharedPreferences")
        val lastName = minhaPreferencia.getString("sobrenome", "Erro : sharedPreferences")
        val sexo = minhaPreferencia.getString("sexo", "Erro : sharedPreferences")
        val emailmessage = minhaPreferencia.getString("email", "Erro: sharedPreferences")

        txvNomeUsuario.text ="$name $lastName"
        txvEmail.text = emailmessage
        txvSexo.text = sexo


        btnSair.setOnClickListener{
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finishAffinity()
        }

        btnSite.setOnClickListener{
            startActivity(Intent(this@MainActivity,WebActivity::class.java))
        }
    }

}


