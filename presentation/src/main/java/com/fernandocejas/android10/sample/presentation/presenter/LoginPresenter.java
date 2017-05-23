package com.fernandocejas.android10.sample.presentation.presenter;

import com.fernandocejas.android10.sample.presentation.view.LoginView;

/**
 * Created by IT on 23/05/2017.
 */

public interface LoginPresenter extends Presenter{
    boolean isValidEmail(String email);
    boolean isValidPassword(String password);
}
