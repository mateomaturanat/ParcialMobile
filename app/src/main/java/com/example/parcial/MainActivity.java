package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    String name, description, iva;
    int code;
    double value;
    Button submit;
    ArrayList<Product> productList, ProductListHigher, ProductListLess;
    ListView lvHigher, lvLess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHigher =(ListView)findViewById(R.id.listHigher);
        lvLess=(ListView)findViewById(R.id.listLess);
        code=Integer.parseInt(findViewById(R.id.editId).toString());
        name=findViewById(R.id.editName).toString();
        value=Double.parseDouble(findViewById(R.id.editValue).toString());
        description=findViewById(R.id.editDescription).toString();
        iva=findViewById(R.id.editIva).toString();
        submit=(Button) findViewById(R.id.bntSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product objProduct= new Product(code,name,value,iva,description);
                productList.add(objProduct);
                Toast.makeText(getApplicationContext(),"Se han guardado los datos",Toast.LENGTH_SHORT).show();
                ProductListHigher=productList;
                ProductListLess=productList;
                Collections.sort(ProductListHigher, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return new Double(p2.getValue()).compareTo(new Double(p1.getValue()));
                    }
                });
                Collections.sort(ProductListLess, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return new Double(p1.getValue()).compareTo(new Double(p2.getValue()));
                    }
                });
                int cont=ProductListHigher.size();
                    while(ProductListHigher.size()>10){
                        ProductListHigher.remove(cont-1);
                        ProductListLess.remove(cont-1);
                        cont--;
                    }
                ArrayAdapter <Product> adapterHigher=new ArrayAdapter<Product> (MainActivity.this,0,ProductListHigher);
                lvHigher.setAdapter(adapterHigher);
                ArrayAdapter <Product> adapterLess=new ArrayAdapter<Product> (MainActivity.this,0,ProductListLess);
                lvLess.setAdapter(adapterLess);
            }
        });
    }
}