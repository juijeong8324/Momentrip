package com.highfive.momentrip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.highfive.momentrip.data.model.BookAllResult;
import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.model.CategoryResult;
import com.highfive.momentrip.data.repository.Remote;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    ArrayList<CategoryResult> items = new ArrayList<CategoryResult>();

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // 뷰홀더 객체가 만들어질 때
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.fragment_category_item, viewGroup, false);

        return new CategoryAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int position) {
        // 뷰홀더 객체가 바인딩될 때
        CategoryResult item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(CategoryResult item) {
        items.add(item);
    }

    public void setItems(ArrayList<CategoryResult> items) {
        this.items = items;
    }

    public CategoryResult getItem(int position) {
        return items.get(position);
    }

    // 뷰홀더 정의
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.category_item);
            // click 처리
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Remote repository = new Remote();
                    AlbumAdapter adapter = new AlbumAdapter();
                    repository.getCategoryBook(textView.getId(), new Remote.GetDataCallback<BookAllResult>() {
                        @Override
                        public void onSuccess(BookAllResult data) {
                            int num_album = data.getBookCount(); // 앨범집 개수 세기
                            List<BookResult> books = data.getBooks(); // 전체 앨범 데이터 가져오기

                            for(int i=0; i<num_album; i++){
                                adapter.addItem(books.get(i));
                            }

                           // album_list.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Throwable throwable) {

                        }
                    });

                }
            });
        }

        public void setItem(CategoryResult item) {
            // set profile
            String category_text = item.getCategory_value(); // 카테고리 값 가져오기
            int category_id = item.getCategory_id(); // 카테고리 id 가져오기
            textView.setId(category_id);
            textView.setText(category_text);

        }
    }
}
