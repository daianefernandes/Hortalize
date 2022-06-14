package br.com.hortalize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import br.com.fiap.pocretrofit.GamesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.widget.TextView

class QuestionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionario)
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            finish()
        }


        val textInputEditCep = findViewById<TextInputEditText>(R.id.textInputEditCep)
        val textViewCep = findViewById<TextView>(R.id.textViewCep)
        textInputEditCep.setOnFocusChangeListener { view, b ->
            if (!b) {
                val coroutineScope = CoroutineScope(Dispatchers.IO)
                coroutineScope.launch {
                    try {
                        val result = GamesApi.RETROFIT_SERVICE.getCep(textInputEditCep.text.toString())

                        withContext(Dispatchers.Main){
                            updateUI(result, textViewCep)
                        }
                    }catch (e: Exception){
                        Log.i("RETROFIT","Failure: ${e.message}")
                    }
                }
            }
        }
    }
}

private fun updateUI(cep: Cep, textViewCep: TextView) {
    textViewCep.setText("CEP: "+cep.cep+"\n\r"+"Logradouro: "+cep.logradouro+"\n\r"+"Bairro: "+cep.bairro+"\n\r"+"Localidade: "+cep.localidade+"\n\r"+"Uf: "+cep.uf+"\n\r")
}