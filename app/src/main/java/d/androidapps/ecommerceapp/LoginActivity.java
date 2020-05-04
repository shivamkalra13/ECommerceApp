package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

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

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

//todo:Forgot Password to be implemented.

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText phone;
    EditText password;
    private RestApi restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        login = findViewById(R.id.login);
        phone = (EditText) findViewById(R.id.phone);
        password = findViewById(R.id.password);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator);


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

        //Called when Login button is clicked.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phone.getText().toString().equals("")) {
                    phone.setError("Enter Mobile Number");
                    phone.requestFocus();
                    return;
                }
                if (password.getText().toString().equals("")) {
                    password.setError("Enter Password");
                    password.requestFocus();
                    return;
                }

                User client = new User(Long.parseLong(phone.getText().toString()), password.getText().toString());
                Call<User> call = restApi.userAuth(client);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (!response.isSuccessful()) {
                            if (response.code() == 404)
                                Snackbar.make(coordinatorLayout, "Phone number or password entered is not correct.", Snackbar.LENGTH_LONG).show();
                            else
                                Toast.makeText(LoginActivity.this, response.code() + " Error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        User user = response.body();
                        Toast.makeText(LoginActivity.this, "Welcome '" + user.getName() + "' Your total earning is " + user.getEarning(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Check your Internet Connection : connection " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
