package com.example.a22_appdescuento.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val calculationRepository: CalculationsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineCalculationRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for []
     */
    override val calculationRepository: CalculationsRepository by lazy {
        OfflineCalculationRepository(CalculationDatabase.getDatabase(context).calculationDao())
    }
}