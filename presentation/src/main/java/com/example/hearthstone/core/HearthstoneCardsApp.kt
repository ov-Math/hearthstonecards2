package com.example.hearthstone.core

import android.app.Application
import android.content.Context
import android.widget.TextView
import com.example.hearthstone.R
import com.example.hearthstone.core.koin.AppModule
import com.example.hearthstone.core.koin.DataModule
import com.example.hearthstone.core.koin.DomainModule
import com.example.hearthstone.core.koin.PresentationModule
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.calligraphy3.FontMapper
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneCardsApp : Application() {
    companion object {
        lateinit var appContext : Context
    }

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(ViewPump.builder()
            .addInterceptor(CalligraphyInterceptor(
                CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/avenirlstdmedium.otf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            )).build())

        appContext = applicationContext

        startKoin {
            androidContext(appContext)
            modules(listOf(AppModule.get(), DataModule.get(), DomainModule.get(), PresentationModule.get()))
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base!!))
    }
}