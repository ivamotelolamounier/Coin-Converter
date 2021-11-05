package com.ivamotelo.coinconverter.domain

import com.ivamotelo.coinconverter.core.UseCase
import com.ivamotelo.coinconverter.data.model.ExchangeResponseValue
import com.ivamotelo.coinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoSource<ExchangeResponseValue>() {

    override suspend fun execute(param: ExchangeResponseValue): Flow<Unit> {
        return flow {
            repository.save(param)
            emit(Unit)
        }
    }
}