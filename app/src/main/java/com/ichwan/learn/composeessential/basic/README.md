## Jetpack Basics

token: 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

* Modifier menyimpan semua pengaturan layout, background, border dan semua dukungan terkait ui element
* Terdapat 3 elemen layouting dasar di compose: Column, Row dan Box
* Jika terdapat perubahan pada screen secara realtime, gunakan `State` dan `MutableState`. Agar status tidak direset, bungkus dengan `remember()` atau `rememberSaveable()` agar setiap terjadi perubahan rotasi, state tetap disimpan
* `LazyColumn()` dan `LazyRow()` sama dengan `RecyclerView`
* 