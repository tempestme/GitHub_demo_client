package com.example.pavel.githubClient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pavel on 17.12.17.
 */

public interface Api {

    String BASE_URL="https://api.github.com/users/";

    @GET("{user}")
    Call<User> GetUser(@Path("user") String user);

}
