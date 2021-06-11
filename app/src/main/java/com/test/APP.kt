package com.test

import android.app.Application

/**
 * Created by wangch on 2021/6/11.
 */


class  APP : Application() {
    companion object{
        lateinit var instance:Application
    }
    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}