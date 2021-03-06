package com.highfive.momentrip;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.model.User;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    ArrayList<BookResult> items = new ArrayList<BookResult>();

    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // 뷰홀더 객체가 만들어질 때
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.fragment_album_item, viewGroup, false);

        return new AlbumAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder viewHolder, int position) {
        // 뷰홀더 객체가 바인딩될 때
        BookResult item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(BookResult item) {
        items.add(item);
    }

    public void setItems(ArrayList<BookResult> items) {
        this.items = items;
    }

    public BookResult getItem(int position) {
        return items.get(position);
    }

    // 뷰홀더 정의
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.click_pola_img1);
        }

        public void setItem(BookResult item1) {
            // set profile
            String imgPath = item1.getBook_img(); // 앨범집 이미지 가져오기
            if (imgPath != null && imgPath != "") {
                Glide.with(image.getContext()).load(imgPath).fitCenter().centerCrop().into(image); //centerCrop하면 이미지 크기에 맞춰서 나온다.
            }
            else{
              //  image.setImageResource(R.drawable.sample);
            }
        }
    }

}
