package ac.id.atmaluhur.mhs.arfies;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface DosenJsonPlaceHolderAPI {
    @GET("dosen.php")
    Call<List<DosenPost>> getPosts(

    );
    @GET("dosen.php")
    Call<List<DosenPost>> getPosts(@QueryMap Map<String, String> parameters);
}
