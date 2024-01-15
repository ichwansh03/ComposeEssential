## Jetpack Basics

token: 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

* Modifier menyimpan semua pengaturan layout, background, border dan semua dukungan terkait ui element
* Terdapat 3 elemen layouting dasar di compose: Column, Row dan Box
* Jika terdapat perubahan pada screen secara realtime, gunakan `State` dan `MutableState`. Agar status tidak direset, bungkus dengan `remember()` atau `rememberSaveable()` agar setiap terjadi perubahan rotasi, state tetap disimpan. Selalu gunakan remeber dan mutableState setiap menyimpan perubahan data.
* `LazyColumn()` dan `LazyRow()` sama dengan `RecyclerView`
* Gunakan `Spacer` untuk menberi margin pada setiap elemen.
* `Scaffold` adalah fundamental structure yang memberikan standarisasi layout yang kompleks.
* `NavigationRail` digunakan untuk menghandle navigation bar ketika terjadi perubahan layout ke landscape
* Terdapat 3 window class size: compact, medium dan expanded. Update screen agar lebih fleksibel dengan `WindowSizeClass` (fitur masih experimental)
* Stateful composable function dapat digunakan lebih dari satu function dengan state yang sama.
* Jika kompleksitas data makin scale up, gunakan `ViewModels` untuk menghandle UI state dan akses ke business logic pada layer lainnya
* `AnimatedVisibility` menyediakan properties yang mendukung expand in dan expand out dari sebuah elemen.
* `ComposeTestRule` digunakan untuk melakukan UI test