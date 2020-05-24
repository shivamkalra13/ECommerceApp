package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AccountSettings extends AppCompatActivity implements View.OnClickListener {
    Button cpbtn, psbtn, savebtn;
    LinearLayout pdlinear, cplinear, pslinear;
    EditText nameet, emailet, phet, oldpet, newpet, cnewpet;
    TextView pdtv, cptv, pstv;
    int pdcount = 0, cpcount = 0, pscount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        cpbtn = findViewById(R.id.cpbtn);
        psbtn = findViewById(R.id.psbtn);
        savebtn = findViewById(R.id.savebtn);
        pdlinear = findViewById(R.id.pdlinear);
        cplinear = findViewById(R.id.cplinear);
        pslinear = findViewById(R.id.pslinear);
        nameet = findViewById(R.id.nameet);
        emailet = findViewById(R.id.emailet);
        phet = findViewById(R.id.phet);
        oldpet = findViewById(R.id.oldpet);
        newpet = findViewById(R.id.newpet);
        cnewpet = findViewById(R.id.cnewpet);
        pdtv = findViewById(R.id.pdtv);
        cptv = findViewById(R.id.cptv);
        pstv = findViewById(R.id.pstv);
        cpbtn.setOnClickListener(this::onClick);
        psbtn.setOnClickListener(this::onClick);
        savebtn.setOnClickListener(this::onClick);
        pdtv.setOnClickListener(this::onClick);
        cptv.setOnClickListener(this::onClick);
        pstv.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if (view == cpbtn) {

        } else if (view == psbtn) {

        } else if (view == savebtn) {

        } else if (view == pdtv) {
            pdcount++;
            if (pdcount % 2 != 0) {
                pdlinear.setVisibility(View.GONE);
                pdtv.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.arrowdown),null);
            } else {
                pdlinear.setVisibility(View.VISIBLE);
                pdtv.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.arrowup),null);
            }
        } else if (view == cptv) {
            cpcount++;
            if (cpcount % 2 != 0) {
                cplinear.setVisibility(View.GONE);
                cptv.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.arrowdown),null);
            } else {
                cplinear.setVisibility(View.VISIBLE);
                cptv.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.arrowup),null);
            }
        } else if (view == pstv) {
            pscount++;
            if (pscount % 2 != 0) {
                pslinear.setVisibility(View.GONE);
                pstv.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.arrowdown),null);
            } else {
                pslinear.setVisibility(View.VISIBLE);
                pstv.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.arrowup),null);
            }
        }
    }
}
