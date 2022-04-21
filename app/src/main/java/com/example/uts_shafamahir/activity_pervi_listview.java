package com.example.uts_shafamahir;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class activity_pervi_listview extends Fragment {

    public activity_pervi_listview(){

    }

    public static ArrayList<Shape> shappeList = new ArrayList<Shape>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_pervi_listview, container, false);
        setupData();

        listView = v.findViewById(R.id.shapeListview);
        activity_pervi_listview_cell adapter = new activity_pervi_listview_cell(getContext(), 0, shappeList);
        listView.setAdapter(adapter);

        setupOnClickListener();
        return v;
    }

    public void setupData(){
        Shape offjumpol = new Shape("0", "Off Jumpol       31 Tahun  ", R.drawable.offjumpol);
        shappeList.add(offjumpol);

        Shape gunatthaphan = new Shape("1", "Gun Atthaphan  28 Tahun", R.drawable.gunatthaphan);
        shappeList.add(gunatthaphan );

        Shape maxsaran = new Shape("2", "Max Saran     28 Tahun", R.drawable.maxsaran);
        shappeList.add(maxsaran);

        Shape natnatasitt = new Shape("3", "Nat Natasitt       19 Tahun", R.drawable.natnatasitt);
        shappeList.add(natnatasitt);

        Shape billkinputthipong = new Shape("4", "Billkin Putthipong  22 Tahun", R.drawable.billkinputthipong);
        shappeList.add(billkinputthipong);

        Shape ppkrit = new Shape("5", "Pp Krit              22 Tahun", R.drawable.ppkrit);
        shappeList.add(ppkrit);
    }

    private void setupOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shape selectShape = (Shape) listView.getItemAtPosition(i);
                Intent showDetail = new Intent(getContext(), activity_pervi_listview_detail.class);
                showDetail.putExtra("id", selectShape.getId());
                startActivity(showDetail);
            }
        });
    }
}