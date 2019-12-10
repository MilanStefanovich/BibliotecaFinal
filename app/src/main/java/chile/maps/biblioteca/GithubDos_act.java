package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class GithubDos_act extends AppCompatActivity {

    private Spinner spLibros2;
    private TextView TvLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_dos_act);

        spLibros2=(Spinner)findViewById(R.id.spLibros2);
        TvLibros=(TextView)findViewById(R.id.TvLibros);


        Bundle listaLibros = this.getIntent().getExtras();
        String[] lib = listaLibros.getStringArray("libros");

        ArrayAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lib);
        spLibros2.setAdapter(adap);

        Bundle listaPrecio = getIntent().getExtras();
        int[] precio = listaPrecio.getIntArray("precio");



       /* LA MENTABLEMENTE LO TUBE QUE HACER EN UN BOTON YA QUE EN EL ONCREATE NO CAMBIABA EL TEXTVIEW
       if (spLibros2.getSelectedItem().equals("Farenheti")){
            TvLibros.setText("el libro seleccionado es: "+lib[2]+" y el precio es: "+precio[2]);
        }
        if (spLibros2.getSelectedItem().equals("Revival")){
            TvLibros.setText("el libro seleccionado es: "+lib[1]+" y el precio es: "+precio[1]);
        }
        if (spLibros2.getSelectedItem().equals("Tesla")){
            TvLibros.setText("el libro seleccionado es: "+lib[2]+" y el precio es: "+precio[2]);
        }*/

    }
    public  void mostrar(View v) {
        Bundle listaLibros = this.getIntent().getExtras();
        String[] lib = listaLibros.getStringArray("libros");

        Bundle listaPrecio = getIntent().getExtras();
        int[] precio = listaPrecio.getIntArray("precio");

        if (spLibros2.getSelectedItem().equals("Farenheti")) {
            TvLibros.setText("el libro seleccionado es: " + lib[0] + " y el precio es: " + precio[0]);
        }
        if (spLibros2.getSelectedItem().equals("Revival")) {
            TvLibros.setText("el libro seleccionado es: " + lib[1] + " y el precio es: " + precio[1]);
        }
        if (spLibros2.getSelectedItem().equals("Tesla")) {
            TvLibros.setText("el libro seleccionado es: " + lib[2] + " y el precio es: " + precio[2]);
        }
    }
}
