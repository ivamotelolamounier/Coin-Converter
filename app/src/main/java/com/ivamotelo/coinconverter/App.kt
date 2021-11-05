/**
 * https://app.quicktype.io/
 */
package com.ivamotelo.coinconverter

import android.app.Application
import com.ivamotelo.coinconverter.data.di.DataModules
import com.ivamotelo.coinconverter.domain.di.DomainModule
import com.ivamotelo.coinconverter.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModules.load()
        DomainModule.load()
        PresentationModule.load()
    }
}