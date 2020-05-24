package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactUs extends AppCompatActivity implements View.OnClickListener {
EditText nameet,emailet,feebacket;
Button callbtn,sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        callbtn=findViewById(R.id.callbtn);
        sendbtn=findViewById(R.id.sendbtn);
    }

    @Override
    public void onClick(View view) {
        if(view==callbtn)
        {

        }
        else if(view==sendbtn)
        {

        }
    }
}
