package com.example.domain.model

enum class Qualities (override val text : String) : Filter {
    FREE("Free"), COMMON("Common"), RARE("Rare"), EPIC("Epic"), LEGENDARY("Legendary");
}