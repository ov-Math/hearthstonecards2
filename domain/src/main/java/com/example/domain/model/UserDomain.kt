package com.example.domain.model

import com.example.domain.core.CacheKey
import com.example.domain.core.CacheObject
import com.example.domain.core.DomainModel

class UserDomain (var username : String,
                  var name : String = "Khadgar") : DomainModel, CacheObject(CacheKey.USER) {
}