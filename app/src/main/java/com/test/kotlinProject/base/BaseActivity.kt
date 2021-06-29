package com.test.kotlinProject.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.test.kotlinProject.annotation.BindEventBus
import com.test.kotlinProject.bean.EventBean
import com.test.kotlinProject.databinding.BaseIncludeToolbarBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.zip.Inflater

/**
 * Created by wangch on 2021/6/22.
 */
open class BaseActivity : AppCompatActivity() {
    lateinit var binding: BaseIncludeToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this::class.java.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().register(this)
        }
        ARouter.getInstance().inject(this);
        binding = BaseIncludeToolbarBinding.inflate(layoutInflater)
        var view = getLayoutId()?.let { layoutInflater.inflate(it, null) }
        binding.frameLayout.addView(view)
        setContentView(binding.root)
        initData()
        initListener()
    }

    protected open fun initListener() {
        binding.back.setOnClickListener {
            finish()
        }
    }

    protected open fun getLayoutId(): Int? = null


    protected open fun initData() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: EventBean) {
        handleEvent(event)
    }

    protected open fun handleEvent(eventBean: EventBean) {

    }


    /**
     * 设置右侧按钮内容
     *
     * @param
     */
    protected fun setRightLayout(text: String) {
        showRightIcon(false);
        showRightButton(true);
        binding.btnRight.text = text;
    }

    protected fun setRightIcon(resId: Int) {
//        binding.imgRight.setic
    }

    protected fun showRightButton(show: Boolean) {
        binding.btnRight.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }

    protected fun showRightIcon(show: Boolean) {
        binding.imgRight.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }


    override fun onDestroy() {
        if (this::class.java.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().unregister(this)
        }

        ARouter.getInstance().destroy()
        super.onDestroy()
    }
}