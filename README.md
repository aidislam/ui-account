# 🎨 ui-account - Material Design 3 Account Management Library

একটি সুন্দর, ব্যবহার করা সহজ Android Kotlin লাইব্রেরি যা Google এর Material Design 3 এর উপর ভিত্তি করে অ্যাকাউন্ট নির্বাচন এবং প্রমাণীকরণ UI কম্পোনেন্ট প্রদান করে।

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)
![Kotlin](https://img.shields.io/badge/kotlin-1.9.0-purple.svg)
![Android](https://img.shields.io/badge/android-24%2B-brightgreen.svg)

## ✨ বৈশিষ্ট্য

- 🎯 **AidIslamAuthButton** - Material Design 3 সহ সুন্দর অ্যাকাউন্ট নির্বাচন বাটন
- 📋 **AccountSelector** - ডায়ালগ-ভিত্তিক অ্যাকাউন্ট নির্বাচক মার্জিত UI সহ
- 📋 **EmptyAccountSelector** - যখন কোনো অ্যাকাউন্ট নেই তখনের জন্য ডিজাইন
- 🎴 **AccountCard** - বর্ণনা এবং বিভাগ সহ বিস্তারিত অ্যাকাউন্ট কার্ড
- 👤 **AccountAvatar** - প্রাথমিক ফলব্যাক সহ পুনঃব্যবহারযোগ্য অ্যাভাটার কম্পোনেন্ট
- 🔐 **AccountManagerHelper** - Android OS-level অ্যাকাউন্ট ইন্টিগ্রেশন
- 🌈 **Material Design 3** - সম্পূর্ণ Material Design 3 থিম সাপোর্ট
- 🌙 **Dark Mode** - সম্পূর্ণ ডার্ক মোড সাপোর্ট
- ⚡ **Lightweight** - ন্যূনতম নির্ভরতা, দ্রুত পারফরম্যান্স
- 📱 **Responsive** - সকল Android ডিভাইসে নিখুঁতভাবে কাজ করে

## 📦 ইনস্টলেশন

### ধাপ 1: JitPack রিপোজিটরি যোগ করুন

আপনার প্রজেক্টের `settings.gradle.kts` (বা `settings.gradle`) এ:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // এই লাইন যোগ করুন
    }
}
```

### ধাপ 2: লাইব্রেরি ডিপেন্ডেন্সি যোগ করুন

আপনার অ্যাপের `build.gradle.kts` (বা `build.gradle`) এ:

```kotlin
dependencies {
    implementation("com.github.aidislam:ui-account:1.0.0")
}
```

অথবা Gradle (Groovy) এর জন্য:

```gradle
dependencies {
    implementation 'com.github.aidislam:ui-account:1.0.0'
}
```

### ধাপ 3: Permissions যোগ করুন (Optional - AccountManager ব্যবহার করলে)

আপনার `AndroidManifest.xml` এ:

```xml
<uses-permission android:name="android.permission.GET_ACCOUNTS" />
```

## 🚀 দ্রুত শুরু

### 1. বেসিক ব্যবহার - AidIslamAuthButton

```kotlin
import com.aidislam.uiaccount.composables.AidIslamAuthButton
import com.aidislam.uiaccount.model.Account, AccountType
import com.aidislam.uiaccount.theme.AidIslamTheme
import androidx.compose.runtime.Composable

@Composable
fun MyAuthScreen() {
    AidIslamTheme {
        val account = Account(
            id = "user_001",
            name = "Yy",
            email = "aa@aidislam.org",
            isActive = true,
            accountType = AccountType.USER,
            avatarUrl = "https://example.com/avatar.jpg"
        )
        
        AidIslamAuthButton(
            account = account,
            onClick = {
                println("অ্যাকাউন্ট নির্বাচিত: ${account.name}")
            }
        )
    }
}
```

### 2. অ্যাকাউন্ট সিলেক্টর ডায়ালগ

```kotlin
import com.aidislam.uiaccount.composables.AccountSelector
import com.aidislam.uiaccount.model.Account, AccountType
import com.aidislam.uiaccount.theme.AidIslamTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun AccountSelectionScreen() {
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
            )
        )
        
        if (showDialog.value) {
            AccountSelector(
                accounts = accounts,
                onAccountSelected = { selectedAccount ->
                    println("নির্বাচিত: ${selectedAccount.name}")
                    showDialog.value = false
                },
                onDismiss = {
                    showDialog.value = false
                },
                onAddAccount = {
                    println("নতুন অ্যাকাউন্ট যোগ করুন")
                }
            )
        }
    }
}
```

### 3. অ্যাকাউন্ট খালি থাকলে (Empty State)

```kotlin
import com.aidislam.uiaccount.composables.EmptyAccountSelector
import com.aidislam.uiaccount.theme.AidIslamTheme

