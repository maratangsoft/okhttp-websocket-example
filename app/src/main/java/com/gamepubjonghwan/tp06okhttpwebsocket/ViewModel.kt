package com.gamepubjonghwan.tp06okhttpwebsocket

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import org.json.JSONObject

class ViewModel: androidx.lifecycle.ViewModel() {
    private lateinit var webSocket: WebSocket

    var inputName by mutableStateOf("")
        private set
    var inputAge by mutableStateOf(0)
        private set

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun updateInputName(name: String){
        inputName = name
//        _uiState.update {
//            it.copy(
//                name = name
//            )
//        }
    }

    fun updateInputAge(age: String){
        try {
            inputAge = age.toInt()
//            _uiState.update {
//                it.copy(
//                    age = age.toInt()
//                )
//            }
        }
        catch (throwable: java.lang.NumberFormatException){
            Log.d("TTT", throwable.message.toString())
        }
    }

    private val webSocketListener = WebSocketListener(
        onOpen = {
            _uiState.update {
                it.copy(
                    btnSendIsEnabled = true,
                    btnDisconnectEnabled = true
                )
            }
        },
        onMessage = { jsonString ->
            val jsonObject = JSONObject(jsonString)
            val name = jsonObject.getString("name")
            val age = jsonObject.getInt("age")

            _uiState.update {
                it.copy(
                    name = name,
                    age = age
                )
            }
        }
    )

    fun connectWebSocket() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://maratangsoft.dothome.co.kr/websocket/websocket.php")
            .build()
        webSocket = client.newWebSocket(request, webSocketListener)
    }

    fun sendMessage() {
        val jsonObject = JSONObject()
        jsonObject.put("name", inputName)
        jsonObject.put("age", inputAge)

        val jsonString = jsonObject.toString()
        Log.d("TTT", jsonString)

        webSocket.send(jsonString)
    }

    fun disconnectWebSocket() {
        webSocket.close(1000, null)
    }
}