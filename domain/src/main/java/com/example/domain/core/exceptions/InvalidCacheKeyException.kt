package com.example.domain.core.exceptions

import java.lang.Exception

class InvalidCacheKeyException (
    var errorMessage : String,
    var obj : Any? = null) : Exception() {
}