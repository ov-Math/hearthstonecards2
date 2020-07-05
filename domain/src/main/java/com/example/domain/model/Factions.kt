package com.example.domain.model

enum class Factions (override val text : String) : Filter {
    HORDE("Horde"), ALLIANCE("Alliance"), NEUTRAL("Neutral")
}