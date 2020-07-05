package com.example.domain.core

interface DomainMappable<DomainModelClass : DomainModel> {
    fun asDomainModel() : DomainModelClass
}