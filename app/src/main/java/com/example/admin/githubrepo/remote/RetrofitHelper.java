package com.example.admin.githubrepo.remote;

import com.example.admin.githubrepo.modal.UserData;
import com.example.admin.githubrepo.modal.repomodel.Repo;

import java.util.List;

import io.reactivex.Observable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by  Admin on 12/19/2017.
 */

public class RetrofitHelper {
    private static final String BASE_URL="https://api.github.com/";
    private static OkHttpClient httpClientConfig(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();



    }
    private static HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;
    }
    private static Retrofit create(){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClientConfig(loggingInterceptor()))
                .build();
    }
    public static Observable<UserData> getGitUser(String username){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getGitUser(username);
    }
    public static Observable<List<Repo>> repoList(String username){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getRepo(username);

    }
}
