package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private ProgressBar pb;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        btn = (Button)findViewById(R.id.btn);
        pb = (ProgressBar)findViewById(R.id.pb);

        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(et1.getText().toString());
            }
        });
    }


    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        // Procesos complejos o tareas pesadas.
        @Override
        protected String doInBackground(String... strings) {

            try
            {
                Thread.sleep(5000);
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);

            pb.setVisibility(View.INVISIBLE);
        }
    }

    public void Home(View v)
    {
        Intent i = new Intent(this, Home_act.class);
        startActivity(i);
    }
    public void Maps(View v)
    {
        Intent i = new Intent(this, MapsActivity_act.class);
        startActivity(i);
    }
    public void Github(View v)
    {
        String[] listaLibros = {"Farenheti","Revival","Tesla","Hola mundo", "Adios mundo"};
        int[] costolib= {5000,10000,23000, 5000,8000};

        Intent i = new Intent(this, GitHub_act.class);
        i.putExtra("libros", listaLibros);
        i.putExtra("precio", costolib);
        startActivity(i);
    }
}