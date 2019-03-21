package com.example.plus_innovation.ui.detail.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plus_innovation.R;
import com.example.plus_innovation.app.App;
import com.example.plus_innovation.ui.detail.di.DaggerDetailComponent;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @Inject
    DetailPresenter mDetailPresenter;

    TextView mTitle, mSubtitle, mDate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        DaggerDetailComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .detailView(this)
                .build()
                .inject(this);

        mTitle = findViewById(R.id.title);
        mSubtitle = findViewById(R.id.subtitle);
        mDate = findViewById(R.id.date);

        Intent intent = getIntent();
        int id = intent.getIntExtra("itemId", -1);

        mDetailPresenter.getDetailData(id);

    }


    @Override
    public void onFetchDetail(String title, String subtitle, String date) {
        mTitle.setText(title);
        mSubtitle.setText(subtitle);
        mDate.setText(date);
    }

    @Override
    public void onError(String error) {
        Log.v("Detail_Error", error);
        Toast.makeText(getApplicationContext(), "some problem with loading", Toast.LENGTH_LONG).show();
    }
}
