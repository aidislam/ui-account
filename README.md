# 🎨 ui-account - Material Design 3 Account Management Library

A beautiful, easy-to-use Android Kotlin library for account selection and authentication UI components based on Google's Material Design 3.

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)
![Kotlin](https://img.shields.io/badge/kotlin-1.9.0-purple.svg)
![Android](https://img.shields.io/badge/android-24%2B-brightgreen.svg)

## ✨ Features

- 🎯 **AidIslamAuthButton** - Beautiful account selection button with Material Design 3
- 📋 **AccountSelector** - Dialog-based account selector with elegant UI
- 🎴 **AccountCard** - Detailed account card with description and category
- ❓️ **AccountAvatar** - Reusable avatar component with initial fallback
- 🌈 **Material Design 3** - Complete Material Design 3 theme support
- 🌙 **Dark Mode** - Full dark mode support
- ⚡ **Lightweight** - Minimal dependencies, fast performance
- 📱 **Responsive** - Works perfectly on all Android devices

## 📦 Installation

### Step 1: Add JitPack Repository

In your project's `settings.gradle.kts` (or `settings.gradle`):

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // Add this line
    }
}
```

### Step 2: Add Library Dependency

In your app's `build.gradle.kts` (or `build.gradle`):

```kotlin
dependencies {
    implementation("com.github.aidislam:ui-account:1.0.0")
}
```

Or for Gradle (Groovy):

```gradle
dependencies {
    implementation 'com.github.aidislam:ui-account:1.0.0'
}
```

## 🚀 Quick Start

### 1. Basic Usage - AidIslamAuthButton

```kotlin
import com.aidislam.uiaccount.composables.AidIslamAuthButton
import com.aidislam.uiaccount.model.Account
import androidx.compose.runtime.Composable

@Composable
fun MyAuthScreen() {
    val account = Account(
        id = "user_001",
        name = "Yy",
        email = "aa@aidislam.org",
        isActive = true,
        avatarUrl = "https://example.com/avatar.jpg"
    )
    
    AidIslamAuthButton(
        account = account,
        onClick = {
            // Handle account selection
            println("Account selected: ${account.name}")
        }
    )
}
```

### 2. Account Selector Dialog

```kotlin
import com.aidislam.uiaccount.composables.AccountSelector
import com.aidislam.uiaccount.model.Account, AccountType
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun AccountSelectionScreen() {
    val showDialog = remember { mutableStateOf(true) }
    
    val accounts = listOf(
        Account(
            id = "1",
            name = "Yy",
            email = "aa@aidislam.org",
            isActive = true,
            accountType = AccountType.USER
        ),
        Account(
            id = "2",
            name = "Pioneer Automotive",
            email = "info@pioneer.com",
            isActive = false,
            accountType = AccountType.ORGANIZATION
        )
    )
    
    if (showDialog.value) {
        AccountSelector(
            accounts = accounts,
            onAccountSelected = { selectedAccount ->
                println("Selected: ${selectedAccount.name}")
                showDialog.value = false
            },
            onDismiss = {
                showDialog.value = false
            },
            onAddAccount = {
                // Handle adding new account
                println("Add new account tapped")
            }
        )
    }
}
```

### 3. Account Card

```kotlin
import com.aidislam.uiaccount.composables.AccountCard
import com.aidislam.uiaccount.model.Account

@Composable
fun AccountDetailScreen() {
    val account = Account(
        id = "3",
        name = "AZDMV",
        email = "contact@azdmv.org",
        isActive = false,
        accountType = AccountType.SERVICE
    )
    
    AccountCard(
        account = account,
        description = "Aid Zest Dynamic Modern Vision - Innovative solutions for a brighter future.",
        onClick = {
            println("Card tapped for: ${account.name}")
        }
    )
}
```

### 4. Custom Avatar

```kotlin
import com.aidislam.uiaccount.composables.AccountAvatar

@Composable
fun ProfileAvatar() {
    val account = Account(
        id = "4",
        name = "Aid Islam",
        email = "aidislam@example.com"
    )
    
    AccountAvatar(
        account = account,
        size = 56.dp  // Customizable size
    )
}
```

## 🎨 Theming

The library comes with Material Design 3 theme support out of the box.

### Apply Theme in Your App

```kotlin
import com.aidislam.uiaccount.theme.AidIslamTheme
import androidx.compose.material3.MaterialTheme

@Composable
fun MyApp() {
    AidIslamTheme {
        MaterialTheme {
            // Your app content
            MyScreen()
        }
    }
}
```

### Customize Colors

```kotlin
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme

