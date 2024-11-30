package com.example.retrofit.network;








import com.example.retrofit.model.Data;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("3314")
    Call<List<Data>> getAllUsers();
}

