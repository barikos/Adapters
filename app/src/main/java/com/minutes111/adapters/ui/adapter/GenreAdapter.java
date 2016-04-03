package com.minutes111.adapters.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Genre;

import java.util.ArrayList;

/**
 * Created by barikos on 30.03.16.
 */
public class GenreAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList mGenres;

    public GenreAdapter(Context context, ArrayList genres) {
        this.mContext = context;
        this.mGenres = genres;
    }

    static class ViewHolder{
        private ImageView imgItem;
        private TextView txtItem;
    }

    @Override
    public int getCount() {
        return mGenres.size();
    }

    @Override
    public Object getItem(int position) {
        return mGenres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.genre,parent,false);
            holder = new ViewHolder();
            holder.imgItem = (ImageView)convertView.findViewById(R.id.img_genre);
            holder.txtItem = (TextView)convertView.findViewById(R.id.txt_genre);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Genre genre = (Genre)getItem(position);
        holder.imgItem.setImageResource(genre.getImage());
        holder.txtItem.setText(genre.getName());

        return convertView;
    }
}
