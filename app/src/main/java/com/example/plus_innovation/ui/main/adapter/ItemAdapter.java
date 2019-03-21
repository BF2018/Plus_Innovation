package com.example.plus_innovation.ui.main.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plus_innovation.R;
import com.example.plus_innovation.model.data.Item;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private List<Item> itemList;
    ItemClickListener itemClickListener;

    public ItemAdapter(List<Item> itemList, ItemClickListener itemClickListener) {

        this.itemList = itemList;
        this.itemClickListener = itemClickListener;

    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_listing, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {


        holder.idNumber.setText(String.valueOf(itemList.get(position).getId()));
        holder.itemView.setOnClickListener(v -> itemClickListener
                .onItemClick(itemList.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView idNumber;

        public ItemViewHolder(View itemView) {
            super(itemView);
            idNumber = itemView.findViewById(R.id.tv_country_name);

        }
    }

}
