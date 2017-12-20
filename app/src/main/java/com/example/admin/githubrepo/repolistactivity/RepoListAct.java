package com.example.admin.githubrepo.repolistactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.admin.githubrepo.R;
import com.example.admin.githubrepo.modal.repomodel.Repo;
import com.example.admin.githubrepo.recylerviewadapter.RepoListRCAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListAct extends AppCompatActivity implements RepoListContractor.View {

    @BindView(R.id.rcRepoList)
    RecyclerView rcRepoList;
RepoListPresenter repoListPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
        String userNameIntent = getIntent().getStringExtra("userName");
        rcRepoList.setLayoutManager(new LinearLayoutManager(this));
        repoListPresenter= new RepoListPresenter();
repoListPresenter.attachView(this);
       repoListPresenter.getRepo(userNameIntent);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRepo(List<Repo> repoList) {
        RepoListRCAdapter repoListRCAdapter = new RepoListRCAdapter(repoList);
        rcRepoList.setAdapter(repoListRCAdapter);

    }

    @Override
    public void showProgress(String progress) {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        repoListPresenter.detachView();
    }
}
