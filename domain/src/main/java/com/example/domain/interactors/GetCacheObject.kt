package com.example.domain.interactors

import com.example.domain.core.*
import com.example.domain.core.exceptions.InvalidCacheKeyException

class GetCacheObject (private val repository: CacheRepository) {

    private var cacheKey : CacheKey? = null
    private lateinit var cacheObjectClass: Class<out CacheObject>

    fun with(cacheKey: CacheKey?, cacheObjectClass: Class<out CacheObject>) : GetCacheObject {
        this.cacheKey = cacheKey
        this.cacheObjectClass = cacheObjectClass
        return this
    }

    @Throws(InvalidCacheKeyException::class)
    fun execute() : CacheObject? {
        if (this.cacheKey == null) {
            throw InvalidCacheKeyException("The object to be stored in cache cannot be null")
        }
        return repository.getObject(cacheKey!!, cacheObjectClass)
    }
}