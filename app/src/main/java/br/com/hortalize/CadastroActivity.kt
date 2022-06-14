package br.com.hortalize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            finish()
        }
    }
}