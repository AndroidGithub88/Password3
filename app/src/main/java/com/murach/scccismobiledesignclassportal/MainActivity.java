package com.murach.scccismobiledesignclassportal;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.EditorInfo;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnEditorActionListener,
        OnClickListener
{
    public static final String EXTRA_MESSAGE = "com.murach.scccismobiledesignclassportal";
    private Button SubmitButton;
    private TextView Prompt;
    private TextView UserNameTextView;
    private TextView PasswordTextView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private boolean match, submitOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SubmitButton = (Button) findViewById(R.id.SubmitButton);
        UserNameTextView = (TextView) findViewById(R.id.UserNameTextView);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        PasswordTextView = (TextView) findViewById(R.id.PasswordTextView);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        SubmitButton.setOnClickListener(this);
        usernameEditText.setOnEditorActionListener(this);
        passwordEditText.setOnClickListener(this);
        String usernameString = usernameEditText.getText().toString();
        String passwordString = passwordEditText.getText().toString();

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, ClassScheduale.class);
        EditText editText = (EditText) findViewById(R.id.usernameEditText);
        String message = usernameEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    //@Override
    public void onClick(View v) {

       // String passwordString = passwordEditText.getText().toString();
        //if (passwordString.equalsIgnoreCase("abida")) {
          //  match = true;
            //sendMessage(v);

        if ((v.getId() == R.id.SubmitButton))
            sendMessage(v);
        }


        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String usernameString = usernameEditText.getText().toString();
            String passwordString = passwordEditText.getText().toString();

            switch (v.getId()) {
                case R.id.usernameEditText:
                    if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                        usernameString = usernameEditText.toString();
                    }
                     break;
                    case R.id.passwordEditText:
                     if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                     passwordString = passwordEditText.getText().toString();
                     if (passwordString.equalsIgnoreCase("abida"))
                      match = true;

                     }
            }

            return false;
        }
}
