package com.example.domain.core

interface CacheRepository {
    fun putObject(obect : CacheObject, prefix: String? = "")
    fun getObject(key : CacheKey, cacheObjectClass: Class<out CacheObject>, prefix: String? = "") : CacheObject?
    fun deleteObject(key : CacheKey)
}