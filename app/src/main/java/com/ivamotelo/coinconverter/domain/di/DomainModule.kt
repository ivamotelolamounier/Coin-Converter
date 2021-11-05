package com.ivamotelo.coinconverter.domain.di

import com.ivamotelo.coinconverter.domain.GetExchangeValueUseCase
import com.ivamotelo.coinconverter.domain.ListExchangeUseCase
import com.ivamotelo.coinconverter.domain.SaveExchangeUseCase
import org.koin.core.module.Module
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModules())
    }

    private fun useCaseModules(): Module {
        return module {
            factory { ListExchangeUseCase(get()) }
            factory { SaveExchangeUseCase(get()) }
            factory { GetExchangeValueUseCase(get()) }
        }
    }
}