package com.highfive.momentrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RealPFragment extends Fragment {
    // 각 폴라로이드를 클릭했을 때 나오는 사진첩 프래그먼트입니다!
    public static RealPFragment newInstance(){
        return new RealPFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.real_p, container,false );

        // 사진첩 선택시
        ViewGroup layout = rootView.findViewById(R.id.click_j1);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), PolaActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
