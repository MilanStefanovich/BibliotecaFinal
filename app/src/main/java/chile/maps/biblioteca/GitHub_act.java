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


        Bundle listaLibros = this.getIntent().getExtras();
        String[] lib = listaLibros.getStringArray("libros");

        ArrayAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lib);
        spLibros.setAdapter(adap);



        if (spLibros.getSelectedItem().equals("Farenheti")){
            TvLibros.setText("el libro seleccionado es: "+lib[0]+"y el precio es: ");//+precio[0]);
        }
        if (spLibros.getSelectedItem().equals("Revival")){
            TvLibros.setText("el libro seleccionado es: "+lib[1]+"y el precio es: ");//+precio[1]);
        }
        if (spLibros.getSelectedItem().equals("Tesla")){
            TvLibros.setText("el libro seleccionado es: "+lib[2]+"y el precio es: ");//+precio[2]);
        }
    }
}
