package com.highfive.momentrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class JejuFragment extends Fragment {
    // 제주도를 클릭할때 사진첩들이 나오도록 처리하주고 각 폴라로이드를 클릭하는 이벤트에 대해 처리하는 프레그먼트
    public static JejuFragment newInstance(){
        return new JejuFragment();
    }

    //프래그먼트에 대한 참조 얻기 = 프래그먼트가 액티비티로 올라오는 순간의 메소드임!
    AlbumFragment albumFragment = new AlbumFragment();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.jeju_part, container,false );
        // 즉 jeju_part xml을 ViewGroup으로 받는다.ㅏ

        // 폴라로이드 선택시
        ViewGroup layout = rootView.findViewById(R.id.click_pola);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParentFragmentView(new RealPFragment()); // RealPFragment로 바꾸기
            }
        });

        return rootView;
    }

    public void ParentFragmentView(Fragment child){ // 부모 프래그먼트로 보낼 애
        //FragmentTransaction을 이용해 프래그먼트 사용
        // 프래그먼트 트랜잭션  선언 및 시작

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction(); // 부모 프래그먼트가 관리하도록 해당 자식 프래그먼트를 보내기

        transaction.replace(R.id.p_container, child);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
