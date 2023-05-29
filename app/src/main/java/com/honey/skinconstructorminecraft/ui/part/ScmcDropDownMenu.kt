package com.honey.skinconstructorminecraft.ui.part

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.ui.theme.Gray30
import com.honey.skinconstructorminecraft.ui.theme.Gray70

@Composable
fun ScmcDropDownMenu(
    modifier : Modifier = Modifier,
    onItemClick: () -> Unit
){
    Box(modifier = modifier) {
        ScmcFrame() {
            Column(modifier = Modifier.padding(10.dp)) {
                for (i in 0..4){
                    Row(modifier = Modifier.clickable { onItemClick.invoke() }.padding(5.dp)) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Icon", tint = Gray70, modifier = Modifier.padding(end = 5.dp))
                        Text(text = "Download", color = Gray70)
                    }
                }
            }
        }
    }
}