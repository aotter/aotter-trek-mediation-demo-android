package com.aotter.max.mediation.demo

import android.app.Application


class MaxApplication : Application() {

    companion object {
        lateinit var context: MaxApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}