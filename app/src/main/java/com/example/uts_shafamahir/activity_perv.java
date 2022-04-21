package com.example.uts_shafamahir;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_perv extends AppCompatActivity {

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perv);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shape offjumpol = new Shape("0", "Off Jumpol             31 Tahun", R.drawable.offjumpol);
        shapeList.add(offjumpol);

        Shape gunatthaphan = new Shape("1","Gun Atthaphan           28 Tahun", R.drawable.gunatthaphan);
        shapeList.add(gunatthaphan);

        Shape maxsaran = new Shape("2","Max Saran                  28 Tahun", R.drawable.maxsaran);
        shapeList.add(maxsaran);

        Shape natnatasitt = new Shape("3","Nat Natasitt           19 Tahun", R.drawable.natnatasitt);
        shapeList.add(natnatasitt);

        Shape billkinputthipong = new Shape("4","Billkin Putthipong     22 Tahun", R.drawable.billkinputthipong);
        shapeList.add(billkinputthipong);

        Shape ppkrit = new Shape("5", "PP Krit                    22 Tahun", R.drawable.ppkrit);
        shapeList.add(ppkrit);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        activity_perv_adapter adapter = new activity_perv_adapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), activity_perv_detail.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }
}