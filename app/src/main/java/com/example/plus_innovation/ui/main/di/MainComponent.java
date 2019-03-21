package com.example.plus_innovation.ui.main.di;


import com.example.plus_innovation.di.AppComponent;
import com.example.plus_innovation.ui.main.mvp.MainActivity;
import com.example.plus_innovation.ui.main.mvp.MainContract;


import dagger.BindsInstance;
import dagger.Component;


@Component(modules = MainModule.class, dependencies = AppComponent.class)
@MainScope
public interface MainComponent {
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {
        MainComponent build();

        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder mainView(MainContract.View view);
    }

}
