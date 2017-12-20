package com.example.admin.githubrepo.repolistactivity;

import android.util.Log;

import com.example.admin.githubrepo.modal.repomodel.Repo;
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

public class RepoListPresenter implements RepoListContractor.Presenter {
    List<Repo> repoList= new ArrayList<>();
    RepoListContractor.View view;
    @Override
    public void attachView(RepoListContractor.View view) {
        this.view= view;
    }

    @Override
    public void detachView() {
this.view= null;
    }

    @Override
    public void getRepo(String userName) {
        RetrofitHelper.repoList(userName).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Observer<List<Repo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.showProgress("Data Loading");
            }

            @Override
            public void onNext(List<Repo> value) {
                Log.d("Repo", "onNext: "+value.size());
                repoList.addAll(value);
            }

            @Override
            public void onError(Throwable e) {
view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {
view.setRepo(repoList);
view.showProgress("Data load completed");
            }
        });

    }
}
