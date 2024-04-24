package com.example.a16_mycity.data

import com.example.a16_mycity.R
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation

object LocalRecommendationsDataProvider {
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.park_gral_galarza,
                descriptionResourceId = R.string.park_gral_galarza_description,
                address =R.string.park_gral_galarza_address,
                openingHours =R.string.park_gral_galarza_openingHours,
                imageResourceId =R.drawable.parque_general_galarza,
                category = CategoryType.Parks
            ),
            Recommendation(
                id = 2,
                titleResourceId =R.string.park_plebistero_hein,
                descriptionResourceId =R.string.park_plebistero_description,
                address =R.string.park_plebistero_address,
                openingHours =R.string.park_plebistero_openingHours,
                imageResourceId =R.drawable.parque_plebistero_hein,
                category = CategoryType.Parks
            ),
            Recommendation(
                id = 3,
                titleResourceId =R.string.camping_municipal,
                descriptionResourceId =R.string.camping_municipal_description,
                address =R.string.camping_municipal_address,
                openingHours =R.string.camping_municipal_openingHours,
                imageResourceId =R.drawable.camping_municipal,
                category = CategoryType.Parks
            ),
            Recommendation(
                id = 4,
                titleResourceId =R.string.shopping_supermercado_el_chino,
                descriptionResourceId =R.string.shopping_supermercado_el_chino_description,
                address =R.string.shopping_supermercado_el_chino_adrees,
                openingHours =R.string.shopping_supermercado_el_chino_openHours,
                imageResourceId =R.drawable.supermercado_el_chino,
                category = CategoryType.ShoppingCenters
            ),
            Recommendation(
                id = 5,
                titleResourceId =R.string.shopping_supermercado_lyl,
                descriptionResourceId =R.string.shopping_supermercado_lyl_description,
                address =R.string.shopping_supermercado_lyl_adrees,
                openingHours =R.string.shopping_supermercado_lyl_openHours,
                imageResourceId =R.drawable.supermercado_l_y_l,
                category = CategoryType.ShoppingCenters
            ),
            Recommendation(
                id = 6,
                titleResourceId =R.string.shopping_panaderia,
                descriptionResourceId =R.string.shopping_panaderia_description,
                address =R.string.shopping_panaderia_address,
                openingHours =R.string.shopping_panaderia_openingHours,
                imageResourceId =R.drawable.panaderia_los_guris,
                category = CategoryType.ShoppingCenters
            ),
            Recommendation(
                id = 7,
                titleResourceId =R.string.housing_alojamiento,
                descriptionResourceId =R.string.housing_alojamiento_description,
                address =R.string.housing_alojamiento_address,
                openingHours =R.string.housing_alojamiento_openingHours,
                imageResourceId =R.drawable.alojamiento_mari_y_roberto,
                category = CategoryType.Housing
            ),
            Recommendation(
                id = 8,
                titleResourceId =R.string.housing_rancho,
                descriptionResourceId =R.string.housing_rancho_description,
                address =R.string.housing_rancho_address,
                openingHours =R.string.housing_rancho_openingHours,
                imageResourceId =R.drawable.rancho_aparte,
                category = CategoryType.Housing
            ),
            Recommendation(
                id = 9,
                titleResourceId =R.string.housing_bungalow,
                descriptionResourceId =R.string.housing_bungalow_description,
                address =R.string.housing_bungalow_address,
                openingHours =R.string.housing_bungalow_opening,
                imageResourceId =R.drawable.bungalows,
                category = CategoryType.Housing
            ),
            Recommendation(
                id = 10,
                titleResourceId =R.string.government_bombero,
                descriptionResourceId =R.string.gobernment_bombero_description,
                address =R.string.gobernment_bombero_address,
                openingHours =R.string.gobernment_bombero_openingHours,
                category = CategoryType.GovernmentOffices
            ),

            Recommendation(
                id = 11,
                titleResourceId =R.string.government_hospital,
                descriptionResourceId =R.string.gobernment_hospital_description,
                address =R.string.gobernment_hospital_address,
                openingHours =R.string.gobernment_hospital_openingHours,
                category = CategoryType.GovernmentOffices
            ),
            Recommendation(
                id = 12,
                titleResourceId =R.string.government_iglesia,
                descriptionResourceId =R.string.gobernment_iglesia_description,
                address =R.string.gobernment_iglesia_description,
                openingHours =R.string.gobernment_iglesia_openingHours,
                category = CategoryType.GovernmentOffices
            ),
            Recommendation(
                id = 13,
                titleResourceId =R.string.government_municipalidad,
                descriptionResourceId =R.string.gobernment_municipalidad_description,
                address =R.string.camping_municipal_address,
                openingHours =R.string.gobernment_municipalidad_openingHours,
                category = CategoryType.GovernmentOffices
            ),
            Recommendation(
                id = 14,
                titleResourceId =R.string.government_comisaria,
                descriptionResourceId =R.string.gobernment_comisaria_description,
                address =R.string.gobernment_comisaria_address,
                openingHours =R.string.gobernment_comisaria_openingHours,
                category = CategoryType.GovernmentOffices
            ),
        )
    }
}