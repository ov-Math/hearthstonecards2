package com.example.domain.core.exceptions

import com.example.domain.model.Filter
import java.lang.Exception

class InvalidFilterException (override val message : String,
                              val filter : Filter? = null) : Exception() {
}