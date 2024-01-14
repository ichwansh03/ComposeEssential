package com.ichwan.learn.composeessential.basic.state

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ichwan.learn.composeessential.R

//@Preview
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = "Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
    )
}

//@Preview(showBackground = true)
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape))
        Text(text = stringResource(id = text), modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp), style = MaterialTheme.typography.bodyMedium)
    }
}

private val alignYourBodyData: List<Pair<Int, Int>> = listOf(
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
)

//@Preview(showBackground = true)
@Composable
fun AlignYourBodyLazyRow(modifier: Modifier = Modifier) {
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        items(alignYourBodyData) { (drawableRes, text) -> AlignYourBodyElement(drawableRes, text) }
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(255.dp)) {
            Image(painter = painterResource(id = drawable), contentDescription = null)
            Text(text = stringResource(id = text), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(16.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun FavoritCollectionGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)) {
        items(alignYourBodyData) { (drawableRes, text) -> FavoriteCollectionCard(drawableRes, text) }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = true, 
            onClick = { }, 
            icon = { Icon(imageVector = Icons.Default.Notifications, contentDescription = null) }, 
            label = { Text(text = "Notification")}
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(imageVector = Icons.Default.Call, contentDescription = null) },
            label = { Text(text = "Call")}
        )
    }
}

@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier){
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {  },
                icon = { Icon(imageVector = Icons.Default.Notifications, contentDescription = null) },
                label = { Text(text = "Notification")}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                selected = false,
                onClick = {  },
                icon = { Icon(imageVector = Icons.Default.Call, contentDescription = null) },
                label = { Text(text = "Call")}
            )
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.app_name) {
            AlignYourBodyLazyRow()
        }
        HomeSection(title = R.string.app_name) {
            FavoritCollectionGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun MySootheAppPotrait() {
    Scaffold (bottomBar = { SootheBottomNavigation() }){
        HomeScreen(Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun MySootheAppLandscape() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Row {
            SootheNavigationRail()
            HomeScreen()
        }
    }
}
