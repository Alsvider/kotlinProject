package com.test.kotlinProject.base

import com.test.kotlinProject.BuildConfig
import com.test.kotlinProject.config.Config

/**
 * Created by wangch on 2021/7/27.
 */
open class BaseRequest(isNeed: Boolean) : HashMap<String, String>() {
    init {
        put("dt", Config.DEVICE_TYPE) //设备类型
        put("version", BuildConfig.VERSION_CODE.toString()) //APP版本

    }


}