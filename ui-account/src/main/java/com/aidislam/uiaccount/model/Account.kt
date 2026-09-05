package com.aidislam.uiaccount.model

data class Account(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String? = null,
    val isActive: Boolean = false,
    val accountType: AccountType = AccountType.USER
)

enum class AccountType {
    USER, ORGANIZATION, SERVICE
}
