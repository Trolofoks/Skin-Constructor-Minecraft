package com.honey.skinconstructorminecraft.ui.screen.constructor.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.R
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem
import com.honey.skinconstructorminecraft.ui.part.ScmcBottomMainMenu
import com.honey.skinconstructorminecraft.ui.part.ScmcButton
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

@Composable
fun ConstructorMainView(
    state: ConstructorState.Showing,
    onSelectItem: (item: SkinItem) -> Unit,
    onSelectCategory: (category: Category) -> Unit
) {
    val bottomMenuWeight = remember { mutableStateOf(0.4f)}

    val height = LocalConfiguration.current.screenHeightDp
    val draggableState = rememberDraggableState { delta ->
        val moveValue = delta.dp.value / height / 2
        val newValue = bottomMenuWeight.value - moveValue
        if (newValue > 0.2f && newValue < 0.8f) bottomMenuWeight.value = newValue
    }

    Column {
        //Here a 3D model
        Box(modifier = Modifier
            .weight(1.0f-bottomMenuWeight.value)
            .fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.test_img),
                contentDescription = "Delete",
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.FillBounds
            )
        }
        ScmcBottomMainMenu(
            modifier = Modifier
                .weight(bottomMenuWeight.value)
                .padding(5.dp),
            draggableItemModifier = Modifier.draggable(
                orientation = Orientation.Vertical,
                state = draggableState
            ),
            itemsList = state.items,
            selectedCategory = state.selectedCategory,
            selectedItem = state.selectedItem,
            onSelectItem = onSelectItem,
            onSelectCategory = onSelectCategory
        )
    }
}