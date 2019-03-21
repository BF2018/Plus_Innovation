package com.example.plus_innovation.ui.main.mvp;

import android.content.Context;

import com.example.plus_innovation.model.data.Result;
import com.example.plus_innovation.model.data.Item;
import com.example.plus_innovation.network.WebService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mainContractView;
    private final CompositeDisposable mDisposible;
    private WebService webService;
    private List<Item> itemList = new ArrayList<>();
    private List<String> itemListId = new ArrayList<>();

    @Inject
    public MainPresenter(MainContract.View view, WebService webServices) {
        this.mainContractView = view;
        this.webService = webServices;
        mDisposible = new CompositeDisposable();
    }


    @Override
    public void getData(Context context) {

        mDisposible.add(webService.getListOfItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Result>() {

                    @Override
                    public void onSuccess(Result result) {
                        itemList = result.getItems();

                        if (itemList.size() > 0) {
                            for (int i = 0; i < itemList.size(); i++) {

                                itemListId.add(itemList.get(i).getId().toString());
                            }
                        }

                        mainContractView.onDataSuccess("got :" + itemListId.size(), itemList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainContractView.onDataFailure(e.getMessage());
                    }
                })


        );

    }


}
