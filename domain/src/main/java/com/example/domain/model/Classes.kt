package com.example.domain.model

enum class Classes (override val text : String) : Filter {
    DRUID("Druid"), HUNTER("Hunter"), MAGE("Mage"), PALADIN("Paladin"), ROGUE("Rogue"), SHAMAN("Shaman"), WARLOCK("Warlock"), WARRIOR("Warrior"), DREAM("Dream");
}