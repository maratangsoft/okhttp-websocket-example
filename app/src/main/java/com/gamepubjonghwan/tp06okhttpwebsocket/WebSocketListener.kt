package com.gamepubjonghwan.tp06okhttpwebsocket

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okio.ByteString

class WebSocketListener(
    private val onOpen: () -> Unit,
    private val onMessage: (String) -> Unit
): okhttp3.WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
        Log.d("TTT", "onOpen...")

        onOpen.invoke()
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        Log.d("TTT", "onMessage(string)...")

        onMessage.invoke(text)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        Log.d("TTT", "onMessage(byte)...")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        Log.d("TTT", "onClosing...")
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        Log.d("TTT", "onClosed...")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.d("TTT", "onFailure...")

        Log.d("TTT", "throwable: ${t.message}")
    }
}