package minami14.sockettester

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_tcp.*
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

class ActivityWebSocket : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_socket)
        var client: WebSocketClient? = null
        val buttonConnect = findViewById<Button>(R.id.buttonConnect)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            try {
                client?.send(textMessage.text.toString())
            }catch (ex: Exception){
                textReceive.text = ex.toString()
            }
        }

        buttonConnect.setOnClickListener {
            try{
                val uri = URI(textServer.text.toString())
                client = object : WebSocketClient(uri){
                    override fun onOpen(handshakedata: ServerHandshake?) {
                        textReceive.text = "Open"
                    }

                    override fun onClose(code: Int, reason: String?, remote: Boolean) {
                        textReceive.text = "Close"
                    }

                    override fun onMessage(message: String?) {
                        textReceive.text = message
                    }

                    override fun onError(ex: Exception?) {
                        textReceive.text = ex.toString()
                    }
                }
                client?.connect()
            }catch (ex: Exception){
                textReceive.text = ex.toString()
            }
        }
    }
}
