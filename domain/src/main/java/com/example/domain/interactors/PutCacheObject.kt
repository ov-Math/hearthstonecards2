package com.example.domain.interactors

import com.example.domain.core.CacheObject
import com.example.domain.core.CacheRepository
import com.example.domain.core.exceptions.InvalidCacheObjectException

class PutCacheObject (private val repository: CacheRepository) {

    private var cacheObject : CacheObject? = null

    fun with(cacheObject: CacheObject?) : PutCacheObject {
        this.cacheObject = cacheObject
        return this
    }

    @Throws(InvalidCacheObjectException::class)
    fun execute() {
        if (this.cacheObject == null) {
            throw InvalidCacheObjectException(
                "The object to be stored in cache cannot be null"
            )
        }
        repository.putObject(cacheObject!!)
    }
}