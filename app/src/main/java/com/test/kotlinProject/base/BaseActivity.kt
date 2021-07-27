package com.test.kotlinProject.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.test.kotlinProject.R
import com.test.kotlinProject.annotation.BindEventBus
import com.test.kotlinProject.bean.EventBean
import com.test.kotlinProject.databinding.BaseIncludeToolbarBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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
        //是否全屏
        if (applyFullScreen()) {
            setFullScreenModel()
        } else if (applyImmersionBar()) {
            setImmersionBar(getStatusBarColor())
        }
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


    /**
     * 是否设置沉浸式状态栏
     *
     * @return
     */
    protected open fun applyImmersionBar(): Boolean {
        return true
    }

    /**
     * 是否设置全屏显示
     *
     * @return
     */
    protected open fun applyFullScreen(): Boolean {
        return false
    }

    /**
     * 系统StatusBar颜色
     *
     * @return
     */
    protected open fun getStatusBarColor(): Int {
        return R.color.colorAccent
    }

    /**
     * 设置系统statusBar颜色
     *
     * @param statusBarColor 状态栏颜色
     */
    protected open fun setImmersionBar(statusBarColor: Int) {
        immersionBar {
            statusBarColor(statusBarColor)
                .keyboardEnable(true)
                .fitsSystemWindows(true)
                .statusBarDarkFont(true, 0.2f)
        }
    }

    /**
     * 全屏App内容填充状态栏
     */
    protected open fun setFullScreenModel() {
        immersionBar {
            keyboardEnable(true)
            statusBarDarkFont(true, 0.2f)
        }
    }


    override fun onDestroy() {
        if (this::class.java.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().unregister(this)
        }
        ARouter.getInstance().destroy()
        super.onDestroy()
    }


}