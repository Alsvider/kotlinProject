package com.test.kotlinProject.annotation

/**
 * Activity或者Fragment需要绑定EventBus，添加此注解即可。
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindEventBus