/**
 * Injeção de dependências com Koin:
 * https://medium.com/collabcode/inje%C3%A7%C3%A3o-de-depend%C3%AAncia-no-kotlin-com-koin-4d093f80cb63
 *
 */
package com.ivamotelo.coinconverter.data.di

import android.util.Log
import com.google.gson.GsonBuilder
import com.ivamotelo.coinconverter.data.database.AppDatabase
import com.ivamotelo.coinconverter.data.repository.CoinRepository
import com.ivamotelo.coinconverter.data.repository.CoinRepositoryImpl
import com.ivamotelo.coinconverter.data.services.AwesomeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModules {

    private const val HTTP_TAG = "OhHttp"

    fun load() {
        loadKoinModules(networkModule() + repositoryModule() + databaseModule())
    }

    private fun networkModule(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(HTTP_TAG, ": $it")
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            single {
                createService<AwesomeService>(get(), get())
            }
        }
    }

    private fun repositoryModule(): Module {
        return module {
            single<CoinRepository> { CoinRepositoryImpl(get(), get()) }
        }
    }

    private fun databaseModule(): Module {
        return module {
            single { AppDatabase.getInstance(androidApplication()) }
        }
    }

    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory): T {
        return Retrofit.Builder()
            .baseUrl("https://economia.awesomeapi.com.br")
            .client(client)
            .addConverterFactory(factory)
            .build()
            .create(T::class.java)
    }
}