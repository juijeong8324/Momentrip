package com.highfive.momentrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity1 extends AppCompatActivity {

    private SharedPreferences preferences; // 유저 정보를 위한 SharedPreferences
    boolean isFilled = false; // input 값이 존재하는지 확인하는 변수

    EditText emailInput;
    TextView warningMessage;
    Button nextButton; // 다음 버튼
    TextView goLoginText; // '로그인하러 가기!'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        emailInput = (EditText)findViewById(R.id.editTextEmail);
        warningMessage = findViewById(R.id.warningMessage);
        nextButton = findViewById(R.id.button);
        goLoginText = findViewById(R.id.go_login);

        // 이메일 Input 관련 UI
        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { // 입력에 변화가 있을 때
                if(emailInput.getText().toString().equals("")) { // 공백 체크
                    isFilled = false;
                    nextButton.setBackgroundResource(R.drawable.button_darkgrey);
                } else {
                    isFilled = true;
                    nextButton.setBackgroundResource(R.drawable.button_blue);
                }
            }
            @Override
            public void afterTextChanged(Editable arg0) {/* 입력이 끝났을 때 조치*/}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {/* 입력하기 전 조치*/}
        });

        emailInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean gainFocus) {
                if (gainFocus) {/* 포커스가 주어졌을 때 동작 */}
                else { /* 포커스를 잃었을 때의 동작 */ }
            }
        });

        // 다음 버튼 클릭
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFilled) {
                    if(true) { /** TODO: Email 중복 체크 */
                        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit(); // Editor를 preferences에 쓰겠다고 연결
                        editor.putString("email", emailInput.getText().toString()); // putString(KEY,VALUE)
                        editor.commit(); // 항상 commit & apply 를 해주어야 저장이 된다.
                        getPreferences(0); // 메소드 호출(mode:0 => 읽기, 쓰기 가능)
                        startActivity(new Intent(getApplicationContext(), SignupActivity2.class));
                    } else {
                        warningMessage.setVisibility(View.VISIBLE); // 경고 메세지
                    }
                }
            }
        });

        // '로그인 하러 가기!' 클릭
        goLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity2.class));
            }
        });
    }
}