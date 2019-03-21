package com.example.plus_innovation.ui.main.di;

import com.example.plus_innovation.network.WebService;
import com.example.plus_innovation.ui.main.mvp.MainContract;
import com.example.plus_innovation.ui.main.mvp.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @MainScope
    public MainContract.Presenter provideMainPresenter(MainContract.View mainView, WebService webServices) {
        return new MainPresenter(mainView, webServices);
    }
}
