package com.ivamotelo.coinconverter.domain

import com.ivamotelo.coinconverter.core.UseCase
import com.ivamotelo.coinconverter.data.model.ExchangeResponseValue
import com.ivamotelo.coinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoParam<List<ExchangeResponseValue>>() {

    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.list()
    }
}