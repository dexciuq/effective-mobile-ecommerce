package com.dexciuq.effective_mobile.data.datasource.remote

import com.dexciuq.effective_mobile.data.model.remote.ProductListDto
import retrofit2.http.GET

interface ApiService {
    @GET("/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getProductList(): ProductListDto
}