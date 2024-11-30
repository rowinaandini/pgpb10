// MainActivity.java
package com.example.retrofit;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.retrofit.model.Data;
import com.example.retrofit.network.ApiClient;
import com.example.retrofit.network.ApiService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the ListView by ID
        ListView listView = findViewById(R.id.tv_nama);

        //Create service
        ApiService client = ApiClient.getInstance();

        //Call the API to get users
        Call<List<Data>> response = client.getAllUsers();

        //List to hold user details
        List<String> dataUser = new ArrayList<>();

        //Enqueue the call
        response.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful() && response.body() !=null){
                    for (Data data :response.body()){
                        String gender = data.getJeniskelamin().equals("l")? "Laki-laki" : "Perempuan";
                        String userDetails = "Surveyor: " + data.getNamaSurveyor() + "\n" +
                                "Usia: " + data.getUsia() + "\n" +
                                "Jenis Kelamin: " + gender + "\n" +
                                "Pekerjaan: " + data.getPekerjaan() + "\n" +
                                "ID Desa: " + data.getIdDesa() + "\n" +
                                "Nama Desa: " + data.getNamaDesa() + "\n" +
                                "Latitude: " + data.getLatitude() + "\n" +
                                "Longitude: " + data.getLongitude();
                        dataUser.add(userDetails);
                    }
                    ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                            MainActivity.this, android.R.layout.simple_list_item_1, dataUser
                    );
                    listView.setAdapter(listAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });
    }
}