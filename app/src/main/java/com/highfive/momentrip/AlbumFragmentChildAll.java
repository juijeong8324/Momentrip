package com.highfive.momentrip;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.highfive.momentrip.data.model.BookAllResult;
import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.repository.Remote;

import java.util.List;

public class AlbumFragmentChildAll extends Fragment {
    //이 프래그먼트는 My moment 전체 폴라로이드 부분입니다!
    public static AlbumFragmentChildAll newInstance(){

        return new AlbumFragmentChildAll();
    }

    Remote repository;
    SharedPreferences preferences;
    int user_id;
    RecyclerView album_list;
    int num_album;
    AlbumAdapter adapter;

    // drawable 리소스 객체 가져오기
    Drawable drawable;
    List<BookResult> books;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        repository = new Remote();
        preferences = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        user_id = preferences.getInt("ID", 3); // id key 값을 가져오고 디폴트는 2로 일단 둠임

    }

    @Nullable
    @Override
    // 프래그먼트도 액티비티를 본떠서 만들었기 때문에 수명주기 메서드를 가질 수 있게한다
    // 이 메소드 안에서는 인플레이션 가능!
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_album_all, container,false );
        // 인플레이션 과정을 통해 ViewGroup이라는 객체가 전달
        album_list = rootView.findViewById(R.id.my_recycle); // constraint 객체 불러오기
        album_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        adapter = new AlbumAdapter();
       repository.getUserBook(user_id, new Remote.GetDataCallback<BookAllResult>() {
            @Override
            public void onSuccess(BookAllResult data) {
                num_album = data.getBookCount(); // 앨범집 개수 세기
                System.out.println(num_album);
                books = data.getBooks(); // 전체 앨범 데이터 가져오기

                for(int i=0; i<num_album; i++){
                    adapter.addItem(books.get(i));
                }

                album_list.setAdapter(adapter);

            }
            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getActivity(), "id 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });

        return rootView; // 프래그먼트 안에 들어가는 최상위 뷰
    }
}
