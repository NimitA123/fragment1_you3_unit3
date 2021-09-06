package com.example.fragment_you3_unit3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/users/{user}/repos")
    /*** {userId} means your are continue changing the data write it if u do not want to error in the program if some one change last url of the retrofit*****/
    /******Here we are getting the the list from the retrofit Api *****/
    Call<List<ResponseModel>> getUser(@Path("user") String userId);

}
