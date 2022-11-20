package br.com.hortalize

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuestionarioAdapter (private val dataSet: List<Questionario>): RecyclerView.Adapter<QuestionarioAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewQuestionario: TextView

        init {
            textViewQuestionario = view.findViewById(R.id.textViewQuestionario)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.rv_questionario_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val questionario = dataSet[position]
        holder.textViewQuestionario.text = questionario.nome
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}