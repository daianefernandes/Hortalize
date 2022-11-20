package br.com.hortalize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        load()

    }

    private fun load() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val appDb = AppDb.getDatabase(baseContext);
        var questionarios = appDb.questionarioDao().getAll();
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = QuestionarioAdapter(questionarios)

        val itemDecor = DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
    }

    override fun onResume() {
        super.onResume()
        load()
    }
}