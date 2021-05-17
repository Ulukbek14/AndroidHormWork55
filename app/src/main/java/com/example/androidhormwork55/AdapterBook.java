package com.example.androidhormwork55;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.HolderBook> {

    private OnitemClickistener onitemClickistener;
    private List<TaskModel> list = new ArrayList<>();

    public void setOnitemClickistener(OnitemClickistener onitemClickistener) {
        this.onitemClickistener = onitemClickistener;
    }

    public AdapterBook(List<TaskModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterBook.HolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_holder_book, parent, false);
        return new HolderBook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBook.HolderBook holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderBook extends RecyclerView.ViewHolder {
        private TextView nameBook;
        private ImageView imageBook;
        public HolderBook(@NonNull View itemView) {
            super(itemView);
            nameBook = itemView.findViewById(R.id.txt_name);
            imageBook = itemView.findViewById(R.id.image_book);
        }

        public void bind(TaskModel taskModel) {
            nameBook.setText(taskModel.getName());
            imageBook.setImageResource(taskModel.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemClickistener.itemClick(getAdapterPosition());
                }
            });
        }
    }
}

