package com.example.hyperone.viewModel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

import com.example.hyperone.pojo.Model;
import com.example.hyperone.repositry.Repository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private static final String TAG = "postViewModel";

    public MutableLiveData<List<Model>> postsMutableLiveData = new MutableLiveData<>();
    Repository repository;

    @ViewModelInject
    public ViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<Model>> getModels() {
        return postsMutableLiveData;
    }

    public MutableLiveData<List<Model>> getModel() {
        Observable<List<Model>> observable = repository.getModels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> postsMutableLiveData.setValue(o), e -> Log.d(TAG, "getPosts:" + e));
        return postsMutableLiveData;


    }

}
