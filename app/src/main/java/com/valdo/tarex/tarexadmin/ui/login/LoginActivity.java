package com.valdo.tarex.tarexadmin.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.valdo.tarex.tarexadmin.R;
import com.valdo.tarex.tarexadmin.ui.base.BaseActivity;
import com.valdo.tarex.tarexadmin.ui.requests.RequestListActivity;

import static com.valdo.tarex.tarexadmin.utils.Constants.ID_KEY;

public class LoginActivity extends BaseActivity implements LoginView {

    private EditText etLogin;
    private EditText etPassword;

    private Button btnLogin;

    private String shName = "shPref";

    private Long idRest;

    @InjectPresenter
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        initView();


        btnLogin.setOnClickListener(view -> {
            if (etLogin.getText() != null && etPassword != null) {
                presenter.login(etLogin.getText().toString(), etPassword.getText().toString());
            }

        });

    }

    @Override
    public void handleError(Throwable error) {

    }

    @Override
    public void setAccessToken(String tokenDto) {
        presenter.createSharedPreferences(this,tokenDto);
    }

    @Override
    public void getSpToken(String token) {
        if (token != null) {
            Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void setId(Long id) {
        Intent intent = new Intent(LoginActivity.this, RequestListActivity.class);
        intent.putExtra(ID_KEY,id);
        Log.d("ID!!!!!!", id.toString());
        startActivity(intent);
    }

    private void initView (){
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }
}
