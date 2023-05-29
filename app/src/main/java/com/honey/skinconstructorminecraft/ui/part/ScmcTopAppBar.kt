package com.honey.skinconstructorminecraft.ui.part

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.ui.theme.Gray40
import com.honey.skinconstructorminecraft.ui.theme.Gray60
import com.honey.skinconstructorminecraft.ui.theme.Gray70

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScmcTopAppBar(
    modifier: Modifier = Modifier,
    titleNameState: Int,
    onMenuClick: () -> Unit,
    menuOpenedState: State<Boolean>,
    menuButtonVisibility: Boolean
) {
    Column(modifier = modifier) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = titleNameState),
                    style = MaterialTheme.typography.headlineSmall
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Gray70,
                titleContentColor = Gray40
            ),
            actions = {
                if (menuButtonVisibility) ScmcMenuIcon(
                    onMenuClick = onMenuClick,
                    menuOpenedState = menuOpenedState,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(Gray60)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Color.Black)
        )
    }
}

@Composable
fun ScmcMenuIcon(
    modifier: Modifier = Modifier,
    menuOpenedState: State<Boolean>,
    onMenuClick: () -> Unit
) {
    Box(modifier = modifier) {
        if (!menuOpenedState.value) {
            Column(
                modifier = Modifier
                    .size(35.dp)
                    .clickable { onMenuClick.invoke() },
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..2) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(5.dp)
                            .background(Gray40)
                    )
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .size(35.dp)
                    .clickable { onMenuClick.invoke() },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..2) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(5.dp)
                            .background(Gray40)
                    )
                }
            }
        }
    }
}