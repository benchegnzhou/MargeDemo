package com.example.myapplication.util

import android.content.Context
import org.jetbrains.annotations.NotNull
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * asset获取内容
 */
fun getStringFromAssets(@NotNull context: Context, fileName: String): String {
    try {
        val inputReader = InputStreamReader(
            context?.getAssets().open(fileName)
        )
        val bufReader = BufferedReader(inputReader)
        var line: String? = ""
        var Result: String? = ""
        while (bufReader.readLine().also({ line = it }) != null) Result += line
        return Result!!
    } catch (e: Exception) {
        e.printStackTrace()
        return ""
    }
}