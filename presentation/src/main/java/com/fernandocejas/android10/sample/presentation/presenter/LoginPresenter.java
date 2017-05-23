package com.fernandocejas.android10.sample.presentation.presenter;

import android.support.annotation.NonNull;

import com.fernandocejas.android10.sample.domain.exception.ErrorBundle;
import com.fernandocejas.android10.sample.domain.interactor.ValidateUser;
import com.fernandocejas.android10.sample.presentation.exception.ErrorMessageFactory;
import com.fernandocejas.android10.sample.presentation.mapper.UserModelDataMapper;
import com.fernandocejas.android10.sample.presentation.view.LoginView;

import javax.inject.Inject;

/**
 * Created by IT on 22/05/2017.
 */

public class LoginPresenter implements Presenter{

    private LoginView loginView;

    //TODO: Implement ValidateUser case
    //private final ValidateUser validateUserCase;
    private final UserModelDataMapper userModelDataMapper;

    @Inject
    public LoginPresenter(UserModelDataMapper userModelDataMapper) {
        //this.validateUserCase = validateUserCase;
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

    public void validateUser() {
        //TODO: make the call to validate user
        //this.getUserListUseCase.execute(new UserListObserver(), null);
    }

    //TODO: implement observer to validate data
    /*private final class UserListObserver extends DefaultObserver<List<User>> {

        @Override public void onComplete() {
            UserListPresenter.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            UserListPresenter.this.hideViewLoading();
            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            UserListPresenter.this.showViewRetry();
        }

        @Override public void onNext(List<User> users) {
            UserListPresenter.this.showUsersCollectionInView(users);
        }
    }*/
}
