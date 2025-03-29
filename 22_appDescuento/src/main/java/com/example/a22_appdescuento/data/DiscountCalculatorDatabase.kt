package com.example.a22_appdescuento.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [Calculation::class], version = 1, exportSchema = false)
/**
 * Definición de la base de datos
 */
abstract class CalculationDatabase : RoomDatabase() {
    /**
     * Obtiene el DAO para acceder a la base de datos
     */
    abstract fun calculationDao(): CalculationDao

    companion object {
        @Volatile
        private var Instance: CalculationDatabase? = null

        /**
         * Obtiene la instancia de la base de datos
         */
        fun getDatabase(context: Context): CalculationDatabase {

            /**
             * Si la instancia no es nula, la devuelve, sino crea una nueva instancia
             */
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, CalculationDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}