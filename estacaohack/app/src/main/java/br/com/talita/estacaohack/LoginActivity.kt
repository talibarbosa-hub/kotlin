package br.com.talita.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)
        // Criando a ação do clique do Botão : Entrar

        btnEntrar.setOnClickListener {
            val usuario = edtNome.text.toString().trim() // edtNome id do campo nome do usuário
            val senha = edtSenha.text.toString().trim()

            val recuperarNome = minhaPreferencia.getString("nome", "Erro no SharedPreference")
            val recuperarSenha = minhaPreferencia.getString("senha", "Erro no 404")

            // condição para verificar se o Usuário e a Senha estão corretos

            if(usuario.isEmpty()){
                // verificando se o usuario está vazio

                    Toast.makeText(this@LoginActivity, "Digite um usuário",Toast.LENGTH_LONG).show()

                // toast (pop up alerta). makeText (método para fazer o alerta)
                // this.LoginActivity primeiro paramentro, aonde vai fazer o toast,
                // segundo parametro mensagem que deve aparecer
                // terceiro paramentro Toast.Leng_Long duração
                // .show(método para aparecer)


                }else if( senha.isEmpty()){

                // Verificando se a senha está vazia
                Toast.makeText(this@LoginActivity, "Digite uma senha", Toast.LENGTH_LONG).show()
            }else if (usuario == recuperarNome) {
                if (senha == recuperarSenha){

                    //Criando uma Intent para direcionar para o Main após Login
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                }else{
                    // Criando um alert para informar que a senha está incorreta

                    AlertDialog.Builder(this@LoginActivity)
                        .setTitle("Erro de Autenticação")
                        .setMessage("Senha incorreta")
                        .setPositiveButton("Ok"){_,_ -> // Lambda função anônima que não precisa definir paramentros, pode ser usada como pasagem de parametro.

                        }
                        .create()
                        .show()

                }
            }else{
                AlertDialog.Builder(this@LoginActivity)
                    .setTitle("Erro de Autenticação")
                    .setMessage("Usuário incorreto")
                    .setPositiveButton("Ok"){_,_ -> // Lambda função anônima que não precisa definir paramentros, pode ser usada como pasagem de parametro.

                    }
                    .create()
                    .show()
            }
        }

        // Criar uma intent
        btncadastrar.setOnClickListener {
            startActivity(Intent(this@LoginActivity,CadastroActivity::class.java))
        }


        }
    }
