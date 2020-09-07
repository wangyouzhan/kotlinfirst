package com.avic.kotlinfirst

import android.app.Application
import android.content.Context
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import com.avic.kotlinfirst.mvpsample.di.component.DaggerMVPAppComponent
import com.avic.kotlinfirst.mvpsample.di.component.MVPAppComponent
import com.avic.kotlinfirst.mvpsample.di.module.MVPAppModule
import com.avic.kotlinfirst.mvpsample.di.module.MVPNetModule
import com.avic.kotlinfirst.mvvmsample.di.component.DaggerMVVMAppComponent
import com.avic.kotlinfirst.mvvmsample.di.component.MVVMAppComponent
import com.avic.kotlinfirst.mvvmsample.di.module.MVVMAppModule
import com.avic.kotlinfirst.mvvmsample.di.module.MVVMNetModule
import com.avic.kotlinfirst.usingdagger2.di.component.ApplicationComponent
import com.avic.kotlinfirst.usingdagger2.di.component.DaggerApplicationComponent
import com.avic.kotlinfirst.usingdagger2.di.module.AppModule
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.logging.Logger

class InitApp : Application() {

    companion object {
        val log = Logger.getLogger(InitApp::class.java.name)

        fun get(context: Context): InitApp {
            return context.applicationContext as InitApp
        }
    }

    override fun onCreate() {
        super.onCreate()

        val fontRequest = FontRequest(
            "com.google.android.gms.fonts",
            "com.google.android.gms",
            "Noto Color Emoji Compat",
            R.array.com_google_android_gms_fonts_certs
        )
        val config = FontRequestEmojiCompatConfig(this, fontRequest)
        EmojiCompat.init(config)


        //数据库
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .name("example.realm").build()
        Realm.setDefaultConfiguration(realmConfiguration)

    }

    fun component(): ApplicationComponent {
        val appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }

    fun mvpComponent(): MVPAppComponent {
        val appComponent = DaggerMVPAppComponent.builder()
            .mVPAppModule(MVPAppModule(this))
            .mVPNetModule(MVPNetModule())
            .build()
        return appComponent


    }

    fun mvvmCommponent(): MVVMAppComponent {
        val appComponent = DaggerMVVMAppComponent.builder()
            .mVVMAppModule(MVVMAppModule(this))
            .mVVMNetModule(MVVMNetModule())
            .build()
        return appComponent
    }


}