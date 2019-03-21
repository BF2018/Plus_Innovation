package com.example.plus_innovation.ui.detail.di;


import com.example.plus_innovation.network.WebService;
import com.example.plus_innovation.ui.detail.mvp.DetailContract;
import com.example.plus_innovation.ui.detail.mvp.DetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
    @Provides
    @DetailScope
    public DetailContract.Presenter provideDetailPresenter(DetailContract.View view, WebService service) {
        return new DetailPresenter(view, service);
    }
}
