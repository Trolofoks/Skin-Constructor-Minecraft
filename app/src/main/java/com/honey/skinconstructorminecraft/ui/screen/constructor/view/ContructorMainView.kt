package com.honey.skinconstructorminecraft.ui.screen.constructor.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem
import com.honey.skinconstructorminecraft.ui.part.BottomMainMenu
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

@Composable
fun ConstructorMainView(
    state: ConstructorState.Showing,
    onSelectItem: (item: SkinItem) -> Unit,
    onSelectCategory: (category: Category) -> Unit
) {
    Column {
        //Here a 3D model
        Box(modifier = Modifier.weight(0.6f))
        BottomMainMenu(
            modifier = Modifier.weight(0.4f).padding(5.dp),
            itemsList = state.items,
            selectedCategory = state.selectedCategory,
            selectedItem = state.selectedItem,
            onSelectItem = onSelectItem,
            onSelectCategory = onSelectCategory
        )
    }

}