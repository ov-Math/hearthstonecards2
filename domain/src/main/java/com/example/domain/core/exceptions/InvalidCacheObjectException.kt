package com.example.domain.core.exceptions

import java.lang.Exception

class InvalidCacheObjectException (
    var errorMessage : String,
    var obj : Any? = null) : Exception() {
}