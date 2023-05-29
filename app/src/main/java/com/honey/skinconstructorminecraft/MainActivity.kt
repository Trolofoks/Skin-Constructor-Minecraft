package com.honey.skinconstructorminecraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.honey.domain.model.Category
import com.honey.domain.model.SkinItem
import com.honey.skinconstructorminecraft.ui.main.ScmcApp
import com.honey.skinconstructorminecraft.ui.theme.ScmcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScmcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScmcApp()
                }
            }
        }
    }
}

//TODO remove
internal val exampleItem : SkinItem = SkinItem(skinItemId = R.drawable.ic_launcher_foreground, itemDescId = R.string.app_name, category = Category.Head)



