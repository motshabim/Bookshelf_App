package com.example.bookshelf;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

//to connect to the Room database entity to the RecyclerView items.
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>
{
    private List<DataEntities> bookList;
    private final OnBookClickListener listener;

    public interface OnBookClickListener {
        void onBookClick(String filePath);
    }

    public BookAdapter(List<DataEntities> bookList, OnBookClickListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }

    public void updateDate(List<DataEntities> newBooks) {
        this.bookList = newBooks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,
                parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        DataEntities book = bookList.get(position);
        holder.titleTextView.setText(book.title);

        holder.itemView.setOnClickListener(v -> listener.onBookClick(book.filePath));
    }

    @Override
    public int getItemCount() {
        return bookList != null ? bookList.size() : 0;
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public BookViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}
