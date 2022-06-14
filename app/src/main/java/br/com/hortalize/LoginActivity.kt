package br.com.hortalize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            finish()
        }

        val textViewCriarConta = findViewById<TextView>(R.id.textViewCriarConta)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        textViewCriarConta.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
        buttonLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}