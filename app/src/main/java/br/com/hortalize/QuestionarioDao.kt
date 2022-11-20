package br.com.hortalize

import androidx.room.*

@Dao
interface QuestionarioDao {
    @Query("SELECT * FROM questionario ORDER BY nome ASC")
    fun getAll(): List<Questionario>

    @Insert
    fun insert(vararg enquete: Questionario)

    @Query("SELECT * FROM questionario WHERE id = :id")
    fun getById(id:Int): Questionario
}