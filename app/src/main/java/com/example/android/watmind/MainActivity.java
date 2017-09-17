package com.example.android.watmind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageTextView;
    Button leftButton;
    Button rightButton;
    String[] opening_messages;
    public int messageCounter;

    public void displayMessage(int messageCounter) {
        messageTextView = (TextView) findViewById(R.id.opening_messages);
        messageTextView.setText(opening_messages[messageCounter]);
    }

    public void increment() {
        messageCounter++;
        if (messageCounter == 10) {
            messageCounter = messageCounter - 10;
        }
        displayMessage(messageCounter);
    }

    public void decrement() {
        messageCounter--;
        if (messageCounter == -1) {
            messageCounter = messageCounter + 10;
        }
        displayMessage(messageCounter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageCounter = 0;


        opening_messages = getResources().getStringArray(R.array.opening_messages);

        leftButton = (Button) findViewById(R.id.left_button);
        View.OnClickListener listenerl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        };
        leftButton.setOnClickListener(listenerl);

        rightButton = (Button) findViewById(R.id.right_button);
        View.OnClickListener listenerr =
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        increment();
                    }
                };
        rightButton.setOnClickListener(listenerr);

    }

    public void counsellingClick(View view) {
        Intent i = new Intent(this, Chat.class);
        startActivity(i);
    }

    public void discussionClick(View view) {
        Intent i = new Intent(this, Chat.class);
        startActivity(i);
    }

    public void goalsClick (View view) {
        Intent i = new Intent (this, GoalsActivity.class);
        startActivity(i);
    }

}
