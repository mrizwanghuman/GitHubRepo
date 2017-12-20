package com.example.admin.githubrepo.gituseractivity;

import android.util.Log;

import com.example.admin.githubrepo.modal.User;
import com.example.admin.githubrepo.modal.UserData;
import com.example.admin.githubrepo.remote.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by  Admin on 12/19/2017.
 */

public class GitUserPresenter implements UserDetailsContractor.Presenter {
    List<User> userList=new ArrayList<>();
    UserDetailsContractor.View view;
    @Override
    public void attachView(UserDetailsContractor.View view) {
        this.view= view;
    }

    @Override
    public void detachView() {
        this.view= null;

    }

    @Override
    public void getGitUser(final String username) {
        RetrofitHelper.getGitUser(username).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserData>() {
            @Override
            public void onSubscribe(Disposable d) {
view.showProgress("Data is loading");
            }

            @Override
            public void onNext(UserData value) {
                Log.d("Username", "onNext: "+value.getName()+value.getAvatarUrl()+value.getEmail());

                userList.add(new User(value.getName(), value.getAvatarUrl(), value.getLocation(), (String) value.getPublicRepos().toString()));



            }

            @Override
            public void onError(Throwable e) {
view.showError(e.getMessage());

            }

            @Override
            public void onComplete() {
                view.showProgress("Data completed");
                view.setUser(userList);


            }
        });

    }

}
