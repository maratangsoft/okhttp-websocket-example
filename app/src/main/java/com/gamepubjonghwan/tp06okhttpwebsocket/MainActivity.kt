package com.gamepubjonghwan.tp06okhttpwebsocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.gamepubjonghwan.tp06okhttpwebsocket.ui.theme.OkHttpWebSocketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OkHttpWebSocketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUi()
                }
            }
        }
    }
}

@Composable
fun MainUi(
    viewModel: ViewModel = ViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column {
        Row {
            Text("INPUT NAME: ")
            Surface(
                color = Color.LightGray
            ) {
                BasicTextField(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 6.dp
                    ),
                    value = viewModel.inputName,
                    onValueChange = { viewModel.updateInputName(it) }
                )
            }

        }
        Spacer(Modifier.height(10.dp))
        Row {
            Text("INPUT AGE: ")
            Surface(
                color = Color.LightGray
            ) {
                BasicTextField(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 6.dp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    value = viewModel.inputAge.toString(),
                    onValueChange = { viewModel.updateInputAge(it) }
                )
            }
        }

        Spacer(Modifier.height(30.dp))
//        Button(
//            onClick = { viewModel.connectWebSocket() },
//            content = { Text("connect") }
//        )
//        Button(
//            onClick = { viewModel.sendMessage() },
//            content = { Text("send") }
//        )
//        Button(
//            onClick = { viewModel.disconnectWebSocket() },
//            content = { Text("disconnect") }
//        )

        Spacer(Modifier.height(30.dp))

        Surface(
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Row {
                Text("Name: ")
                Text(uiState.name)
            }
        }
        Surface(
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Row {
                Text("Age: ")
                Text(uiState.age.toString())
            }
        }
    }
}