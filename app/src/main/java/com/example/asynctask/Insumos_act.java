package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {
    private EditText codee,name,precio,stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        codee = (EditText)findViewById(R.id.EtCode);
        name = (EditText)findViewById(R.id.EtName);
        precio = (EditText)findViewById(R.id.EtPrecio);
        stock = (EditText)findViewById(R.id.EtStock);
    }

    public void GuardarInsumo(View view)
    {
        AdminSQLiteOpenHelper sql = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = sql.getWritableDatabase();//permito la sobreescritura en mi base de datos

        if(!codee.getText().toString().isEmpty())
        {
            //Añade el insumo
            ContentValues registro = new ContentValues();

            registro.put("codigo",codee.getText().toString());
            registro.put("nombre",name.getText().toString());
            registro.put("precio",precio.getText().toString());
            registro.put("stock",stock.getText().toString());

            db.insert("insumos",null,registro);
            db.close();

            Toast.makeText(this,"Se ha guardado un insumo!",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Debe ingresar un insumo.", Toast.LENGTH_LONG).show();
        }
    }



    public void MostrarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = codee.getText().toString();
        if(!codigo.isEmpty())
        {
            Cursor fila = bd.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo = " +codigo,null);

            if(fila.moveToFirst())//Devuelve un resultado
            {
                name.setText(fila.getString(0));
                precio.setText(fila.getString(1));
                stock.setText(fila.getString(2));
            }
            else
            {
                Toast.makeText(this,"No hay insumos con el código asociado", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código del insumo", Toast.LENGTH_LONG).show();
        }


    }

    public void EliminarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codee.getText().toString();

        if (!codigo.isEmpty())
        {
            bd.delete("insumos","codigo="+codigo, null);
            Toast.makeText(this,"Has eliminado el insumo",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código del insumo", Toast.LENGTH_LONG).show();
        }

    }

    public void UpdateInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codee.getText().toString();

        ContentValues cont = new ContentValues();
        cont.put("codigo",codee.getText().toString());
        cont.put("nombre",codee.getText().toString());
        cont.put("precio",codee.getText().toString());
        cont.put("stock",codee.getText().toString());

        if (!codigo.isEmpty())
        {
            bd.update("insumos", cont, "codigo="+codigo,null);

            Toast.makeText(this,"Se ha actualizado el campo", Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código del insumo", Toast.LENGTH_LONG).show();
        }

    }


}