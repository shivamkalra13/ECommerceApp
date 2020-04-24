package d.androidapps.ecommerceapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {
    @GET("users/{phone}")
    Call<User> getUser(@Path("phone") long phone);
}
