package com.example.cashbook.DataBase

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [MyDatabase::class], version = 1, exportSchema = false)
abstract class DatabaseAction : RoomDatabase() {
    abstract val getAllIncomesDao: DatabaseLists


    override fun clearAllTables() {}

    companion object {
        private const val DB_NAME = "MyDatabase.db"

        @Volatile
        private var instance: DatabaseAction? = null
        @Synchronized
        fun getInstance(context: Context): DatabaseAction? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): DatabaseAction {
            return Room.databaseBuilder(
                context,
                DatabaseAction::class.java,
                DB_NAME
            ).build()
        }
    }
}