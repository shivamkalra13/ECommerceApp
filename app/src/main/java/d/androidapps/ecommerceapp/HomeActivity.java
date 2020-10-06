package d.androidapps.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView nav;
    private  LinearLayout linear;
    private ImageButton profile;
    private RecyclerView dealsRecyclerView;
    private RecyclerView.Adapter dealsAdapter;
    private RestApi restApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator);
        toolbar = findViewById(R.id.toolbar);
        linear = findViewById(R.id.linear);
        profile = findViewById(R.id.profile);
        toolbar.inflateMenu(R.menu.tbar_menu);
        toolbar.setNavigationIcon(R.drawable.ic_outline_menu_24);
        dealsRecyclerView = (RecyclerView) findViewById(R.id.deals_recycler_view);
        dealsRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //-----------Configuring the Action Bar and Navigation Drawer.
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
        //----------Action Bar and Navigation Drawer config over.

        //todo:Finalize the view of offer_card and do entry of more offers in DB to check the working properly.

        //------------Offers fetched from API and displayed using DealsAdapter Recycler View.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dealsdraw.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restApi = retrofit.create(RestApi.class);
        Call<ArrayList<Offer>> call = restApi.getOffers();
        call.enqueue(new Callback<ArrayList<Offer>>() {
            @Override
            public void onResponse(Call<ArrayList<Offer>> call, Response<ArrayList<Offer>> response) {
                if (!response.isSuccessful()) {
                    Snackbar.make(coordinatorLayout, response.code() + " Error" , Snackbar.LENGTH_LONG).show();
                    return;
                }
                ArrayList<Offer> offers = response.body();
                dealsAdapter = new DealsAdapter(offers);
                dealsRecyclerView.setAdapter(dealsAdapter);
               dealsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Offer>> call, Throwable t) {
                Snackbar.make(coordinatorLayout, "Check your Internet Connection : connection " + t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });

    }
}