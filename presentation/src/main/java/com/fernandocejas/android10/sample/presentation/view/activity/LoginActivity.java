package com.fernandocejas.android10.sample.presentation.view.activity;

import android.os.Bundle;

import com.fernandocejas.android10.sample.presentation.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}

