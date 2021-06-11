package com.test.kotlinProject.extension

import android.content.Context
import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by wangch on 2021/6/10.
 */
class SharePreferenceTool<T>(
    val context: Context,
    val name: String,
    val default: T,
    val preName: String = "default"
) : ReadWriteProperty<Any?, T> {


    private val prefs by lazy {
        context.getSharedPreferences(preName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        setPre(name, value)
    }


    fun setPre(key: String, value: T) {
        when (value) {
            is Int -> prefs.edit().putInt(key, value)
        }
    }

}