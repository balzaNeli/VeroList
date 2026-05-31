package com.balzaneli.verolist.ui.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balzaneli.verolist.domain.Todo
import com.balzaneli.verolist.domain.todo1
import com.balzaneli.verolist.domain.todo2
import com.balzaneli.verolist.domain.todo3
import com.balzaneli.verolist.ui.components.TodoItem
import com.balzaneli.verolist.ui.theme.VeroListTheme

@Composable
fun ListScreen(
    todos: List<Todo>
) {
    ListContent(todos = todos)
}

@Composable
fun ListContent(
    todos: List<Todo>
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .consumeWindowInsets(paddingValues),
                contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(todos) { index, todo ->
                TodoItem(
                    todo = todo,
                    onCompletedChange = {},
                    onItemClick = {},
                    onDeleteClick = {},

                )
                if(index < todos.lastIndex){
                    Spacer(modifier = Modifier.height(8.dp))
                }


            }
        }
    }
}



@Preview
@Composable
private fun ListContentPreview() {
    VeroListTheme{
        ListContent(
            todos = listOf(
                todo1,
                todo2,
                todo3,
            )
        )
    }
}