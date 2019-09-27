package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    CheckBox cbRemember;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        final SharedPreferences sharedPreferences = getSharedPreferences("DataLogin", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(Login.this, "Vui lòng nhập đủ Username và Password", Toast.LENGTH_SHORT).show();
                }else{
                    if (username.equals("admin") && password.equals("123456")){
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        if (cbRemember.isChecked()){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("username", username);
                            editor.putString("password", password);
                            editor.putBoolean("checked", true);
                            editor.commit();
                        }else{
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove("username");
                            editor.remove("password");
                            editor.remove("checked");
                            editor.commit();
                            edtUsername.setText("");
                            edtPassword.setText("");
                            cbRemember.setChecked(false);
                        }

                    }else{
                        Toast.makeText(Login.this, "Username hoặc Password không đúng", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void initView(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        cbRemember = findViewById(R.id.cbRemember);
    }

}
