package com.example.kothe.a14_sl_reg_log_kothencz_krisztian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    private Button Button_logout;
    private EditText Edit_Text_3_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();

        Button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(logout);
                finish();
            }
        });
    }
    public void init()
    {
        Button_logout = (Button)findViewById(R.id.Button_logout);
        Edit_Text_3_username = (EditText)findViewById(R.id.Edit_Text_3_username);
    }
}
