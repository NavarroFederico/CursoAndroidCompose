package com.example.a22_appdescuento.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "calculations")
data class Calculation(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val purchasePrice: Double,
    val discountInPercent: Double,
    val discountInPesos: Double,
    val maximumDiscountInPesos: Double,
    val maxPurchaseLimitPrice: Double,
    val finalPrice: Double,
) {

}
