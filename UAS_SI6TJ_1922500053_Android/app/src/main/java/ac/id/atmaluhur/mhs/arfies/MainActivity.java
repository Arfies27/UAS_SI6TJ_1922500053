package ac.id.atmaluhur.mhs.arfies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView dosenresult;
    private FloatingActionButton btn_tambah;
    private DosenJsonPlaceHolderAPI JsonPlaceHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_tambah = findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Intent i = new Intent(MainActivity.this,
                        EdosenActivity.class);
                startActivity(i);
            }
        });
        dosenresult = findViewById(R.id.result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.4/UAS_SI6TJ_1922500053/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderAPI = retrofit.create(DosenJsonPlaceHolderAPI.class);
        getPosts();
    }

    private void getPosts() {
        Map<String, String> parameters = new HashMap<>();
        Call<List<DosenPost>> call = JsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<DosenPost>>() {
            @Override
            public void onResponse(Call<List<DosenPost>> call, Response<List<DosenPost>> response) {
                if (!response.isSuccessful()) {
                    dosenresult.setText("code: " + response.code());
                    return;
                }
                List<DosenPost> posts = response.body();
                for (DosenPost post : posts) {
                    String content = "";
                    content += "nidn: " + post.getNidn() + "\n";
                    content += "nama_dosen: " + post.getNama_dosen() + "\n";
                    content += "jabatan: " + post.getJabatan() + "\n";
                    content += "gol_pang: " + post.getGol_pang() + "\n";
                    content += "keahlian: " + post.getKeahlian() + "\n";
                    content += "program_studi: " + post.getProgram_studi() + "\n\n";
                    dosenresult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<DosenPost>> call, Throwable t) {
                dosenresult.setText(t.getMessage());
            }
        });
    }
}