package com.highfive.momentrip;

import android.content.Context;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.highfive.momentrip.data.model.BookAllResult;
import com.highfive.momentrip.data.repository.Remote;

public class AlbumFragmentChildAll extends Fragment {
    //이 프래그먼트는 My moment 전체 폴라로이드 부분입니다!
    public static AlbumFragmentChildAll newInstance(){

        return new AlbumFragmentChildAll();
    }

    Remote repository; // Remote 객체
    int num_album = 0; // 앨범집 개수


   /* @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);



        repository = new Remote();

        repository.getUserBook(1, new Remote.GetDataCallback<BookAllResult>() {
            @Override
            public void onSuccess(BookAllResult data) {

            }
            @Override
            public void onFailure(Throwable throwable) {
                Log.v("뿌까라삥봉","실패");
            }
        });
    }

    @Nullable
    @Override
    // 프래그먼트도 액티비티를 본떠서 만들었기 때문에 수명주기 메서드를 가질 수 있게한다
    // 이 메소드 안에서는 인플레이션 가능!
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_album_all, container,false );
        // 인플레이션 과정을 통해 ViewGroup이라는 객체가 전달

        return rootView; // 프래그먼트 안에 들어가는 최상위 뷰
    }
}
