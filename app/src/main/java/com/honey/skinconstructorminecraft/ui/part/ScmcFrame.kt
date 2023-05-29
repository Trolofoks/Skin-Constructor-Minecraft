package com.honey.skinconstructorminecraft.ui.part

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.ui.theme.Gray10

@Composable
fun ScmcFrame(
    modifier: Modifier = Modifier,
    fillMaxSize: Boolean = false,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Black)
    ) {
        Box(
            modifier = if (fillMaxSize) (
                    Modifier
                        .padding(5.dp)
                        .fillMaxSize()
                        .background(Gray10)
                    ) else (
                    Modifier
                        .padding(5.dp)
                        .background(Gray10)
                    )
        ) {
            content()
        }
    }
}