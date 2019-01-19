package com.example.kothe.a14_sl_reg_log_kothencz_krisztian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button Button_2_reg;
    private EditText Edit_Text_2_username,Edit_Text_2_password,Edit_Text_2_repassword,Edit_Text_2_fullname,Edit_Text_2_phonenum;
    private AdatbazisSegito db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        Button_2_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatRogzites();
                Intent back = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    public void init()
    {
        Edit_Text_2_username = (EditText) findViewById(R.id.Edit_Text_2_username);
        Edit_Text_2_password = (EditText)findViewById(R.id.Edit_Text_2_password);
        Edit_Text_2_repassword = (EditText)findViewById(R.id.Edit_Text_2_repassword);
        Edit_Text_2_fullname = (EditText)findViewById(R.id.Edit_Text_2_fullname);
        Edit_Text_2_phonenum = (EditText)findViewById(R.id.Edit_Text_2_phonenum);

        Button_2_reg = (Button)findViewById(R.id.Button_2_reg);

        db = new AdatbazisSegito(this);
    }
    public void adatRogzites()
    {
        String username = Edit_Text_2_username.getText().toString();
        String password = Edit_Text_2_password.getText().toString();
        String repassword = Edit_Text_2_repassword.getText().toString();
        String fullname = Edit_Text_2_fullname.getText().toString();
        String phonenum = Edit_Text_2_phonenum.getText().toString();



        if (password.equals(repassword))
        {
            boolean eredmeny = db.adatLekerdezes(username,password,fullname,phonenum);
            if (eredmeny >0) {
                Toast.makeText(this,"Minden mezőt ki kell tölteni!!",Toast.LENGTH_SHORT).show();
            }
            else
            {

                Toast.makeText(this,"Adatrögzítés sikeres!!",Toast.LENGTH_SHORT).show();
                Intent main = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(main);
                finish();
            }

        }
        else
        {
            Toast.makeText(this, "A jelszónak egyezniük kell!!", Toast.LENGTH_SHORT).show();
        }
    }
}
