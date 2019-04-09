package com.example.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity  {
    ListView list;
    String[] countries={"c1","2","Jordan","Amman"};
    ArrayList<String> countries2;
    Button addBtn;
    EditText countryInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        countries2=new ArrayList();

        addBtn=(Button) findViewById(R.id.country_add_btn);
        countryInput=findViewById(R.id.country_name);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=countryInput.getText().toString();
                countries2.add(text);
                ArrayAdapter arrayAdapter=new ArrayAdapter(SpinnerActivity.this,R.layout.support_simple_spinner_dropdown_item,countries2);

                list.setAdapter(arrayAdapter);

            }
        });





        list=(ListView) findViewById(R.id.list1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(SpinnerActivity.this,R.layout.support_simple_spinner_dropdown_item,countries);

        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SpinnerActivity.this,""+countries2.get(position),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(SpinnerActivity.this,DetailsActivity.class);
            intent.putExtra("country","Palestine");
            startActivity(intent);
            }
        });
    }

    public void show(View view){

    }

}
