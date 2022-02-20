package com.highfive.momentrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.highfive.momentrip.data.model.SignupRequest;
import com.highfive.momentrip.data.model.SignupResponse;
import com.highfive.momentrip.data.repository.Remote;

public class SignupActivity2 extends AppCompatActivity {
    private SharedPreferences preferences; // 유저 정보를 위한 SharedPreferences
    Remote repository; // 네트워크 요청을 위한 객체

    EditText nameInput;
    EditText passwordInput;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        repository = new Remote();

        nameInput = findViewById(R.id.signupName);
        passwordInput = findViewById(R.id.editText);
        nextButton = findViewById(R.id.button);

        // 다음 버튼 클릭
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupRequest request = new SignupRequest(preferences.getString("email",""), passwordInput.getText().toString() , nameInput.getText().toString(), nameInput.getText().toString(), null,null);
                repository.signup(request, new Remote.GetDataCallback<SignupResponse>() {
                    @Override
                    public void onSuccess(SignupResponse response) {
                        Toast.makeText(getApplicationContext(),"회원가입 완료! : " + response.getUser().getName(), Toast.LENGTH_LONG).show();
                        SharedPreferences.Editor editor = preferences.edit(); // Editor를 preferences에 쓰겠다고 연결
                        editor.putString("id", Integer.toString(response.getUser().getId())); // putString(KEY,VALUE)
                        editor.putString("nick", response.getUser().getNick()); // putString(KEY,VALUE)
                        editor.putString("password", response.getUser().getPassword()); // putString(KEY,VALUE)
                        editor.putString("name", response.getUser().getName()); // putString(KEY,VALUE)
                        editor.commit(); // 항상 commit & apply 를 해주어야 저장이 된다.
                        getPreferences(0); // 메소드 호출(mode:0 => 읽기, 쓰기 가능)
                        startActivity(new Intent(getApplicationContext(), SignupActivity3.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"회원가입 실패", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });
            }
        });
    }
}