## Jetpack Basics

* Modifier menyimpan semua pengaturan layout, background, border dan semua dukungan terkait ui element
* Terdapat 3 elemen layouting dasar di compose: Column, Row dan Box
* Jika terdapat perubahan pada screen secara realtime, gunakan `State` dan `MutableState`. Agar status tidak direset, bungkus dengan `remember()`