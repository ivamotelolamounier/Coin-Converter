package com.ivamotelo.coinconverter.domain

import com.ivamotelo.coinconverter.core.UseCase
import com.ivamotelo.coinconverter.data.model.ExchangeResponseValue
import com.ivamotelo.coinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {

    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }

}