@Composable
fun NoAccountsScreen() {
    AidIslamTheme {
        val showDialog = remember { mutableStateOf(true) }
        
        if (showDialog.value) {
            EmptyAccountSelector(
                onAddAccount = {
                    println("অ্যাকাউন্ট যোগ করুন বাটন টাপ করা হয়েছে")
                },
                onDismiss = {
                    showDialog.value = false
                }
            )
        }
    }
}
```

### 4. Android AccountManager থেকে অ্যাকাউন্ট লোড করুন

```kotlin
import com.aidislam.uiaccount.util.AccountManagerHelper
import com.aidislam.uiaccount.composables.AccountSelector
import com.aidislam.uiaccount.composables.EmptyAccountSelector
import com.aidislam.uiaccount.theme.AidIslamTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.launch

@Composable
fun AccountManagerScreen(context: Context) {
    AidIslamTheme {
        val accounts = remember { mutableStateOf(emptyList<Account>()) }
        val showDialog = remember { mutableStateOf(true) }
        val accountManagerHelper = AccountManagerHelper(context)
        
        // OS থেকে অ্যাকাউন্ট লোড করুন
        LaunchedEffect(Unit) {
            val aidIslamAccounts = accountManagerHelper.getAidIslamAccounts()
            accounts.value = aidIslamAccounts
        }
        
        if (showDialog.value) {
            if (accounts.value.isEmpty()) {
                // কোনো অ্যাকাউন্ট নেই
                EmptyAccountSelector(
                    onAddAccount = { /* নতুন অ্যাকাউন্ট যোগ করুন */ },
                    onDismiss = { showDialog.value = false }
                )
            } else {
                // অ্যাকাউন্ট আছে
                AccountSelector(
                    accounts = accounts.value,
                    onAccountSelected = { account ->
                        println("নির্বাচিত: ${account.name}")
                        showDialog.value = false
                    },
                    onDismiss = { showDialog.value = false },
                    onAddAccount = { /* আরও অ্যাকাউন্ট যোগ করুন */ }
                )
            }
        }
    }
}
```

### 5. Account Card

```kotlin
import com.aidislam.uiaccount.composables.AccountCard
import com.aidislam.uiaccount.model.Account, AccountType
import com.aidislam.uiaccount.theme.AidIslamTheme

@Composable
fun AccountDetailScreen() {
    AidIslamTheme {
        val account = Account(
            id = "3",
            name = "AZDMV",
            email = "contact@azdmv.org",
            isActive = false,
            accountType = AccountType.SERVICE
        )
        
        AccountCard(
            account = account,
            description = "Aid Zest Dynamic Modern Vision - উজ্জ্বল ভবিষ্যতের জন্য উদ্ভাবনী সমাধান।",
            onClick = {
                println("কার্ড ট্যাপ করা হয়েছে: ${account.name}")
            }
        )
    }
}
```

## 🎨 থিমিং

লাইব্রেরি Material Design 3 থিম সাপোর্ট সহ আসে।

### আপনার অ্যাপে থিম প্রয়োগ করুন

```kotlin
import com.aidislam.uiaccount.theme.AidIslamTheme
import androidx.compose.material3.MaterialTheme

@Composable
fun MyApp() {
    AidIslamTheme {
        MaterialTheme {
            // আপনার অ্যাপ কন্টেন্ট
            MyScreen()
        }
    }
}
```

### কাস্টম রঙ সেট করুন

```kotlin
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

@Composable
fun MyAppWithCustomTheme() {
    val customColors = lightColorScheme(
        primary = Color(0xFF006E1B),
        secondary = Color(0xFF3F6D4E),
        tertiary = Color(0xFF386662)
    )
    
    MaterialTheme(colorScheme = customColors) {
        // আপনার অ্যাপ কন্টেন্ট
    }
}
```

## 📊 ডেটা মডেল

### Account Model

```kotlin
data class Account(
    val id: String,                          // অনন্য আইডি
    val name: String,                        // অ্যাকাউন্টের নাম
    val email: String,                       // ইমেইল ঠিকানা
    val avatarUrl: String? = null,           // অ্যাভাটার ইমেজ URL (ঐচ্ছিক)
    val isActive: Boolean = false,           // সক্রিয় অ্যাকাউন্ট?
    val accountType: AccountType = AccountType.USER  // অ্যাকাউন্টের ধরন
)

