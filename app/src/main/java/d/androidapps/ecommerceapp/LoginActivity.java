package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText phone;
    EditText password;
    private RestApi restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        login=findViewById(R.id.login);
        phone=(EditText) findViewById(R.id.phone);
        password = findViewById(R.id.password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dealsdraw.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User> call = restApi.getUser(Long.parseLong(phone.getText().toString()));
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(!response.isSuccessful()){
                            if(response.code() == 404)
                                Toast.makeText(LoginActivity.this, response.code()+"Phone number entered is not registered", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(LoginActivity.this, response.code()+" Error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        User user = response.body();
                        if(user.getPassword().equals(password.getText().toString())){
                            Toast.makeText(LoginActivity.this, "Welcome '"+user.getName()+"' Your total earning is "+user.getEarning(), Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(LoginActivity.this,HomeActivity.class);

                            startActivity(i);
                            finish();
                        }
                        else {

                            Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Check your Internet Connection : connection "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                /*if(phone.getText().toString().equals(""))
                {
                    phone.setError("Enter Mobile or Email");
                    phone.requestFocus();
                }
                else
                {
                    Intent i=new Intent(LoginActivity.this,HomeActivity.class);

                    startActivity(i);
                    finish();
                }*/
            }
        });
    }

}
