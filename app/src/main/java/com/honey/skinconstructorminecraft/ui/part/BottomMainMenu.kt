package com.honey.skinconstructorminecraft.ui.part

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem
import com.honey.skinconstructorminecraft.ui.theme.Gray10
import com.honey.skinconstructorminecraft.ui.theme.Gray30
import com.honey.skinconstructorminecraft.ui.theme.Gray50
import com.honey.skinconstructorminecraft.ui.theme.Green30
import com.honey.skinconstructorminecraft.ui.theme.Green40

@Composable
fun BottomMainMenu(
    modifier: Modifier = Modifier,
    itemsList: List<SkinItem>,
    selectedCategory: Category,
    selectedItem: SkinItem?,
    onSelectItem: (item: SkinItem) -> Unit,
    onSelectCategory: (category: Category) -> Unit
) {
//    val selectedCategory = remember { mutableStateOf<Category>(Category.HEAD) }
//    val selectedItem = remember{ mutableStateOf<SkinItem?>(null)}

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
                .background(Gray10)
        ) {
            TabLayout(
                modifier = Modifier.padding(bottom = 5.dp),
                onTabClick = onSelectCategory,
                selectedCategory = selectedCategory
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(LocalConfiguration.current.screenWidthDp/96),
                content = {
                    //TODO Add real lists
                    for (i in itemsList){
                        item {
                            Item(
                                item = SkinItem(skinItemId = i.skinItemId),
                                selectedItem = selectedItem,
                                onItemSelect = onSelectItem
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun TabLayout(
    modifier: Modifier = Modifier,
    onTabClick: (category: Category) -> Unit,
    selectedCategory: Category
) {
    LazyRow(
        modifier = modifier
            .background(Green30)
            .fillMaxWidth(),
        content = {
            Category.values().forEach() { category ->
                item {
                    CategoryTab(
                        tabCategory = category,
                        onTabClick = onTabClick,
                        selectedCategory = selectedCategory
                    )
                }
            }
        }
    )
}

@Composable
fun CategoryTab(
    onTabClick: (category: Category) -> Unit,
    tabCategory: Category,
    selectedCategory: Category
) {
    val selected = (selectedCategory == tabCategory)
    Box(
        modifier = Modifier
            .background(if (selected) Green40 else Green30)
            .size(64.dp)
            .clickable {
                onTabClick.invoke(tabCategory)
            },
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = tabCategory.imageId),
            contentDescription = "Category Item",
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
fun Item(
    item: SkinItem,
    selectedItem : SkinItem?,
    onItemSelect : (item: SkinItem)-> Unit
) {
    val selected = (item == selectedItem)
    Box(
        modifier = Modifier
            .size(96.dp)
            .padding(5.dp)
            .background(if (selected) Green40 else Gray50)
            .clickable { onItemSelect.invoke(item) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .background(Gray30),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = item.skinItemId),
                contentDescription = "Item",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

