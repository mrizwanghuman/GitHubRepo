package com.example.admin.githubrepo.repolistactivity;

import com.example.admin.githubrepo.modal.repomodel.Repo;
import com.example.admin.githubrepo.util.BasePresenter;
import com.example.admin.githubrepo.util.BaseView;

import java.util.List;

/**
 * Created by  Admin on 12/19/2017.
 */

public interface RepoListContractor {
    interface View extends BaseView{
        void setRepo(List<Repo> repoList);
        void showProgress(String progress);
    }
    interface Presenter extends BasePresenter<View>{
        void getRepo(String userName);

    }
}
