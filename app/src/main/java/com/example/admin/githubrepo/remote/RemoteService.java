package com.example.admin.githubrepo.remote;



import com.example.admin.githubrepo.modal.UserData;
import com.example.admin.githubrepo.modal.repomodel.Repo;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by  Admin on 12/19/2017.
 */

public interface RemoteService {
    @GET("users/{userName}")
    Observable<UserData> getGitUser(@Path(value = "userName", encoded = true) String userName);

    @GET("users/{userName}/repos")
    Observable<List<Repo>> getRepo(@Path(value = "userName", encoded = true) String userName);
}
