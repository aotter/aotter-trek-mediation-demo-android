package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo

import android.app.Application


class AdmobApplication : Application() {

    companion object {
        lateinit var context: AdmobApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}