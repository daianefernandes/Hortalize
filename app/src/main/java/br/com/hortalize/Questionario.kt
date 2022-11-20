package br.com.hortalize

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questionario")
data class Questionario(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                        @NonNull @ColumnInfo(name = "nome") val nome: String,
                        @NonNull @ColumnInfo(name = "cep") val cep: String,
                        @NonNull @ColumnInfo(name = "q1")val questaoum: String,
                        @NonNull @ColumnInfo(name = "q2")val questaodois: String,
                        @NonNull @ColumnInfo(name = "q3")val questaotres: String)
