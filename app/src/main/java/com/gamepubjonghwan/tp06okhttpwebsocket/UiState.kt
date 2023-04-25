package com.gamepubjonghwan.tp06okhttpwebsocket

data class UiState(
    val name: String = "unknown",
    val age: Int = 0,
    val btnSendIsEnabled: Boolean = false,
    val btnDisconnectEnabled: Boolean = false
)
