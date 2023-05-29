package com.honey.skinconstructorminecraft.ui.part

import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.ui.theme.*
import com.honey.skinconstructorminecraft.ui.theme.Gray60
import com.honey.skinconstructorminecraft.ui.theme.Gray70
import com.honey.skinconstructorminecraft.ui.theme.Trans50Black
import com.honey.skinconstructorminecraft.ui.theme.Trans50White

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScmcButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val colorScheme = remember { mutableStateOf(ScmcButtonColors()) }

    val buttonModifier = modifier.pointerInteropFilter { event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                colorScheme.value = ScmcButtonColors(button = Gray60, StartAndTopShadow = Trans30Black, EndAndBottomShadow = Trans30White)
            }
            MotionEvent.ACTION_UP -> {
                colorScheme.value = ScmcButtonColors()
                onClick.invoke()
            }
        }
        true
    }

    ScmcFrame(modifier = buttonModifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.value.button)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(colorScheme.value.StartAndTopShadow)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxHeight()
                    .width(5.dp)
                    .background(colorScheme.value.StartAndTopShadow)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(colorScheme.value.EndAndBottomShadow)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .fillMaxHeight()
                    .width(5.dp)
                    .background(colorScheme.value.EndAndBottomShadow)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                content()
            }
        }
    }
}

data class ScmcButtonColors(
    val button : Color = Gray70,
    val StartAndTopShadow : Color = Trans50White,
    val EndAndBottomShadow : Color = Trans50Black
)