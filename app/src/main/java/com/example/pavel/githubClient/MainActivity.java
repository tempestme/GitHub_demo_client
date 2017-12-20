package com.example.pavel.githubClient;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.database.Observable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavel.githubClient.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.message;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final ImageView avatar = (ImageView)findViewById(R.id.avatarIV);
        final EditText editText = (EditText)findViewById(R.id.getTextET);
        final TextView id = (TextView)findViewById(R.id.idTV);
        final TextView location = (TextView)findViewById(R.id.locationTV);
        final TextView login = (TextView)findViewById(R.id.loginTV);
        final TextView company = (TextView)findViewById(R.id.companyTV);
        final Button GetButton = (Button)findViewById(R.id.getButton);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.INTERNET},123);
        }

        final Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString()!=""){
                    try{
                        Api api = retrofit.create(Api.class);
                        Call<User> call = api.GetUser(editText.getText().toString());

                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {

                                User user = response.body();


                                if(user == null){
                                    Toast.makeText(getApplicationContext(),"NOT FOUND",Toast.LENGTH_SHORT).show();
                                    company.setText("nonononononono");
                                    id.setText("id: not found");
                                    location.setText("location: not found");
                                    login.setText("not found");
                                    Picasso.with(getApplicationContext()).load("http://s.quickmeme.com/img/a8/a8022006b463b5ed9be5a62f1bdbac43b4f3dbd5c6b3bb44707fe5f5e26635b0.jpg").into(avatar);


                                }
                                else{
                                    company.setText(user.getCompany());
                                    id.setText("id: "+user.getId());
                                    location.setText("location: "+user.getLocation());
                                    login.setText(user.getLogin());
                                    Picasso.with(getApplicationContext()).load(user.getAvatar_url()).into(avatar);
                                }


                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Toast.makeText(getApplicationContext(),"CHECK YOUR CONNECTION",Toast.LENGTH_LONG).show();
                                company.setText("");
                                id.setText("");
                                location.setText("");
                                login.setText("CHECK CONNECTION");

                            }
                        });
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();

                    }

                }
                else{
                    Toast.makeText(getApplicationContext(),"enter login",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
