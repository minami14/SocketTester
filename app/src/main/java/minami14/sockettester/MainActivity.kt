package minami14.sockettester

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonWebSocket = findViewById<Button>(R.id.buttonWebSocket)
        val buttonTcp = findViewById<Button>(R.id.buttonTcp)
        val buttonUdp = findViewById<Button>(R.id.buttonUdp)
        buttonWebSocket.setOnClickListener{
            val intent = Intent(this, ActivityWebSocket::class.java)
            startActivity(intent)
        }
        buttonTcp.setOnClickListener{
            val intent = Intent(this, ActivityTcp::class.java)
            startActivity(intent)
        }
        buttonUdp.setOnClickListener {
            val intent = Intent(this, ActivityUdp::class.java)
            startActivity(intent)
        }
    }
}
