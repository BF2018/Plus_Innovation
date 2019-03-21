package com.example.plus_innovation.network;

import com.example.plus_innovation.model.data.ItemResponse;
import com.example.plus_innovation.model.data.Result;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {
    @GET("test/native/contentList.json")
    Single<Result> getListOfItems();

    @GET("test/native/content/{id}")
    Single<ItemResponse> getItemDetails(@Path("id") String id);

}