@Composable
fun MyAppWithCustomTheme() {
    val customColors = lightColorScheme(
        primary = Color(0xFF006E1B),
        secondary = Color(0xFF3F6D4E),
        tertiary = Color(0xFF386662)
    )
    
    MaterialTheme(colorScheme = customColors) {
        // Your app content
    }
}
```

## 📊 Data Models

### Account Model

```kotlin
data class Account(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String? = null,
    val isActive: Boolean = false,
    val accountType: AccountType = AccountType.USER
)

enum class AccountType {
    USER,
    ORGANIZATION,
    SERVICE
}
```

## 🛠️ Complete Example - Full Implementation

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.aidislam.uiaccount.composables.AccountSelector
import com.aidislam.uiaccount.composables.AccountCard
import com.aidislam.uiaccount.model.Account, AccountType
import com.aidislam.uiaccount.theme.AidIslamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AidIslamTheme {
                val showDialog = remember { mutableStateOf(true) }
                
                val accounts = listOf(
                    Account(
                        id = "1",
                        name = "Yy",
                        email = "aa@aidislam.org",
                        isActive = true,
                        accountType = AccountType.USER
                    ),
                    Account(
                        id = "2",
                        name = "Pioneer Automotive",
                        email = "info@pioneer.com",
                        isActive = false,
                        accountType = AccountType.ORGANIZATION
                    ),
                    Account(
                        id = "3",
                        name = "AZDMV",
                        email = "contact@azdmv.org",
                        isActive = false,
                        accountType = AccountType.SERVICE
                    )
                )
                
                Scaffold { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        if (showDialog.value) {
                            AccountSelector(
                                accounts = accounts,
                                onAccountSelected = { account ->
                                    println("Selected: ${account.name}")
                                    showDialog.value = false
                                },
                                onDismiss = { showDialog.value = false },
                                onAddAccount = { 
                                    println("Add account")
                                }
                            )
                        }
                        
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(accounts.size) { index ->
                                AccountCard(
                                    account = accounts[index],
                                    description = when(index) {
                                        0 -> "Personal Account"
                                        1 -> "Iconic vehicles known for their durability and classic design."
                                        else -> "Aid Zest Dynamic Modern Vision - Innovative solutions for a brighter future."
                                    },
                                    onClick = {
                                        println("Tapped: ${accounts[index].name}")
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
```

## 📋 Composable Components

### AidIslamAuthButton

Displays an individual account as a selectable button.

**Parameters:**
- `account: Account` - The account to display
- `onClick: () -> Unit` - Callback when button is clicked
- `modifier: Modifier` - Optional layout modifier
- `isEnabled: Boolean` - Enable/disable the button
- `backgroundColor: Color` - Custom background color
- `contentColor: Color` - Custom content color

### AccountSelector

Dialog for selecting from multiple accounts.

**Parameters:**
- `accounts: List<Account>` - List of accounts to display
- `onAccountSelected: (Account) -> Unit` - Callback for selection
- `onDismiss: () -> Unit` - Callback for dismissal
- `onAddAccount: (() -> Unit)?` - Optional callback for adding new account

### AccountCard

Detailed card display for an account.

**Parameters:**
- `account: Account` - The account to display
- `description: String` - Description text
- `onClick: () -> Unit` - Callback when card is clicked
- `modifier: Modifier` - Optional layout modifier

### AccountAvatar

Avatar component for displaying account image or initial.

**Parameters:**
- `account: Account` - The account to display
- `modifier: Modifier` - Optional layout modifier
- `size: Dp` - Size of the avatar (default: 40.dp)

## 🔗 Using in Different Projects

You can easily copy and paste this library into any Android Kotlin project:

```bash
# Clone or add to your project
implementation("com.github.aidislam:ui-account:1.0.0")

# Or use JitPack URL
# Add to settings.gradle.kts:
maven { url = uri("https://jitpack.io") }
```

## 🚫 Troubleshooting

### Dependency Issues

If you get dependency conflicts, ensure you have the latest versions:

```kotlin
dependencies {
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("io.coil-kt:coil-compose:2.5.0")
}
```

### Theme Not Applied

Make sure you wrap your content with `AidIslamTheme`:

```kotlin
setContent {
    AidIslamTheme {
        // Your content here
    }
}
```

## 📚 Documentation

For more examples and advanced usage, check out:
- [Material Design 3 Guidelines](https://m3.material.io/)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## ⭐️ Author

**Aid Islam**
- GitHub: [@aidislam](https://github.com/aidislam)
- Email: official@aidislam.com 

## 🌟 Support

If you find this library useful, please give it a star! ⭐

---

**Made with ❤️ for beautiful Android UIs**
