package com.honey.skinconstructorminecraft.ui.screen.greeting.view

import android.icu.util.UniversalTimeScale
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.ui.part.ScmcButton
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingState

@Composable
fun GreetingShowView(
    state: GreetingState.Show,
    navigateToConstructor: () -> Unit
){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        ScmcButton(onClick = { navigateToConstructor.invoke() }, modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(0.9f)
            .height(72.dp)
            ) {
            Text(text = "Construct")
        }
        ScmcButton(onClick = { /*TODO*/ }, modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(0.9f)
            .height(72.dp)) {
            Text(text = "Something else")
        }
        ScmcButton(onClick = { /*TODO*/ }, modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(0.9f)
            .height(72.dp)
            ) {
            Text(text = "Something else")
        }
    }

}