enum class AccountType {
    USER,           // ব্যক্তিগত ব্যবহারকারী
    ORGANIZATION,   // সংস্থা/কোম্পানি
    SERVICE         // সেবা অ্যাকাউন্ট
}
```

## 🛠️ সম্পূর্ণ উদাহরণ - MainActivity

```kotlin
import android.os.Bundle
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.aidislam.uiaccount.composables.AccountSelector
import com.aidislam.uiaccount.composables.AccountCard
import com.aidislam.uiaccount.composables.EmptyAccountSelector
import com.aidislam.uiaccount.model.Account, AccountType
import com.aidislam.uiaccount.theme.AidIslamTheme
import com.aidislam.uiaccount.util.AccountManagerHelper
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAccountApp(this)
        }
    }
}

@Composable
fun MyAccountApp(context: Context) {
    AidIslamTheme {
        val showDialog = remember { mutableStateOf(true) }
        val accounts = remember { mutableStateOf(emptyList<Account>()) }
        val selectedAccount = remember { mutableStateOf<Account?>(null) }
        val accountManagerHelper = AccountManagerHelper(context)
        val scope = rememberCoroutineScope()
        
        // OS থেকে অ্যাকাউন্ট লোড করুন
        LaunchedEffect(Unit) {
            scope.launch {
                val osAccounts = accountManagerHelper.getAidIslamAccounts()
                accounts.value = if (osAccounts.isNotEmpty()) {
                    osAccounts
                } else {
                    // ডেমো অ্যাকাউন্ট (যদি OS থেকে না পাওয়া যায়)
                    listOf(
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
                }
            }
        }
        
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("AZDMV Account Manager") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // অ্যাকাউন্ট সিলেক্টর ডায়ালগ দেখান
                if (showDialog.value) {
                    if (accounts.value.isEmpty()) {
                        EmptyAccountSelector(
                            onAddAccount = { /* নতুন অ্যাকাউন্ট যোগ করুন */ },
                            onDismiss = { showDialog.value = false }
                        )
                    } else {
                        AccountSelector(
                            accounts = accounts.value,
                            onAccountSelected = { account ->
                                selectedAccount.value = account
                                showDialog.value = false
                            },
                            onDismiss = { showDialog.value = false },
                            onAddAccount = { /* নতুন অ্যাকাউন্ট যোগ করুন */ }
                        )
                    }
                }
                
                // নির্বাচিত অ্যাকাউন্ট দেখান
                if (selectedAccount.value != null) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "নির্বাচিত অ্যাকাউন্ট",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "নাম: ${selectedAccount.value?.name}")
                            Text(text = "ইমেইল: ${selectedAccount.value?.email}")
                            
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = { showDialog.value = true },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("অ্যাকাউন্ট পরিবর্তন করুন")
                            }
                        }
                    }
                }
                
                // সকল অ্যাকাউন্ট কার্ড দেখান
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(accounts.value) { account ->
                        AccountCard(
                            account = account,
                            description = when (account.id) {
                                "1" -> "ব্যক্তিগত অ্যাকাউন্ট - সক্রিয়"
                                "2" -> "তাদের স্থায়িত্ব এবং ক্লাসিক ডিজাইনের জন্য পরিচিত আইকনিক যানবাহন।"
                                else -> "Aid Zest Dynamic Modern Vision - উজ্জ্বল ভবিষ্যতের জন্য উদ্ভাবনী সমাধান।"
                            },
                            onClick = {
                                selectedAccount.value = account
                                showDialog.value = false
                            }
                        )
                    }
                }
            }
        }
    }
}
```

## 📋 Composable কম্পোনেন্টসমূহ

### AidIslamAuthButton

একটি অ্যাকাউন্টকে নির্বাচনযোগ্য বাটন হিসেবে প্রদর্শন করে।

**প্যারামিটার:**
- `account: Account` - প্রদর্শনযোগ্য অ্যাকাউন্ট
- `onClick: () -> Unit` - বাটন ক্লিক করা হলে কল করা হয়
- `modifier: Modifier` - ঐচ্ছিক লেআউট মডিফায়ার
- `isEnabled: Boolean` - বাটন সক্ষম/অক্ষম
- `backgroundColor: Color` - কাস্টম পটভূমি রঙ
- `contentColor: Color` - কাস্টম কন্টেন্ট রঙ

### AccountSelector

একাধিক অ্যাকাউন্ট থেকে নির্বাচন করার জন্য ডায়ালগ।

**প্যারামিটার:**
- `accounts: List<Account>` - প্রদর্শনযোগ্য অ্যাকাউন্টের তালিকা
- `onAccountSelected: (Account) -> Unit` - অ্যাকাউন্ট নির্বাচনের কলব্যাক
- `onDismiss: () -> Unit` - ডায়ালগ বন্ধ হলে কলব্যাক
- `onAddAccount: (() -> Unit)?` - নতুন অ্যাকাউন্ট যোগ করার ঐচ্ছিক কলব্যাক

### EmptyAccountSelector

যখন কোনো অ্যাকাউন্ট পাওয়া যায় না তখনকার ডায়ালগ।

**প্যারামিটার:**
- `onAddAccount: () -> Unit` - নতুন অ্যাকাউন্ট যোগ করার কলব্যাক
- `onDismiss: () -> Unit` - ডায়ালগ বন্ধ হলে কলব্যাক

### AccountCard

একটি অ্যাকাউন্টকে বিস্তারিত কার্ড হিসেবে প্রদর্শন করে।

**প���যারামিটার:**
- `account: Account` - প্রদর্শনযোগ্য অ্যাকাউন্ট
- `description: String` - বর্ণনা টেক্সট
- `onClick: () -> Unit` - কার্ড ক্লিক করা হলে কলব্যাক
- `modifier: Modifier` - ঐচ্ছিক লেআউট মডিফায়ার

### AccountAvatar

অ্যাকাউন্ট ইমেজ বা প্রাথমিক অক্ষর প্রদর্শনের জন্য কম্পোনেন্ট।

**প্যারামিটার:**
- `account: Account` - প্রদর্শনযোগ্য অ্যাকাউন্ট
- `modifier: Modifier` - ঐচ্ছিক লেআউট মডিফায়ার
- `size: Dp` - অ্যাভাটারের আকার (ডিফল্ট: 40.dp)

## 🔐 AccountManagerHelper - Android OS ইন্টিগ্রেশন

```kotlin
val helper = AccountManagerHelper(context)

