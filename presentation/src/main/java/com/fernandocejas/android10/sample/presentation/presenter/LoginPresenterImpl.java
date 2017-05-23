package com.fernandocejas.android10.sample.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.fernandocejas.android10.sample.domain.LoginResponse;
import com.fernandocejas.android10.sample.domain.exception.DefaultErrorBundle;
import com.fernandocejas.android10.sample.domain.exception.ErrorBundle;
import com.fernandocejas.android10.sample.domain.interactor.DefaultObserver;
import com.fernandocejas.android10.sample.domain.interactor.ValidateUser;
import com.fernandocejas.android10.sample.presentation.exception.ErrorMessageFactory;
import com.fernandocejas.android10.sample.presentation.mapper.UserModelDataMapper;
import com.fernandocejas.android10.sample.presentation.view.LoginView;

import javax.inject.Inject;

/**
 * Created by IT on 22/05/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private static final String TAG = "LoginPresenter";
    private LoginView loginView;

    //TODO: Implement ValidateUser case
    private final ValidateUser validateUserCase;
    private final UserModelDataMapper userModelDataMapper;

    @Inject
    public LoginPresenterImpl(ValidateUser validateUserCase, UserModelDataMapper userModelDataMapper) {
        this.validateUserCase = validateUserCase;
        this.userModelDataMapper = userModelDataMapper;
    }

    public void setView(@NonNull LoginView view) {
        this.loginView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        //TODO: dispose use case
        //this.getUserListUseCase.dispose();
        this.loginView = null;
    }

    public boolean isValidEmail(String email){
        if (email.contains("@"))
            return true;
        else return false;
    }

    public boolean isValidPassword(String password){
        if (password.length() > 4)
            return true;
        else return false;
    }

    private void showViewLoading() {
        this.loginView.showLoading();
    }

    private void hideViewLoading() {
        this.loginView.hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.loginView.context(),
                errorBundle.getException());
        this.loginView.showError(errorMessage);
    }

    public void validateUser(String username, String password) {
        showViewLoading();
        validateUserCase.execute(new LoginObserver(), ValidateUser.Params.forUser(username, password));
    }

    private final class LoginObserver extends DefaultObserver<LoginResponse> {

        @Override public void onComplete() {
            loginView.userValidated();
        }

        @Override public void onError(Throwable e) {
            LoginPresenterImpl.this.hideViewLoading();
            LoginPresenterImpl.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override public void onNext(LoginResponse loginResponse) {
            LoginPresenterImpl.this.hideViewLoading();
            Log.d(TAG, loginResponse.getMessage());
        }
    }
}
