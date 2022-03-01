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
    LinearLayout linearLayout; // 카테고리가 들어갈 레이아웃
    Remote repository; // Remote와 통신
    private SharedPreferences preferences; // 유저정보를 얻기 위한 객체
    public int user_id = 0;// 유저 id
    public int category_num = 0; // 카테고리 개수
    List<CategoryResult> categorys; // 카테고리 데이터들

    // 버튼 클릭 횟수 알아보기
    /*int countJ = 1;
    int countK = 1;
    int countA = 1;
    int countP = 1;
    int countT = 1;
    */

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
        linearLayout = rootView.findViewById(R.id.category_linear);

        repository.getUserCategory(user_id, new Remote.GetDataCallback<CategoryAllResult>() { // 비동기 즉, 콜백이기 떄문에 호출만 해놓고 안 기다리고 다음 순서 진행...
            @Override
            public void onSuccess(CategoryAllResult data) {
                category_num = data.getCategoryCount(); // 카테고리 개수 세기
                categorys = data.getCategorys(); // 카테고리 데이터 가져오고
                /*텍스트 생성*/
                for(int i=0; i < category_num; i++){
                    TextView textViewNm = new TextView(getContext()); // 텍스트뷰 객체생성
                    textViewNm.setTextColor(Color.parseColor("#A3A3A3")); // 색상 설정
                    if(i==0){
                        textViewNm.setText("기본"); // momentrip default category
                    }
                    else{
                        textViewNm.setText(categorys.get(i).getCategory_value()); // 텍스트 가져오고
                    }

                    textViewNm.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20); // 크기 설정
                    textViewNm.setTypeface(null, Typeface.BOLD); // 글씨체 두껍게
                    textViewNm.setId(i); // id 설정
                    textViewNm.setPadding(0,0,30, 0); // 패딩 설정
                    linearLayout.addView(textViewNm);
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getActivity(), "id 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("album", "실패 했습니다..\n" + throwable);
            }
        });



        /* 전체 폴라로이드 프래그먼트 띄워두기 */
        fg = AlbumFragmentChildAll.newInstance();
        FragmentView(fg);

        /*텍스트 클릭후 프래그먼트 전환 처리 관련 */
        //for(int i=0; i<category_num; i++){
        //   String category_id = getId(i);
        //    TextView i = (TextView) rootView.findViewById(R.id.category_id);
        //}
        //TextView jeju = (TextView) rootView.findViewById(R.id.jeju);
        //TextView kang = (TextView) rootView.findViewById(R.id.kang);
        //TextView alone = (TextView) rootView.findViewById(R.id.alone);
        //TextView parent = (TextView) rootView.findViewById(R.id.parent);
        //TextView today = (TextView) rootView.findViewById(R.id.today);

        // 제주 텍스트 클릭후 프래그먼트 전환 처리
        /*jeju.setOnClickListener(new View.OnClickListener() {
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
        });*/

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