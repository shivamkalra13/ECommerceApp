package d.androidapps.ecommerceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity{
    Toolbar toolbar;
    NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.tbar_menu);
        toolbar.setNavigationIcon(R.drawable.menu1);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DrawerLayout navDrawer = findViewById(R.id.draw);
                        // If the navigation drawer is not open then open it, if its already open then close it.
                        if (!navDrawer.isDrawerOpen(Gravity.LEFT))
                            navDrawer.openDrawer(Gravity.LEFT);
                        else navDrawer.closeDrawer(Gravity.LEFT);
                    }
                }
        );

        toolbar.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId())
                        {
                            case R.id.search:
                                Toast.makeText(HomeActivity.this,"clicked search",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.bookmarks:
                                Toast.makeText(HomeActivity.this,"clicked bookmark",Toast.LENGTH_LONG).show();
                                //bookmark list
                                break;
                            case R.id.cart:
                                Toast.makeText(HomeActivity.this,"clicked cart",Toast.LENGTH_LONG).show();
                                //cart
                                break;
                        }
                        return false;
                    }
                }
        );
        //setActionBar(toolbar);

        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id=menuItem.getItemId();
                        switch (id)
                        {
                            case R.id.account:
                                Toast.makeText(HomeActivity.this, "Clicked Account", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.refer:
                                Toast.makeText(HomeActivity.this,"clicked srefer",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.orders:
                                Toast.makeText(HomeActivity.this,"clicked order",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.bookmarks:
                                Toast.makeText(HomeActivity.this,"clicked book",Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                }
        );
    }

}