package com.labs.gilang.costkosanv03;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;

public class RencanaFragment extends Fragment {
    float rainfall[] = {1200f, 750f, 900f, 1000f, 1200f, 750f, 900f, 1000f};
    String pengeluaran[] = {"Kuliah","Kost","Makanan","Lain lain","Kuliah","Kost","Makanan","Lain lain"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rencana, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(getActivity(), "Berhasil berhasil hore", Toast.LENGTH_SHORT).show();
//            }
//        });

        setupPieChart();
    }

    //    pie chart
    private void setupPieChart(){
        java.util.List<com.github.mikephil.charting.data.PieEntry> pieEntries = new java.util.ArrayList<>();
        for (int i=0 ; i<rainfall.length ; i++){
            pieEntries.add(new com.github.mikephil.charting.data.PieEntry(rainfall[i], pengeluaran[i]));
        }

        com.github.mikephil.charting.data.PieDataSet dataSet = new com.github.mikephil.charting.data.PieDataSet(pieEntries, "Laporan per-Bulan");
        dataSet.setColors(com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS);
        com.github.mikephil.charting.data.PieData data = new com.github.mikephil.charting.data.PieData(dataSet);

        PieChart chart = (PieChart) getView().findViewById(R.id.piechart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();
    }
}
