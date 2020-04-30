package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDetails extends AppCompatActivity {
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

    }


}
