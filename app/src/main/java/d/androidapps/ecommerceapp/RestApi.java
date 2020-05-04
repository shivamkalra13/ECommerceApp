package d.androidapps.ecommerceapp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApi {
    @POST("userauth/")
    Call<User> userAuth(@Body User user);
    @POST("users/")
    Call<User> createUser(@Body User user);
    @GET("offers/")
    Call<ArrayList<Offer>> getOffers();
}
