package br.com.talita.estacaohack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Criando meu Shared Preference é onde vai guardar as preferencias no arquivo XML

        val minhaPreferencia = getSharedPreferences("minha-preferencia",Context.MODE_PRIVATE)

        // Criando o Editor para gravar as informações
        val meuEditor = minhaPreferencia.edit()

        // Criando uma Lista para o Spinner
        val listaSexo = arrayListOf("Selecione o sexo", "Feminino", "Masculino", "Não-binário")

        // Criando o  Adapter
        val adapterSexo = ArrayAdapter(
            this@CadastroActivity, android.R.layout.simple_spinner_dropdown_item,listaSexo)
        spnSexo.adapter = adapterSexo // chama o objeto spn informa que é do tipo adapter e vai receber o adapter criado acima
        // parametros: Context, aonde está / Layout / Spinner, o que eu quero que aplique.

        btnRegister.setOnClickListener {
            val nome = edtName.text.toString().trim()
            val sobrenome = edtLastName.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenha.text.toString().trim()

            // Estrutura de verificação

            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this@CadastroActivity, "Por favor, preencha todos os campos!", Toast.LENGTH_LONG).show()
            }else if (spnSexo.selectedItem == "Selecione o sexo"){
                Toast.makeText(this@CadastroActivity, "Por favor, selecione o sexo", Toast.LENGTH_LONG).show()
            }else {
                // Para gravar as informações dentro do SharedPreferences
                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("sobrenome", sobrenome).apply()
                meuEditor.putString("email", email).apply()
                meuEditor.putString("senha", senha).apply()
                meuEditor.putString("sexo", spnSexo.selectedItem.toString()).apply()

                // Cria um alert para SharedPreferences

                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("Sucesso")
                    .setMessage("Usuário cadastrado com sucesso")
                    .setPositiveButton("OK") {_,_ ->// Lambda

                        onBackPressed() // quando clicar no botão ok volta para página anterior, usado ao invés da intent.
                    }
                    .create()
                    .show()
            }
        }
    }
}

// para identar ctrl A + ctrl + Alt + i
