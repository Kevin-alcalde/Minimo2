package edu.upc.dsa.minimo2entregable;

import java.util.List;

import edu.upc.dsa.minimo2entregable.models.Museums;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("api/dataset/museus/format/json/pag-ini/1/pag-fi/15")
    Call<Museums> getInfo();
}
