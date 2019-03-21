package com.example.plus_innovation.ui.main.mvp;

import android.content.Context;

import com.example.plus_innovation.model.data.Item;

import java.util.List;

public interface MainContract {

    interface View {
        void onDataSuccess(String message, List<Item> itemList);

        void onDataFailure(String message);

    }

    interface Presenter {
        void getData(Context context);
    }
}
