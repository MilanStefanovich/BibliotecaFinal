package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


        Bundle listaLibros = this.getIntent().getExtras();
        String[] lib = listaLibros.getStringArray("libros");

        ArrayAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lib);
        spLibros2.setAdapter(adap);



        if (spLibros2.getSelectedItem().equals("Farenheti")){
            TvLibros.setText("el libro seleccionado es: "+lib[0]+"y el precio es: ");//+precio[0]);
        }
        if (spLibros2.getSelectedItem().equals("Revival")){
            TvLibros.setText("el libro seleccionado es: "+lib[1]+"y el precio es: ");//+precio[1]);
        }
        if (spLibros2.getSelectedItem().equals("Tesla")){
            TvLibros.setText("el libro seleccionado es: "+lib[2]+"y el precio es: ");//+precio[2]);
        }
    }
}
