package com.example.quotes.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotes.viewmodel.SharedViewModel

@Composable
fun Home(
    viewModel: SharedViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var text_a by viewModel.text_a
        var text_b by viewModel.text_b
        var id by viewModel.id


        Body(
            text_a = text_a,
            text_b = text_b,
            id = id,
            onNameChange = {
                text_a = it
            },
            onAgeChange = {
                text_b = it
            },
            onIdChange = {
                id = it
            },
            onPush = {
                viewModel.push()
            },
            onUpdate = {
                viewModel.update()
            },
            onDelete = {
                viewModel.delete()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(
    text_a: String,
    text_b: String,
    id: String,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onIdChange: (String) -> Unit,
    onPush: () -> Unit,
    onUpdate: () -> Unit,
    onDelete: () -> Unit
) {
    TextField(
        value = text_a,
        onValueChange = onNameChange
    )

    Spacer(modifier = Modifier.height(40.dp))

    TextField(
        value = text_b,
        onValueChange = onAgeChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )

    Spacer(modifier = Modifier.height(40.dp))

    TextField(
        value = id,
        onValueChange = onIdChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )

    Spacer(modifier = Modifier.height(40.dp))

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Push(
            onPush = onPush
        )

        Update(
            onUpdate = onUpdate
        )

        Delete(
            onDelete = onDelete
        )
    }
}


@Composable
fun Push(
    onPush: () -> Unit
) {
    Button(onClick = onPush) {
        Text(text = "push")
    }
}

@Composable
fun Delete(
    onDelete: () -> Unit
) {
    Button(onClick = onDelete) {
        Text(text = "delete")
    }
}

@Composable
fun Update(
    onUpdate: () -> Unit
) {
    Button(onClick = onUpdate) {
        Text(text = "update")
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Body(
            text_a = "",
            text_b = "",
            id = "",
            onNameChange = {},
            onAgeChange = {},
            onIdChange = {},
            onPush = {},
            onUpdate = {},
            onDelete = {}
        )
    }
}