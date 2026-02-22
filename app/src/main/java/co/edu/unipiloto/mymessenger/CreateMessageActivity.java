package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {

        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, messageText);

        startActivity(intent);
    }
}