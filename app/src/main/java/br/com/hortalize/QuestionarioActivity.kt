package br.com.hortalize

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.pocretrofit.GamesApi
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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

        val buttonConcluir = findViewById<Button>(R.id.buttonConcluir)
        buttonConcluir.setOnClickListener {
            val appDb = AppDb.getDatabase(baseContext)
            val cep = findViewById<TextInputEditText>(R.id.textInputEditCep)
            val nome = findViewById<TextInputEditText>(R.id.editTextNome)
            val q1 = findViewById<RadioGroup>(R.id.radioGroup)
            val idx = q1.indexOfChild(q1.findViewById(q1.getCheckedRadioButtonId()))
            val q2 = findViewById<RadioGroup>(R.id.radioGroup2)
            val idx2 = q2.indexOfChild(q2.findViewById(q2.getCheckedRadioButtonId()))
            val q3 = findViewById<RadioGroup>(R.id.radioGroup3)
            val idx3 = q3.indexOfChild(q3.findViewById(q3.getCheckedRadioButtonId()))

            val questionario = Questionario(0, nome.text.toString(), cep.text.toString(), idx.toString(), idx2.toString(), idx3.toString())
            appDb.questionarioDao().insert(questionario)

            finish()
        }
    }
}

private fun updateUI(cep: Cep, textViewCep: TextView) {
    textViewCep.setText("CEP: "+cep.cep+"\n\r"+"Logradouro: "+cep.logradouro+"\n\r"+"Bairro: "+cep.bairro+"\n\r"+"Localidade: "+cep.localidade+"\n\r"+"Uf: "+cep.uf+"\n\r")
}