package com.example.a22_appdescuento.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Calculation] from a given data source.
 */
class OfflineCalculationRepository(private val calculationDao: CalculationDao) :
    CalculationsRepository {
    override fun getAllCalculationsStream(): Flow<List<Calculation>> =
        calculationDao.getAllCalculations()

    override fun getCalculationStream(id: Int): Flow<Calculation?> =
        calculationDao.getCalculation(id)

    override suspend fun insertCalculation(calculation: Calculation) =
        calculationDao.insert(calculation)

    override suspend fun deleteCalculation(calculation: Calculation) =
        calculationDao.delete(calculation)

    override suspend fun updateCalculation(calculation: Calculation) =
        calculationDao.update(calculation)

}