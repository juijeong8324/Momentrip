package com.highfive.momentrip;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.highfive.momentrip.data.model.CategoryAllResult;
import com.highfive.momentrip.data.model.CategoryResult;
import com.highfive.momentrip.data.model.User;
import com.highfive.momentrip.data.repository.Remote;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AlbumFragment extends Fragment {
    // 앨범을 관리할 프래그먼트입니다.

    Fragment fg; // 프래그먼트 생성을 위해


    // 1. 카테고리 추가를 위해
    RecyclerView category_list;
    Remote repository; // Remote와 통신
    private SharedPreferences preferences; // 유저정보를 얻기 위한 객체
    public int user_id = 0;// 유저 id
    public int category_num = 0; // 카테고리 개수
    List<CategoryResult> categorys; // 카테고리 데이터들


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Remote();
        preferences = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        user_id = preferences.getInt("ID", 3); // id key 값을 가져오고 디폴트는 3로 일단 둠, 로그인하면 제대로 나온다.
    }

    @Override
    /*메소드 부분입니당^^ */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_album, container, false);
        category_list = rootView.findViewById(R.id.my_category);
        category_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        CategoryAdapter adapter = new CategoryAdapter();

        repository.getUserCategory(user_id, new Remote.GetDataCallback<CategoryAllResult>() { // 비동기 즉, 콜백이기 떄문에 호출만 해놓고 안 기다리고 다음 순서 진행...
            @Override
            public void onSuccess(CategoryAllResult data) {
                category_num = data.getCategoryCount(); // 카테고리 개수 세기
                categorys = data.getCategorys(); // 카테고리 데이터 가져오고
                /*텍스트 생성*/

                for(int i=0; i < category_num; i++){
                    adapter.addItem(categorys.get(i));
                }
                category_list.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getActivity(), "id 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("album", "실패 했습니다..\n" + throwable);
            }
        });

        /* 폴라로이드 메인 부분 띄워두기 */
        fg = AlbumFragmentMain.newInstance();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.p_container, fg);
        transaction.addToBackStack(null);
        transaction.commit();


        return rootView;
    }


}