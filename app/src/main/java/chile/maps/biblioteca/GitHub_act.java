package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class GitHub_act extends AppCompatActivity {

    private Spinner spLibros;
    private TextView TvLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_act);
        spLibros  = (Spinner)findViewById(R.id.spLibros);
        TvLibros  = (TextView) findViewById(R.id.TvLibros);

        String dato = getIntent().getStringExtra("libros");
        TvLibros.setText(dato);



        Bundle listaLibros = this.getIntent().getExtras();
        String[] lib = listaLibros.getStringArray("libros");

        ArrayAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lib);
        spLibros.setAdapter(adap);



    }
    public void NewSpiner(View view){
        Bundle listaPrecio = getIntent().getExtras();
        int[] precio = listaPrecio.getIntArray("precio");

        if (spLibros.getSelectedItem().equals("Farenheti")){
            int pr1 = precio[0];
            TvLibros.setText("El valor es "+pr1);
        }
        if ( spLibros.getSelectedItem().equals("Revival")){
            int pr2 = precio[1];
            TvLibros.setText("El valor es "+pr2);
        }
        if (spLibros.getSelectedItem().equals("Tesla")){
            int pr3 = precio[2];
            TvLibros.setText("El valor es "+pr3);
        }

    }
}
