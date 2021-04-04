package com.example.lesson3

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.material.internal.ContextUtils.getActivity
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import java.nio.charset.CharsetDecoder

 class ReadJSON {
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}