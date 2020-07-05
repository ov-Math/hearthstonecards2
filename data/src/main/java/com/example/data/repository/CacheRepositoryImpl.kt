package com.example.data.repository

import android.content.Context
import android.util.Log
import com.example.domain.core.CacheKey
import com.example.domain.core.CacheObject
import com.example.domain.core.CacheRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

class CacheRepositoryImpl (var context : Context) : CacheRepository {

    private val TAG = "CACHE_REPOSITORY_IMPL"
    private val builder = GsonBuilder()
    private val gson: Gson = builder
        .serializeNulls()
        .create()
    private val cacheFileExtesion = "ckd"

    override fun putObject(obect: CacheObject, prefix: String?) {
        try {
            val cacheFileName = if(prefix.isNullOrBlank()) getCacheFileName(obect.cacheKey!!) else "${prefix}_${getCacheFileName(obect.cacheKey!!)}"
            val json = toJSON(obect)

            context.openFileOutput(cacheFileName, Context.MODE_PRIVATE).use {
                it.write(json.toByteArray())
                it.close()
            }

        } catch (e: Exception) {
            Log.e(TAG, "PUT_OBJECT - ${obect.cacheKey} = ${e.localizedMessage}")
        }
    }

    override fun getObject(key: CacheKey, cacheObjectClass: Class<out CacheObject>, prefix: String?): CacheObject? {
        try {

            val cacheFileName = if(prefix.isNullOrBlank()) getCacheFileName(key) else "${prefix}_${getCacheFileName(key)}"
            val cacheObjectJSON = readCacheFile(cacheFileName)
            return gson.fromJson(cacheObjectJSON, cacheObjectClass)

        } catch (e: Exception) {
            return null
        }
    }

    override fun deleteObject(key: CacheKey) {
        val cacheFileName = getCacheFileName(key)
        try {
            val cacheFile = File(context.filesDir, cacheFileName)
            if(cacheFile.exists())
                cacheFile.delete()
        } catch (e : Exception) {
            Log.e(TAG, "ERROR DELETING - $cacheFileName")
            e.printStackTrace()
        }
    }

    private fun toJSON(cacheObject: CacheObject): String {
        return gson.toJson(cacheObject)
    }

    private fun getCacheFileName(cacheKey: CacheKey): String {
        val fileName = cacheKey.toString()
        return "$fileName.$cacheFileExtesion"
    }

    private fun readCacheFile(cachekey: String): String? {
        val inputStream = context.openFileInput(cachekey)
        val json = inputStream.bufferedReader().use { it.readText() }
        inputStream.close()
        return json
    }

}