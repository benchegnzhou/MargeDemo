package com.example.myapplication

import android.app.Application
import android.net.http.HttpResponseCache
import com.opensource.svgaplayer.SVGAParser
import java.io.File

/**
 * Created by benchengzhou on 2020/11/16  15:49 .
 * 作者邮箱： mappstore@163.com
 * 功能描述：
 * 类    名：
 * 备    注：
 */

open class MApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initSVGA()
    }

    /**
     * 初始化 SVGAParser 单例
    必须在使用 SVGAParser 单例前初始化
     */
    private fun initSVGA() {
        with(SVGAParser) { shareParser().init(context = applicationContext) }
        val cacheDir = File(applicationContext.applicationContext.cacheDir, "http")
        HttpResponseCache.install(cacheDir, 1024 * 1024 * 360L)
    }

}