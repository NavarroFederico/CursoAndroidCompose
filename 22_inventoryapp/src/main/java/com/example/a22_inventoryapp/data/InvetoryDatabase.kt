package com.example.a22_inventoryapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Clase Database con una instancia singleton
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    //La abstraccion permite que la base de datos sepa sobre el DAO
    abstract fun itemDao(): ItemDao

    //companion object permite acceder a los metodos para crear y obtener la base de datos.
    // usa el nombre de clase como calificador
    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        /**
         * Obtiene la instancia de la base de datos.
         */
        fun getDatabase(context: Context): InventoryDatabase {
            //si la instancia no es nula, la devuelve, sino crea una nueva instancia.
            return Instance ?: synchronized(this) { //
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    // .fallbackToDestructiveMigration() //estrategia para migración
                    .build()
                    .also { Instance = it }
            }
        }
    }
}