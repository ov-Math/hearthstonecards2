package com.example.domain.interactors

import com.example.domain.core.CacheKey
import com.example.domain.core.CacheRepository

class DeleteCacheObject (private val cacheRepository: CacheRepository) {

    private var cacheKey : CacheKey? = null

    fun with(cacheKey: CacheKey) : DeleteCacheObject {
        this.cacheKey = cacheKey
        return this
    }

    fun execute() {
        cacheRepository.deleteObject(this.cacheKey!!)
    }
}