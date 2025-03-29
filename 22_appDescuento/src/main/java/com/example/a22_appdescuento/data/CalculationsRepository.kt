package com.example.a22_appdescuento.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Calculation] from a given data source.
 */
interface CalculationsRepository {

    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllCalculationsStream(): Flow<List<Calculation>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getCalculationStream(id: Int): Flow<Calculation?>

    /**
     * Insert item in the data source
     */
    suspend fun insertCalculation(calculation: Calculation)

    /**
     * Delete item from the data source
     */
    suspend fun deleteCalculation(calculation: Calculation)

    /**
     * Update item in the data source
     */
    suspend fun updateCalculation(calculation: Calculation)

}
