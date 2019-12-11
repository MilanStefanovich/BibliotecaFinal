package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class Sec_act extends AppCompatActivity {

    private TextView tvIncidencias;
    private WebView wb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);
        tvIncidencias=(TextView)findViewById(R.id.tvIncidencias);
        wb=(WebView)findViewById(R.id.wb);
    }

    public void Incidencia1(View view){
        String[] lista = {"123","124","abc"};
        tvIncidencias.setText("Si su contraseña es similar a estas"+lista[0]+" "+lista[1]+" "+lista[2]+"\n"+
                               "la vulneravilidad que nos puede afectar es Hard-coded-password");

    }
    public void Incidencia2(View view){
        wb.loadUrl("http://www.ust.cl/");
        tvIncidencias.setText("Vulnerabilidad por portocolo HTPP:// NO seguro");

    }
}
