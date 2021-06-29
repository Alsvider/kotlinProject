package com.test.kotlinProject

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by wangch on 2021/6/11.
 */


class  APP : Application() {
    companion object{
        lateinit var instance:Application
    }
    override fun onCreate() {
        super.onCreate()
        instance =this
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}