package com.example.kothe.a14_sl_reg_log_kothencz_krisztian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Edit_Text_username, Edit_Text_password;
    private Button Button_login,Button_reg;
    private AdatbazisSegito db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = Edit_Text_username.getText().toString().toString();
                String password = Edit_Text_password.getText().toString().toString();
                Boolean res = db.adatLekerdezes(username, password);
                if (res == true) {
                    Intent LoginScreen = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(LoginScreen);
                    Toast.makeText(MainActivity.this, "Sucessfully logged in", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login error", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regist = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(regist);
                finish();
            }
        });

    }
    public void init()
    {
        Edit_Text_username = (EditText)findViewById(R.id.Edit_Text_username);
        Edit_Text_password = (EditText)findViewById(R.id.Edit_Text_password);

        Button_login = (Button)findViewById(R.id.Button_login);
        Button_reg = (Button)findViewById(R.id.Button_reg);

        db = new AdatbazisSegito(this);


    }
}
