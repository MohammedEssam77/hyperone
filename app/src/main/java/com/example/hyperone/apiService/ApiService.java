package com.example.hyperone.apiService;

import com.example.hyperone.pojo.Model;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("getListOfFilesResponse.json")
    Observable<List<Model>> getModel();
}
