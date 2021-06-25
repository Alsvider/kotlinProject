package com.test.kotlinProject.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.test.kotlinProject.annotation.BindEventBus
import com.test.kotlinProject.bean.EventBean
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by wangch on 2021/6/23.
 */
 abstract class BaseFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this::class.java.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().register(this)
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(eventBean: EventBean) {
        handleEvent(eventBean)
    }

    open fun handleEvent(eventBean: EventBean) {

    }

    override fun onDestroy() {
        if (this::class.java.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().unregister(this)
        }
        super.onDestroy()
    }
}