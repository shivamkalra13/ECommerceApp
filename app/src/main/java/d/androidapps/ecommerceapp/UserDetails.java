package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDetails extends AppCompatActivity implements View.OnClickListener {
Button accountsettings,earning,orders,referal,wishlist,contact,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        accountsettings=findViewById(R.id.accsetting);
        earning=findViewById(R.id.earning);
        orders=findViewById(R.id.orders);
        referal=findViewById(R.id.referal);
        wishlist=findViewById(R.id.wishlist);
        contact=findViewById(R.id.contact);
        logout=findViewById(R.id.logout);
        accountsettings.setOnClickListener(this::onClick);
        earning.setOnClickListener(this::onClick);
        orders.setOnClickListener(this::onClick);
        referal.setOnClickListener(this::onClick);
        wishlist.setOnClickListener(this::onClick);
        contact.setOnClickListener(this::onClick);
        logout.setOnClickListener(this::onClick);

    }


    @Override
    public void onClick(View view) {
        if(view==accountsettings)
        {
            Intent intent1=new Intent(UserDetails.this,AccountSettings.class);
            startActivity(intent1);
        }
        else if(view==earning)
        {
            Intent intent2=new Intent(UserDetails.this,PaymentAndEarning.class);
            startActivity(intent2);
        }
        /*
        else if(view==orders)
        {
            Intent intent3=new Intent(UserDetails.this,AccountSettings.class);
            startActivity(intent3);
        }
        else if(view==referal)
        {
            Intent intent4=new Intent(UserDetails.this,AccountSettings.class);
            startActivity(intent4);
        }
        else if(view==wishlist)
        {
            Intent intent5=new Intent(UserDetails.this,AccountSettings.class);
            startActivity(intent5);
        }*/
        else if(view==contact)
        {
            Intent intent6=new Intent(UserDetails.this, ContactUs.class);
            startActivity(intent6);
        }
        else if(view==logout)
        {
            //todo aleart Dialog
        }

    }
}
