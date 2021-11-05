/**
 * https://docs.awesomeapi.com.br/api-de-moedas
 */
package com.ivamotelo.coinconverter.data.services

import com.ivamotelo.coinconverter.data.model.ExchangeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AwesomeService {
    @GET("/json/last/{coins}")
    suspend fun exchangeValue(@Path("coins") coins: String): ExchangeResponse
}