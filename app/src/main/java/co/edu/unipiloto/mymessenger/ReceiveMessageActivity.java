package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra(CreateMessageActivity.EXTRA_MESSAGE);

        TextView messageView = findViewById(R.id.message);
        messageView.setText(messageText);
    }
}