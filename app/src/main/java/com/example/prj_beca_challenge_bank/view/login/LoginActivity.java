package com.example.prj_beca_challenge_bank.view.login;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prj_beca_challenge_bank.R;
import com.example.prj_beca_challenge_bank.utils.Alert;
import com.example.prj_beca_challenge_bank.view.details.DetailsActivity;

public class LoginActivity extends AppCompatActivity {

    private Context context;
    private TextInputEditText etUser;
    private TextInputEditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeVariables();
        initializeActions();
    }

    private void initializeVariables() {
        context = LoginActivity.this;
        //
        etUser = findViewById(R.id.loginEtUser);
        etPassword = findViewById(R.id.loginEtPassword);
        //
        btnLogin = findViewById(R.id.loginBtnLogin);
    }

    private void initializeActions() {
        buttonLoginOnClick();
    }


    private void buttonLoginOnClick() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmptyField();
            }
        });
    }

    private void validateEmptyField() {
        String user = etUser.getText().toString();
        String password = etPassword.getText().toString();

        if (user.trim().isEmpty() || password.trim().isEmpty()) {
            Alert.toast(context, "Preencha suas credenciais de acesso");
        } else if (!user.equalsIgnoreCase("aaa") || !password.equals("aaa")) {
            Alert.toast(context, "Usuario e/ou senha não conferem");
        } else {
            initializeDetailsActivity();
            Alert.toast(context, "Login efetuado com sucesso");
        }
    }

    private void initializeDetailsActivity() {
        Intent intent = new Intent(context, DetailsActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Alert.alertExitApp(context, "Sair do aplicativo?", "Realmente deseja sair do aplicativo?");
    }
}
