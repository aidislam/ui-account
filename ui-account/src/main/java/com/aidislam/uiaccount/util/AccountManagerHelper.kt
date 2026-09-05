package com.aidislam.uiaccount.util

import android.accounts.Account
import android.accounts.AccountManager
import android.content.Context
import com.aidislam.uiaccount.model.Account as UIAccount
import com.aidislam.uiaccount.model.AccountType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * AccountManager utility to fetch accounts from Android OS
 * Converts Android AccountManager accounts to UI Account model
 */
class AccountManagerHelper(private val context: Context) {

    private val accountManager: AccountManager = AccountManager.get(context)

    /**
     * Fetch all @aidislam.org email accounts from device
     * Returns empty list if no accounts found
     */
    suspend fun getAidIslamAccounts(): List<UIAccount> = withContext(Dispatchers.IO) {
        try {
            val accounts = accountManager.accounts
            accounts.mapNotNull { account ->
                if (account.name.endsWith("@aidislam.org", ignoreCase = true)) {
                    UIAccount(
                        id = account.name,
                        name = extractNameFromEmail(account.name),
                        email = account.name,
                        isActive = false,
                        accountType = AccountType.USER
                    )
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    /**
     * Get all accounts regardless of email domain
     */
    suspend fun getAllAccounts(): List<UIAccount> = withContext(Dispatchers.IO) {
        try {
            val accounts = accountManager.accounts
            accounts.map { account ->
                UIAccount(
                    id = account.name,
                    name = extractNameFromEmail(account.name),
                    email = account.name,
                    isActive = false,
                    accountType = AccountType.USER
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    /**
     * Extract name from email
     * Example: "aa@aidislam.org" -> "aa"
     * or use first letter of name if available
     */
    private fun extractNameFromEmail(email: String): String {
        return email.substringBefore("@").uppercase().take(1)
    }

    /**
     * Check if any @aidislam.org accounts exist
     */
    suspend fun hasAidIslamAccounts(): Boolean = withContext(Dispatchers.IO) {
        return@withContext getAidIslamAccounts().isNotEmpty()
    }
}
