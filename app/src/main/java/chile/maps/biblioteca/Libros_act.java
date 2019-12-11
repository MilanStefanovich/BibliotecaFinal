package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Libros_act extends AppCompatActivity {

    private EditText et1, et2;
    private Spinner sp;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_act);

        sp=(Spinner)findViewById(R.id.sp);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv=(TextView)findViewById(R.id.tv);

        String dato = getIntent().getStringExtra("libros");
        tv.setText(dato);



        Bundle listaLibros = this.getIntent().getExtras();
        String[] lib = listaLibros.getStringArray("libros");

        ArrayAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lib);
        sp.setAdapter(adap);
    }

    public void Calcular (View view)
    {

        Bundle listaPrecio = getIntent().getExtras();
        int[] precio = listaPrecio.getIntArray("precio");

        if (sp.getSelectedItem().equals("Farenheti"))
        {

            int cant = Integer.valueOf(et1.getText().toString());
            int cp = Integer.valueOf(et2.getText().toString());
            int pr = precio[0];

            int resultado = pr * cant + cp;


            tv.setText("el resultado final es: " +resultado);

        }
        if (sp.getSelectedItem().equals("Revival"))
        {
            int cant = Integer.valueOf(et1.getText().toString());
            int cp = Integer.valueOf(et2.getText().toString());
            int pr = precio[1];

            int resultado = pr * cant + cp;


            tv.setText("el resultado final es: " +resultado);
        }
        if (sp.getSelectedItem().equals("Tesla"))
        {
            int cant = Integer.valueOf(et1.getText().toString());
            int cp = Integer.valueOf(et2.getText().toString());
            int pr = precio[2];

            int resultado = pr * cant + cp;


            tv.setText("el resultado final es: " +resultado);
        }

    }
    public void LibroMqtt(View v){
        Intent i = new Intent(this, Mqtt_act.class);
        startActivity(i);
    }

}


