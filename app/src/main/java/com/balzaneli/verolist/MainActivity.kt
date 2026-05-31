package com.balzaneli.verolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.balzaneli.verolist.domain.todo1
import com.balzaneli.verolist.domain.todo2
import com.balzaneli.verolist.domain.todo3
import com.balzaneli.verolist.navigation.TodoNavHost
import com.balzaneli.verolist.ui.feature.ListScreen
import com.balzaneli.verolist.ui.theme.VeroListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VeroListTheme {
                TodoNavHost()
            }
        }
    }
}

