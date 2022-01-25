package com.exsample.armtravel.ui

import android.app.Application
import com.exsample.armtravel.ui.di.casinoLightMainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import java.util.*

/**
 * Created by Vahe Petrosyan on 3/17/21.
 */
class ArmTravelApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ArmTravelApplication)
            androidFileProperties()
            modules(getKoinModules())
//            modules(remoteModule, sharedRepositoryAppModule)
        }
    }
    fun isSwarmAvailable(): Boolean = true


    fun getAppPackageName(): String? = packageName

    fun getKoinModules(): List<Module> = listOf(
        casinoLightMainModule

    )

    fun getLocales(): List<Locale> = listOf(
        Locale(EN_LOCALE_CODE),
        Locale(RU_LOCALE_CODE),
        Locale(HY_LOCALE_CODE)
    )

    fun getDefaultLocale(): Locale = Locale(EN_LOCALE_CODE)

//    override fun getApplicationFileProvider(): String = BuildConfig.APPLICATION_ID + ".provider"
//
//    override fun getPopupMessageImpl(context: Context): BasePopupMessageImpl =
//        BasePopupMessageImpl(instance)

    companion object {
        const val HY_LOCALE_CODE = "hy"
        const val RU_LOCALE_CODE = "ru"
        const val EN_LOCALE_CODE = "en"
    }
}