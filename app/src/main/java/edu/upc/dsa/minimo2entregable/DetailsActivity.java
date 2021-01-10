package edu.upc.dsa.minimo2entregable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import edu.upc.dsa.minimo2entregable.models.Element;
import edu.upc.dsa.minimo2entregable.models.GrupAdreca;

import static java.security.AccessController.getContext;

public class DetailsActivity extends AppCompatActivity {
    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;
    TextView tx5;
    TextView tx6;
    TextView tx7;
    TextView tx8;
    TextView tx9;
    TextView tx10;
    TextView tx11;
    TextView tx12;
    TextView tx13;
    TextView tx14;
    ScrollView scrollView;
    Element element ;
    String adrecaNom;
    ImageView municipi;
    ImageView imagen0;
   public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        tx5 = findViewById(R.id.tx5);
        tx6 = findViewById(R.id.tx6);
        tx7 = findViewById(R.id.tx7);
        tx8 = findViewById(R.id.tx8);
        tx9 = findViewById(R.id.tx9);
        tx10 = findViewById(R.id.tx10);
        tx11 = findViewById(R.id.tx11);
        tx12 = findViewById(R.id.tx12);
        tx13 = findViewById(R.id.tx13);
        municipi = findViewById(R.id.municipi);
        element = new Element();
        element =(Element) getIntent().getSerializableExtra("item");
        context = getApplicationContext();
         imagen0 = findViewById(R.id.imagen0);
        getDetails();


    }

    public void getDetails() {

        tx1.setText(element.getAdrecaNom());
        tx2.setText(element.getDescripcio());
        GrupAdreca grupAdreca;
        grupAdreca = element.getGrupAdreca();
        tx3.setText(grupAdreca.getAdreca());
        tx4.setText(grupAdreca.getCodiPostal());
        tx5.setText(grupAdreca.getMunicipiNom());
        tx6.setText(element.getEmail().get(0));
        tx7.setText(element.getTelefonContacte().get(0));
        String escut = element.getRelMunicipis().getMunicipiEscut();
        Glide.with(context).load(escut).into(municipi);
        tx8.setText(element.getRelMunicipis().getMunicipiBandera());
        String imagen = element.getImatge().get(0);
        Glide.with(context).load(imagen).into(imagen0);












    }
}