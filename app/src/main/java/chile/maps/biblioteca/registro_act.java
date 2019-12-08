package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registro_act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_act);

        et1 = (EditText)findViewById(R.id.cod);
        et2 = (EditText)findViewById(R.id.nombre);
        et3 = (EditText)findViewById(R.id.precio);
    }

    public void añadirLibro(View v)
    {
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "libros", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            BaseDeDatos.insert("libros", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Se ha ingresado un libro", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarLibro(View view){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "libros", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        BaseDeDatos.delete("libros", "codigo="+codigo, null);
        BaseDeDatos.close();

        Toast.makeText(this, "Producto eliminado corectamente, Codigo = "+codigo, Toast.LENGTH_SHORT).show();

    }

    public void modificarLibro(View v){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "libros", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues con = new ContentValues();

        String codigo = et1.getText().toString();
        con.put("codigo",et1.getText().toString());
        con.put("nombre",et2.getText().toString());
        con.put("precio", et3.getText().toString());


        if (!et1.getText().toString().isEmpty()){
            BaseDeDatos.update("libros", con ,"codigo="+codigo,null);
            Toast.makeText(this, "Se ah actualizado el producto con el Codigo = "+codigo, Toast.LENGTH_SHORT).show();
        }
    }
}
