package com.example.admin.githubrepo.util;

/**
 * Created by  Admin on 12/19/2017.
 */

public interface BasePresenter <V extends BaseView>{
    void attachView(V view);
    void detachView();
}
