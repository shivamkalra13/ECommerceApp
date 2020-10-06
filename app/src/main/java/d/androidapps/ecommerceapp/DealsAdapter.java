package d.androidapps.ecommerceapp;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.MyViewHolder> {

    private ArrayList<Offer> offers;

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View offercard;
        public MyViewHolder(View v) {
            super(v);
            offercard = v;
        }
    }

    //constructor : Called in HomeActivity
    public DealsAdapter(ArrayList<Offer> myDataset) {
        offers = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DealsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offer_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    //todo:Take the references of widgets of offer_card in the following function and assign them value.

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {       //Take the references of widgets of offer_card in this function and assign them value.
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView textView;
        textView = holder.offercard.findViewById(R.id.info_text);       //Took reference of a widget of offer_card
        ImageView picture = holder.offercard.findViewById(R.id.pic);
        textView.setText(offers.get(position).getTitle());              //Assigned value to that widget equals to a property of Offer(1 Offer from Offers list) recieved from DB.
        //todo: Remove this temporary 'picture' changing code:-
        if(offers.get(position).getTitle().equals("Electronics at Amazon"))
            picture.setImageResource(R.drawable.offerimg1);
        if(offers.get(position).getTitle().equals("Electronics at Flipkart"))
            picture.setImageResource(R.drawable.offerimg2);
        if(offers.get(position).getTitle().equals("Fashion at Amazon"))
            picture.setImageResource(R.drawable.offerimg3);
        if(offers.get(position).getTitle().equals("Fashion at Ebay"))
            picture.setImageResource(R.drawable.offerimg4);
        if(offers.get(position).getTitle().equals("Sports at Flipkart"))
            picture.setImageResource(R.drawable.offerimg5);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return offers.size();
    }
}
