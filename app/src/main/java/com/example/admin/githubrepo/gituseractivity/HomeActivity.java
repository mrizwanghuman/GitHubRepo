package com.example.admin.githubrepo.gituseractivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.githubrepo.R;
import com.example.admin.githubrepo.modal.User;
import com.example.admin.githubrepo.repolistactivity.RepoListAct;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements UserDetailsContractor.View {

    private static final String TAG = "HomeActivity";
    @BindView(R.id.etUserName)
    EditText etUserName;

    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvUserEmail)
    TextView tvUserEmail;
    @BindView(R.id.tvUserLoc)
    TextView tvUserLoc;
    @BindView(R.id.ivUserAvatar)
    ImageView ivUserAvatar;
    @BindView(R.id.userProfileLayout)
    LinearLayout userProfileLayout;

    private GitUserPresenter gitUserPresenter;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        etUserName = findViewById(R.id.etUserName);
        gitUserPresenter = new GitUserPresenter();
        userProfileLayout.setVisibility(LinearLayout.INVISIBLE);
    }

    public void searchGitUser(View view) {
        username = etUserName.getText().toString();
        Log.d(TAG, "searchGitUser: " + username);
        gitUserPresenter.attachView(this);
        gitUserPresenter.getGitUser(username);
    }


    @Override
    public void setUser(List<User> gitUserList) {
        String userImageUrl="";
        if (gitUserList.size()>0) {
            userProfileLayout.setVisibility(LinearLayout.VISIBLE);
            for (int i = 0; i < gitUserList.size(); i++) {

                tvUserName.setText(gitUserList.get(i).getName());
                tvUserEmail.setText("Public Repo: "+gitUserList.get(i).getEmail());
                tvUserLoc.setText(gitUserList.get(i).getLocation());
                userImageUrl = gitUserList.get(i).getImageUrl();
                Glide.with(this).load(userImageUrl).into(ivUserAvatar);
            }
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_LONG).show();
            userProfileLayout.setVisibility(LinearLayout.INVISIBLE);
        }
    }

    @Override
    public void showProgress(String progress) {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gitUserPresenter.detachView();
    }

    public void getRepoList(View view) {
        Intent intent = new Intent(this, RepoListAct.class);
        intent.putExtra("userName", username);
        startActivity(intent);

    }
}
