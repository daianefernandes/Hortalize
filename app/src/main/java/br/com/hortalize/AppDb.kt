package br.com.hortalize

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Questionario::class), version = 1)
abstract class AppDb: RoomDatabase(){

    abstract fun questionarioDao(): QuestionarioDao

    companion object {
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getDatabase(context: Context): AppDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDb::class.java,
                    "hortalize")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}