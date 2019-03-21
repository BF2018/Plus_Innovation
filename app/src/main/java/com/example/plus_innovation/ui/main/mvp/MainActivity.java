package com.example.plus_innovation.ui.main.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.plus_innovation.R;
import com.example.plus_innovation.app.App;
import com.example.plus_innovation.model.data.Item;
import com.example.plus_innovation.ui.detail.mvp.DetailActivity;
import com.example.plus_innovation.ui.main.adapter.ItemAdapter;
import com.example.plus_innovation.ui.main.adapter.ItemClickListener;
import com.example.plus_innovation.ui.main.di.DaggerMainComponent;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View, ItemClickListener {

    @Inject
    MainPresenter presenter;
    private RecyclerView mRecyclerView;

    LinearLayoutManager linearLayoutManager;
    ItemAdapter mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .mainView(this)
                .build()
                .inject(this);


        presenter.getData(getApplicationContext());
        mRecyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDataSuccess(String message, List<Item> itemList) {
        mAdaptor = new ItemAdapter(itemList, this);
        mRecyclerView.setAdapter(mAdaptor);
    }

    @Override
    public void onDataFailure(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        Log.v("Data Status", message);
    }


    @Override
    public void onItemClick(Item item) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("itemId", item.getId());
        startActivity(intent);
    }
}
