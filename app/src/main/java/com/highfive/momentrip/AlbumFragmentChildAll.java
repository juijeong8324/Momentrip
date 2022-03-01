package com.highfive.momentrip;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.util.Log;
import android.util.TypedValue;
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

    AlbumFragment albumFragment;
    Remote repository; // Remote 객체
    int num_album = 0; // 앨범집 개수
    private SharedPreferences preferences; // 유저정보를 얻기 위한 객체
    public int user_id;// 유저 id

    // 앨범집 UI를 만들어주기 위해 선언
    ConstraintLayout constraintLayout;
    FrameLayout frameLayout;
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
        constraintLayout = rootView.findViewById(R.id.constraint); // constraint 객체 불러오기

        // 앨범집 동적 추가
        // FrameLayout params 정의
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams size1 = new ViewGroup.LayoutParams(100,100); // 이미지뷰1 크기 조정167*3, 197*3
        ViewGroup.LayoutParams size2 = new ViewGroup.LayoutParams(100,100); // 이미지뷰2 크기 조정

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

       repository.getUserBook(user_id, new Remote.GetDataCallback<BookAllResult>() {
            @Override
            public void onSuccess(BookAllResult data) {
                num_album = data.getBookCount(); // 앨범집 개수 세기
                System.out.println(num_album);
                books = data.getBooks(); // 전체 앨범 데이터 가져오기

                for(int i=0; i < num_album; i++){
                frameLayout = new FrameLayout(getActivity()); // FrameLayout 객체 생성
                frameLayout.setLayoutParams(params); // 파라미터 설정

                // imageView 생성
                ImageView imageView1 = new ImageView(getActivity());
                drawable = getResources().getDrawable(R.drawable.photo); // 이미지를 넣기 위해
                imageView1.setImageDrawable(drawable);
                imageView1.setLayoutParams(size1); // 이미지 뷰 가로세로 크기 설정
                imageView1.requestLayout(); // 이미지 뷰 변경을 적용해달라고 요청
                frameLayout.addView(imageView1); // 프레임 레이아웃에 추가

                //imageView 생성2
                ImageView imageView2 = new ImageView(getActivity());
                String imageUrl = books.get(i).getBook_img();
                Glide.with(imageView2.getContext()).load(imageUrl).into(imageView2);
                p.setMargins(10,20,0,0);
                imageView2.setLayoutParams(p); // image에 padding 값 부여
                imageView2.setLayoutParams(size1); // 이건 크기 조정
                imageView2.requestLayout(); // 이미지 뷰 변경을 적용해달라고 요청
                frameLayout.addView(imageView2); // 프레임 레이아웃에 추가

                constraintLayout.addView(frameLayout);
                }
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
