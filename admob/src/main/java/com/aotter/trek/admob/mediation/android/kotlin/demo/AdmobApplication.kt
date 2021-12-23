package com.aotter.trek.admob.mediation.android.kotlin.demo

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