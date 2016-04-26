package com.minutes111.adapters.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.minutes111.adapters.ui.RecyclerActivity;
import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by barikos on 30.03.16.
 */
public class RecyclerBookAdapter extends RecyclerView.Adapter<RecyclerBookAdapter.BookViewHolder>{

    private Context mContext;
    private ArrayList mBooksData;
    private int mAttrLayout;

    public RecyclerBookAdapter(Context context, ArrayList booksData, int attrLayout) {
        this.mContext = context;
        this.mBooksData = booksData;
        this.mAttrLayout = attrLayout;
    }

    static class BookViewHolder extends RecyclerView.ViewHolder{
        ImageView imgItem;
        TextView titleItem;
        TextView authorItem;
        RatingBar rbItem;

        public BookViewHolder(View itemView) {
            super(itemView);
            this.imgItem = (ImageView)itemView.findViewById(R.id.img_rec);
            this.titleItem = (TextView)itemView.findViewById(R.id.txt_rec_title);
            this.authorItem = (TextView)itemView.findViewById(R.id.txt_rec_author);
            this.rbItem = (RatingBar)itemView.findViewById(R.id.rating_rec);
        }
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (mAttrLayout){
            case RecyclerActivity.ATTR_LAYOUT_GRID:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_grid,parent,false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_lin,parent,false);
        }

        BookViewHolder bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = (Book) mBooksData.get(position);
        ImageView imageView = holder.imgItem;
        Picasso
                .with(mContext)
                .load(book.getImage())
                .into(imageView);
        holder.titleItem.setText(book.getTitle());
        holder.authorItem.setText(book.getAuthor());
        holder.rbItem.setProgress(book.getProgress());
    }

    @Override
    public int getItemCount() {
        return mBooksData.size();
    }
}
