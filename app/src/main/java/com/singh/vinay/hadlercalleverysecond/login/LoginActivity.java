package com.singh.vinay.hadlercalleverysecond.login;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.singh.vinay.hadlercalleverysecond.R;
import com.singh.vinay.hadlercalleverysecond.handler.DialogHandler;
import com.singh.vinay.hadlercalleverysecond.model.UserData;
public class LoginActivity extends Activity implements LoginView,OnLoginFinishedListener, View.OnClickListener {
    //presenter
    private LoginPresenter mPresenter;
    //views
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private Dialog pdProgress;
    /**
     * get activity context
     */
    private Activity getActivityContext() {
        return this;
    }
    /**
     * called on activity created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenterImpl(this);
        initControls();
        initActions();
    }

    /**
     * init controls
     */
    private void initControls() {
        edtUsername = (EditText) findViewById(R.id.id);
        edtPassword = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.login);
    }
    /**
     * init actions
     */
    private void initActions() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                login();
                break;
        }
    }

    /**
     * login
     */
    private void login() {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String action = "login";
        mPresenter.login(username, password, action);
    }

    /**
     * show progress
     */
    @Override
    public void showProgress() {
        if (pdProgress == null)
            pdProgress = DialogHandler.getInstance().createProgress(getActivityContext());
            pdProgress.show();
    }

    /**
     * hide progress
     */
    @Override
    public void hideProgress() {
        if (pdProgress != null && pdProgress.isShowing())
            pdProgress.dismiss();
    }

    /**
     * show error
     */
    @Override
    public void showError(String message) {
        DialogHandler.getInstance().show(getActivityContext(), getString(R.string.error_title), message);
    }

    /**
     * on user logged in
     */
    @Override
    public void loggedIn() {
       /* Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();*/
    }

    /**
     * called on activity destroyed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
    @Override
    public void onError(String message) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void OnGetData(UserData tClass) {

      String dsf = tClass.getAuth_code().toString();
      String sdafdsf = tClass.getEmail().toString();

        Toast.makeText(LoginActivity.this, dsf, Toast.LENGTH_SHORT).show();

    }
}
