package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        actualizarChat();
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarChat();
    }

    public void onSendMessage(View view) {

        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        if(!messageText.isEmpty()){
            ChatManager.mensajes.add("Estación: " + messageText);
        }

        messageView.setText("");

        Intent intent = new Intent(this, CreateMessageActivity.class);
        startActivity(intent);
    }

    private void actualizarChat() {

        TextView chatView = findViewById(R.id.chatHistory);

        StringBuilder historial = new StringBuilder();
        for(String m : ChatManager.mensajes){
            historial.append(m).append("\n");
        }

        chatView.setText(historial.toString());
    }
}