# SongAdapterLib [![](https://jitpack.io/v/SongDanielLi/SongAdapterLib.svg)](https://jitpack.io/#SongDanielLi/SongAdapterLib)
A simple recyclerView adapter using ListAdapter, DataBinding and DiffUtil


## Setup gradle
#### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

```
#### Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.SongDanielLi:SongAdapterLib:Tag'
}

```

## Example
### 1. create your own item with databinding
[Set up databinding](https://developer.android.com/topic/libraries/data-binding/start)

```kotlin
class CardRow(override val value: String): BindingItem<CardViewBinding, String>() {
    override val viewType: Int
        get() = R.layout.card_view

    override fun createBinding(parent: ViewGroup, viewType: Int): CardViewBinding {
        return CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBind(binding: CardViewBinding) {
        binding.txtCard.text = value
    }
}
```

### 2. Set the adapter
```kotlin
val adapter = SongAdapter()
recyclerView.adapter = adapter

// create item
val row = CardRow("Test")
// add to adapter
adapter.submitList(listOf(row))
```

## Reference
[Android Kotlin Fundamentals: DiffUtil and data binding with RecyclerView](https://developer.android.com/codelabs/kotlin-android-training-diffutil-databinding#0)

## License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
