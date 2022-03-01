package com.highfive.momentrip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.highfive.momentrip.data.model.LoginRequest;
import com.highfive.momentrip.data.model.LoginResponse;
import com.highfive.momentrip.data.repository.Remote;

public class LoginActivity2 extends AppCompatActivity {
    private SharedPreferences preferences; // 유저 정보를 위한 SharedPreferences
    Remote repository; // 네트워크 요청을 위한 객체

    EditText emailInput;
    EditText passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        //
        repository = new Remote();

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);

        /** TODO: (디자인) 자동로그인 체크 **/

        // 로그인 버튼 클릭
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서버에 로그인 요청
                LoginRequest request = new LoginRequest(emailInput.getText().toString(), passwordInput.getText().toString());
                repository.login(request, new Remote.GetDataCallback<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse data) {
                        SharedPreferences.Editor editor = preferences.edit(); // Editor를 preferences에 쓰겠다고 연결
                        editor.putString("token", data.getToken()); // putString(KEY,VALUE)
                        editor.putInt("ID", data.getUser().getId()); // User의 id도 preferences에 저장
                        editor.commit(); // 항상 commit & apply 를 해주어야 저장이 된다.
                        getPreferences(0); // 메소드 호출(mode:0 => 읽기, 쓰기 가능)

                        Toast.makeText(getApplicationContext(),"반가워요, "+data.getUser().getNick()+"님", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),"토큰 : "+ preferences.getString("token", "null"), Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });
            }
        });
    }
}