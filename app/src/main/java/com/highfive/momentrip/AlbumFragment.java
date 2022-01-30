package com.highfive.momentrip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class AlbumFragment extends Fragment {
    // 앨범을 관리할 프래그먼트입니다.

    Fragment fg; // 프래그먼트 생성

    // 1. 카테고리 추가 메소드
    LinearLayout listView; // 카테고리가 들어갈 레이아웃


    // 버튼 클릭 횟수 알아보기
    int countJ = 1;
    int countK = 1;
    int countA = 1;
    int countP = 1;
    int countT = 1;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


    }

    /*@Override
    // public void onDetach() {
        super.onDetach();
    }*/

    @Override
    /*메소드 부분입니당^^ */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_album, container, false);

        /* 전체 폴라로이드 프래그먼트 띄워두기 */
        fg = AlbumFragmentChildAll.newInstance();
        FragmentView(fg);

        /*텍스트 클릭후 프래그먼트 전환 처리 관련 */
        TextView jeju = (TextView) rootView.findViewById(R.id.jeju);
        TextView kang = (TextView) rootView.findViewById(R.id.kang);
        TextView alone = (TextView) rootView.findViewById(R.id.alone);
        TextView parent = (TextView) rootView.findViewById(R.id.parent);
        TextView today = (TextView) rootView.findViewById(R.id.today);

        // 제주 텍스트 클릭후 프래그먼트 전환 처리
        jeju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countJ != 0){
                    jeju.setSelected(true);
                    fg = JejuFragment.newInstance();
                    FragmentView(fg); // 제주 프래그먼트 출력
                    countJ= 0;
                }
                else{
                    jeju.setSelected(false);
                    fg = AlbumFragmentChildAll.newInstance();
                    FragmentView(fg); // 전체 폴라로이드 출력
                    countJ = 1;
                }

            }
        });

        return rootView;
    }

    public void FragmentView(Fragment child){
        //FragmentTransaction을 이용해 프래그먼트 사용
        // 프래그먼트 트랜잭션  선언 및 시작

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.p_container, child);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}