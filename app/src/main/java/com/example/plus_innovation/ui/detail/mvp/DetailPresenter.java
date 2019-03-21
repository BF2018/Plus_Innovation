package com.example.plus_innovation.ui.detail.mvp;

import com.example.plus_innovation.model.data.Item;
import com.example.plus_innovation.model.data.ItemResponse;
import com.example.plus_innovation.network.WebService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View detailContractView;
    private WebService webService;

    private final CompositeDisposable disposable;

    @Inject
    public DetailPresenter(DetailContract.View detailContractView, WebService webService) {
        this.detailContractView = detailContractView;
        this.webService = webService;
        disposable = new CompositeDisposable();
    }

    @Override
    public void getDetailData(int id) {
        if (id != -1) {
            String value = String.valueOf(id) + ".json";
            disposable.add(webService.getItemDetails(value)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<ItemResponse>() {
                        @Override
                        public void onSuccess(ItemResponse itemResponse) {
                            Item item = itemResponse.getItem();
                            detailContractView.onFetchDetail(item.getTitle(), item.getSubtitle(), item.getDate());
                        }

                        @Override
                        public void onError(Throwable e) {
                            detailContractView.onError(e.getMessage());
                        }
                    }));

        }
    }

    @Override
    public void stop() {
        disposable.clear();
    }
}
