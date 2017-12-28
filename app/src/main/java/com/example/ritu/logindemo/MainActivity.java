package com.example.ritu.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Info = (TextView)findViewById(R.id.tvinfo);

        Info.setText("No. of attempts remaining : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void Validate(String name, String password)
    {
        if (name.equals("Ritu") && password.equals("ritu"))
        {
            Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
            //Info.setText("Logged In");
        }
        else
        {
            counter--;
            Info.setText("No. of attempts remaining : "+counter);
            if (counter==0)
            {
                Login.setEnabled(false);
            }
        }
    }
}
