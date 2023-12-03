package kz.just_code.koin

import android.app.Application
import kz.just_code.hilt.data.modules.useCaseModule
import kz.just_code.koin.data.modules.networkModule
import kz.just_code.koin.data.modules.repositoryModule
import kz.just_code.koin.data.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                useCaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}