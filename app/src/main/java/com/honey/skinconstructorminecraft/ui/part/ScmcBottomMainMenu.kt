package com.honey.skinconstructorminecraft.ui.part

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem
import com.honey.skinconstructorminecraft.ui.theme.*
import com.honey.skinconstructorminecraft.ui.theme.Gray30
import com.honey.skinconstructorminecraft.ui.theme.Gray60
import com.honey.skinconstructorminecraft.ui.theme.Gray70
import com.honey.skinconstructorminecraft.ui.theme.Green30
import com.honey.skinconstructorminecraft.ui.theme.Green40

@Composable
fun ScmcBottomMainMenu(
    modifier: Modifier = Modifier,
    draggableItemModifier: Modifier,
    itemsList: List<SkinItem>,
    selectedCategory: Category,
    selectedItem: SkinItem?,
    onSelectItem: (item: SkinItem) -> Unit,
    onSelectCategory: (category: Category) -> Unit
) {


    ScmcFrame(
        modifier = modifier,
        fillMaxSize = true
    ) {
        Column {
            Box {
                ScmcTabLayout(
                    modifier = Modifier,
                    onTabClick = onSelectCategory,
                    selectedCategory = selectedCategory
                )
                Box(
                    modifier = draggableItemModifier
                        .padding(top = 5.dp)
                        .height(5.dp)
                        .width(50.dp)
                        .align(Alignment.TopCenter)
                        .background(
                            Gray70
                        )
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Color.Black))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Gray30)
                .padding(bottom = 5.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(LocalConfiguration.current.screenWidthDp / 96),
                content = {
                    //TODO Add real lists
                    for (i in itemsList) {
                        item {
                            ScmcItem(
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
fun ScmcTabLayout(
    modifier: Modifier = Modifier,
    onTabClick: (category: Category) -> Unit,
    selectedCategory: Category
) {
    LazyRow(
        modifier = modifier
            .background(Gray20)
            .fillMaxWidth(),
        content = {
            Category.values().forEach() { category ->
                item {
                    ScmcCategoryTab(
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
fun ScmcCategoryTab(
    onTabClick: (category: Category) -> Unit,
    tabCategory: Category,
    selectedCategory: Category
) {
    val selected = (selectedCategory == tabCategory)
    Box(
        modifier = Modifier
            .background(if (selected) Gray30 else Gray20)
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
fun ScmcItem(
    item: SkinItem,
    selectedItem: SkinItem?,
    onItemSelect: (item: SkinItem) -> Unit
) {
    val selected = (item == selectedItem)
    Box(
        modifier = Modifier
            .size(96.dp)
            .padding(5.dp)
            .background(if (selected) Green40 else Gray60)
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

