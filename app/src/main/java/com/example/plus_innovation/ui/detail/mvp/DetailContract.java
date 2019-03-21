package com.example.plus_innovation.ui.detail.mvp;

public interface DetailContract {
    interface View {
        void onFetchDetail(String title, String subtitle, String date);

        void onError(String error);
    }

    interface Presenter {
        void getDetailData(int id);

        void stop();
    }
}
