package d.androidapps.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Grabdeal extends AppCompatActivity {
TextView about;
Button seemore;
View arrowb;
LinearLayout linear;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabdeal);
        about=findViewById(R.id.about);
        arrowb=findViewById(R.id.arrowb);
        seemore=findViewById(R.id.seemore);
        linear=findViewById(R.id.linear);
        arrowb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i%2==0)
                {
                    arrowb.setBackgroundResource(R.drawable.arrowup);
                    about.setVisibility(View.GONE);
                }
                else {
                    arrowb.setBackgroundResource(R.drawable.arrowdown);
                    about.setVisibility(View.VISIBLE);
                }

            }
        });
        seemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear.setVisibility(View.VISIBLE);
                seemore.setVisibility(View.GONE);

            }
        });


    }
}
