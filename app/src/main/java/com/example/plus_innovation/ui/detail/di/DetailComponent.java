package com.example.plus_innovation.ui.detail.di;


import com.example.plus_innovation.di.AppComponent;
import com.example.plus_innovation.ui.detail.mvp.DetailActivity;
import com.example.plus_innovation.ui.detail.mvp.DetailContract;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = DetailModule.class, dependencies = AppComponent.class)
@DetailScope
public interface DetailComponent {
    void inject(DetailActivity detailActivity);

    @Component.Builder
    interface Builder {
        DetailComponent build();

        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder detailView(DetailContract.View view);
    }
}
