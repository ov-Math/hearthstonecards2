package com.example.domain.model

enum class Types (override val text : String) : Filter {
    HERO("Hero"), MINION("Minion"), SPELL("Spell"), ENCHANTMENT("Enchantment"), WEAPON("Weapon"), HERO_POWER("Hero Power");
}