// শুধুমাত্র @aidislam.org অ্যাকাউন্ট পান
val aidIslamAccounts = helper.getAidIslamAccounts()

// সকল অ্যাকাউন্ট পান
val allAccounts = helper.getAllAccounts()

// @aidislam.org অ্যাকাউন্ট আছে কিনা চেক করুন
val hasAccounts = helper.hasAidIslamAccounts()
```

## 📦 Maven/Gradle কমান্ড

### Terminal থেকে ব্যবহার করুন

```bash
# লাইব্রেরি যোগ করুন (build.gradle.kts এ manually যোগ করুন)
implementation("com.github.aidislam:ui-account:1.0.0")

# প্রজেক্ট বিল্ড করুন
./gradlew build

# অ্যাপ চালান
./gradlew installDebug

# Desktop test
./gradlew test
```

## 🐛 সমস্যা সমাধান

### নির্ভরতা সমস্যা

যদি নির্ভরতা সংঘর্ষ পান, সর্বশেষ সংস্করণ নিশ্চিত করুন:

```kotlin
dependencies {
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
}
```

### থিম প্রয়োগ না হলে

নিশ্চিত করুন আপনার কন্টেন্ট `AidIslamTheme` এ মোড়ানো আছে:

```kotlin
setContent {
    AidIslamTheme {
        // আপনার কন্টেন্ট এখানে
    }
}
```

### AccountManager ত্রুটি

Manifest এ পারমিশন যোগ করুন:

```xml
<uses-permission android:name="android.permission.GET_ACCOUNTS" />
```

## 📚 ডকুমেন্টেশন লিঙ্ক

- [Material Design 3 নির্দেশিকা](https://m3.material.io/)
- [Jetpack Compose ডকুমেন্টেশন](https://developer.android.com/jetpack/compose)
- [GitHub রিপোজিটরি](https://github.com/aidislam/ui-account)

## 📄 লাইসেন্স

এই প্রজেক্ট MIT লাইসেন্সের অধীন - বিস্তারিত জন্য LICENSE ফাইল দেখুন।

## 🤝 অবদান রাখুন

অবদান স্বাগত! দয়া করে একটি Pull Request জমা দিতে পারেন।

## 👨‍💻 লেখক

**Aid Islam**
- GitHub: [@aidislam](https://github.com/aidislam)
- Email: aidislam27@gmail.com

## 🌟 সাপোর্ট

এই লাইব্রেরি উপকারী মনে হলে একটি স্টার দিন! ⭐

---

**সুন্দর Android UI এর জন্য ❤️ দিয়ে তৈরি**
