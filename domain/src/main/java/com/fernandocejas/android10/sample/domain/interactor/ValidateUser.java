package com.fernandocejas.android10.sample.domain.interactor;

import com.fernandocejas.android10.sample.domain.LoginResponse;
import com.fernandocejas.android10.sample.domain.executor.PostExecutionThread;
import com.fernandocejas.android10.sample.domain.executor.ThreadExecutor;
import com.fernandocejas.android10.sample.domain.repository.UserRepository;
import com.fernandocejas.arrow.checks.Preconditions;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by IT on 22/05/2017.
 */

public class ValidateUser extends UseCase<LoginResponse, ValidateUser.Params>{

    private final UserRepository userRepository;

    @Inject
    ValidateUser(UserRepository userRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    Observable<LoginResponse> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return this.userRepository.authenticateUser(params.username, params.password);
    }

    public static class Params {
        private final String username;
        private final String password;

        private Params(String username, String password){
            this.username = username;
            this.password = password;
        }

        public static Params forUser(String username, String password){
            return new Params(username, password);
        }
    }
}
