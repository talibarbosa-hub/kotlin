package br.com.talita.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // criando uma Intent
            startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
         finish ()
        }, 3000)

        // startActivity método para iniciar uma atividade
        // Intent método que indica uma instrução de onde está, para onde vai e qual o tempo.
        // this@splashActivity,LoginActivity primeiro parâmetro de onde está e para onde vai
        // class.java caminho(pasta)
        // Segundo parâmetro tempo de duração.
    }
}


