package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        actualizarChat();
    }

    public void onSendMessage(View view) {

        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        if(!messageText.isEmpty()){
            ChatManager.mensajes.add("Cliente: " + messageText);
        }

        messageView.setText(""); // limpiar campo

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
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

    @Override
    protected void onResume() {
        super.onResume();
        actualizarChat();
    }
}