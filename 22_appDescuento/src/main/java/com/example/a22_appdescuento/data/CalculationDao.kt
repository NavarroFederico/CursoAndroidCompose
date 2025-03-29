package com.example.a22_appdescuento.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Database access object to access the DiscountCalculator database
 */
@Dao
interface CalculationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(calculation: Calculation)

    @Update
    suspend fun update(calculation: Calculation)

    @Delete
    suspend fun delete(calculation: Calculation)

    @Query("SELECT * from calculations WHERE id = :id")
    fun getCalculation(id: Int): Flow<Calculation>

    @Query("SELECT * from calculations ")
    fun getAllCalculations(): Flow<List<Calculation>>

}
