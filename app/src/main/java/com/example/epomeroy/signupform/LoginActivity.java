package com.example.epomeroy.signupform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private Button submitButton;
    private EditText userNameInput;
    private EditText passwordInput;
    private EditText confirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submitButton = (Button) findViewById(R.id.submit_button);
        userNameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        confirmInput = (EditText) findViewById(R.id.confirm_input);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String confirmation = confirmInput.getText().toString();

                if (password.equals(confirmation)) {
                    Log.d(TAG, "Passwords match");
                    User newUser = new User(username, password);

                    Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                    homeIntent.putExtra(getString(R.string.user_name), newUser);
                    startActivity(homeIntent);
                } else {
                    Log.d(TAG, "Passwords don't match");
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
