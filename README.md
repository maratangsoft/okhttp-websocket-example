Android OkHTTP WebSocket Example
================================

Android에서 OkHTTP를 이용하여 웹소켓 통신을 시도하는 간단한 예제입니다.
아직 웹소켓 서버를 구축하지 않아 실제로 통신은 되지 않습니다.

UI는 Compose와 ViewModel를 이용해서 간단하게 만들었습니다.
compose 브랜치는 서버 통신을 고려하지 않고 MVVM 패턴의 UI갱신만 연습해보는 브랜치입니다.

A small example for trying to transfer data with web socket server in Android with OkHTTP.
I haven't built a websocket server yet, so actual communication is not possible.

The UI was made with Compose and ViewModel.
The 'compose' branch is a branch that only practices updating the UI of MVVM pattern, without considering server communication.

implemented external libraries
----------------------------
* androidx.compose
* androidx.lifecycle.ViewModel
* androidx.lifecycle.StateFlow
* com.squareup.okhttp3