package d.androidapps.ecommerceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView nav;
    LinearLayout linear;
    ImageButton profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        linear = findViewById(R.id.linear);
        profile = findViewById(R.id.profile);
        toolbar.inflateMenu(R.menu.tbar_menu);
        toolbar.setNavigationIcon(R.drawable.menu1);

        toolbar.setNavigationOnClickListener(
                v -> {
                    DrawerLayout navDrawer = findViewById(R.id.draw);
                    if (!navDrawer.isDrawerOpen(Gravity.LEFT))
                        navDrawer.openDrawer(Gravity.LEFT);
                    else navDrawer.closeDrawer(Gravity.LEFT);
                }
        );

        toolbar.setOnMenuItemClickListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.search:
                            Toast.makeText(HomeActivity.this, "clicked search", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.bookmarks:
                            Toast.makeText(HomeActivity.this, "clicked bookmark", Toast.LENGTH_LONG).show();
                            //bookmark list
                            break;
                        case R.id.cart:
                            Toast.makeText(HomeActivity.this, "clicked cart", Toast.LENGTH_LONG).show();
                            //cart
                            break;
                    }
                    return false;
                }
        );
        //setActionBar(toolbar);

        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.account:


                                break;
                            case R.id.refer:
                                Intent intent2 = new Intent(HomeActivity.this, ItemsDisp.class);
                                startActivity(intent2);
                                break;
                            case R.id.orders:
                                Intent intent1 = new Intent(HomeActivity.this, Grabdeal.class);
                                startActivity(intent1);
                                break;
                            case R.id.bookmarks:
                                Intent intent=new Intent(HomeActivity.this,UserDetails.class);
                                startActivity(intent);
                                break;
                        }
                        return false;
                    }
                }
        );

    }
}