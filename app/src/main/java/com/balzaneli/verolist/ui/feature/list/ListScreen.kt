package com.balzaneli.verolist.ui.feature.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.balzaneli.verolist.data.TodoDatabaseProvider
import com.balzaneli.verolist.data.TodoRepositoryImpl
import com.balzaneli.verolist.domain.Todo
import com.balzaneli.verolist.domain.todo1
import com.balzaneli.verolist.domain.todo2
import com.balzaneli.verolist.domain.todo3
import com.balzaneli.verolist.navigation.AddEditRoute
import com.balzaneli.verolist.ui.UiEvent
import com.balzaneli.verolist.ui.components.TodoItem
import com.balzaneli.verolist.ui.feature.addedit.AddEditViewModel
import com.balzaneli.verolist.ui.theme.VeroListTheme

@Composable
fun ListScreen(
    navigateToAddEditScreen: (id: Long?) -> Unit,
) {
    val context = LocalContext.current.applicationContext
    val database = TodoDatabaseProvider.provide(context)
    val repository = TodoRepositoryImpl(dao = database.dao)

    val viewModel = viewModel<ListViewModel>{
        ListViewModel(repository = repository)
    }

    val todos by viewModel.todos.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent){
                is UiEvent.Navigate<*> -> {
                    when(uiEvent.route){
                        is AddEditRoute -> {
                            navigateToAddEditScreen(uiEvent.route.id)
                        }
                    }

                }
                UiEvent.NavigationBack -> {

                }
                is UiEvent.ShowSnackbar -> {

                }
            }
        }
    }



    ListContent(
        todos = todos,
        onEvent = viewModel::onEvent
    )
}


@Composable
fun ListContent(
    todos: List<Todo>,
    onEvent: (ListEvent) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(ListEvent.AddEdit(null))
            }) {
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
                    onCompletedChange = {onEvent(ListEvent.CompleteChanged(todo.id,it))},

                    onItemClick = {onEvent(ListEvent.AddEdit(todo.id))},

                    onDeleteClick = {onEvent(ListEvent.Delete(todo.id))},

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
            ),
            onEvent = {}
        )
    }
}