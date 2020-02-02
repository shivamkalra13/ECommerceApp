package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class SignupActivity extends AppCompatActivity {

    EditText email,phnumber,password,name;
    Button create,male,female;
    String gender="";
   TextView gendertext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        email=findViewById(R.id.email);
        phnumber=findViewById(R.id.phnumber);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        create=findViewById(R.id.create);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        gendertext=findViewById(R.id.gendertext);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setText("\u2713"+"Male");
                female.setText("Female");
                gender="male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setText("\u2713"+"Female");
                male.setText("Male");
                gender="female";

            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals(""))
                {
                    email.setError("Enter Email");

                }
                if(name.getText().toString().equals(""))
                {
                    name.setError("Enter name");

                }
                if(password.getText().toString().equals(""))
                {
                    name.setError("Enter password");

                }
                if(phnumber.getText().toString().equals(""))
                {
                    phnumber.setError("Enter name");

                }

                if (gender.equals(""))
                {gendertext.setError("Select Gender");
                    }

                else {
                    Toast.makeText(getApplicationContext(),"Account Created Succesfully",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(i);
                }


            }
        });



    }
}
