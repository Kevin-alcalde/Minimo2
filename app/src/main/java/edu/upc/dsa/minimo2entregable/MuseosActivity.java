package edu.upc.dsa.minimo2entregable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import edu.upc.dsa.minimo2entregable.models.Element;
import edu.upc.dsa.minimo2entregable.models.Museums;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuseosActivity extends AppCompatActivity {
    TextView descripcion;
    ImageView imagen;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ProgressBar progressBar;
    List<Element> elements;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museos);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        descripcion = findViewById(R.id.descripcion);
        imagen=findViewById(R.id.icon);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        context = getApplicationContext();
        getItems();
    }

    public void getItems() {
        progressBar.setVisibility(View.VISIBLE);

        Call<Museums> call = ApiClient.getUserService().getInfo();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if (response.code()==200) {
                    Museums museums = response.body();
                    progressBar.setVisibility(View.INVISIBLE);
                    myAdapter = new MyAdapter();
                    elements = new Museums().getElements();
                    elements = museums.getElements();
                    myAdapter.setData(elements);
                    recyclerView.setAdapter(myAdapter);
                }
                else if (response.code()==404){
                    AlertDialog alertDialog = new AlertDialog.Builder (MuseosActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("No se ha encontrado la pagina");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();


                }



            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {
                AlertDialog alertDialog = new AlertDialog.Builder (MuseosActivity.this).create();
                alertDialog.setTitle("Error" );
                alertDialog.setMessage("Error Conexion");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });


    }
}