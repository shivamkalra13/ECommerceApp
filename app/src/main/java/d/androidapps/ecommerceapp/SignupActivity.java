package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    EditText email, phnumber, password, name;
    Button create, male, female;
    String gender = null;
    String emailval = "";
    TextView gendertext;
    private RestApi restApi;
    CheckBox check;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        email = findViewById(R.id.email);
        phnumber = findViewById(R.id.phnumber);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        create = findViewById(R.id.create);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        gendertext = findViewById(R.id.gendertext);
        check = findViewById(R.id.check);
        linear = findViewById(R.id.linear);
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
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    linear.setVisibility(View.GONE);
                    gendertext.setVisibility(View.GONE);
                    male.setText("Male");
                    female.setText("Female");
                    gender = null;
                } else {
                    linear.setVisibility(View.VISIBLE);
                    gendertext.setVisibility(View.VISIBLE);

                }
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setText("\u2713" + "Male");
                female.setText("Female");
                gender = "Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setText("\u2713" + "Female");
                male.setText("Male");
                gender = "Female";

            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("")) {
                    name.setError("Enter name");
                    name.requestFocus();
                    return;
                }
                if (phnumber.getText().toString().equals("") || phnumber.getText().toString().length() != 10) {
                    phnumber.setError("Enter Valid no.");
                    phnumber.requestFocus();
                    return;
                }

                if (email != null) {
                    emailval = email.getText().toString();
                    if (!Patterns.EMAIL_ADDRESS.matcher(emailval).matches()) {
                        email.setError("EvterValid  Email");
                        email.requestFocus();
                        return;
                    }

                }
                Pattern pattern;
                Matcher matcher;
                final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*=])(?=\\\\S+$).{4,}$";
                pattern = Pattern.compile(PASSWORD_PATTERN);
                matcher = pattern.matcher(password.getText().toString());
                if (!matcher.matches()) {
                    password.setError("  at least 8 characters, 1 Capital, 1 Number and 1 Special Character");
                    password.requestFocus();
                    return;
                }


                User client = new User(Long.parseLong(phnumber.getText().toString()), password.getText().toString(), name.getText().toString(), emailval, gender);
                Call<User> call = restApi.createUser(client);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (!response.isSuccessful()) {
                            if (response.code() == 400)
                                Snackbar.make(coordinatorLayout, "User with this Phone number is already registered.", Snackbar.LENGTH_LONG).show();
                            else
                                Toast.makeText(SignupActivity.this, response.code() + " Error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        User user = response.body();
                        Toast.makeText(SignupActivity.this, "Welcome '" + user.getName() + "'. Account Created Succesfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignupActivity.this, HomeActivity.class);
                        i.putExtra("name", name.getText().toString());
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(SignupActivity.this, "Check your Internet Connection : connection " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
