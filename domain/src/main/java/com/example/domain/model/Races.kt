package com.example.domain.model

enum class Races (override val text : String) : Filter {
    DEMON("Demon"), DRAGON("Dragon"), MECH("Mech"), MURLOC("Murloc"), BEAST("Beast"), PIRATE("Pirate"), TOTEM("Totem");
}