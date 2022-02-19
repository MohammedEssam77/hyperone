package com.example.hyperone.repositry;

import com.example.hyperone.apiService.ApiService;
import com.example.hyperone.pojo.Model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {
    public ApiService apiService;
    @Inject
    public Repository(ApiService apiService) {
        this.apiService = apiService;
    }
    public Observable<List<Model>> getModels() {
        return apiService.getModel();
    }
}
