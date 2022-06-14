package br.com.hortalize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            finish()
        }

        val buttonQuestionario = findViewById<Button>(R.id.buttonQuestionario)
        buttonQuestionario.setOnClickListener {
            val intent = Intent(this, QuestionarioActivity::class.java)
            startActivity(intent)
        }
    }
}