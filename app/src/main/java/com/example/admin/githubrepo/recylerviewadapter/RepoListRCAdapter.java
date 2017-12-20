package com.example.admin.githubrepo.recylerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.githubrepo.R;
import com.example.admin.githubrepo.modal.repomodel.Repo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by  Admin on 12/19/2017.
 */

public class RepoListRCAdapter extends RecyclerView.Adapter<RepoListRCAdapter.ViewHolder> {
    List<Repo> repoList = new ArrayList<>();

    public RepoListRCAdapter(List<Repo> repoList) {
        this.repoList = repoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_recylerview, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (repoList!=null) {
            holder.tvRepoName.setText(repoList.get(position).getFullName());
            holder.tvRepoOwner.setText(repoList.get(position).getCloneUrl());
            holder.tvRepoUrl.setText(repoList.get(position).getCreatedAt());
        }

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvRepoName)
        TextView tvRepoName;
        @BindView(R.id.tvRepoUrl)
        TextView tvRepoUrl;
        @BindView(R.id.tvRepoOwner)
        TextView tvRepoOwner;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
