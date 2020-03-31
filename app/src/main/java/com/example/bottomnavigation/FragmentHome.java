package com.example.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;

public class FragmentHome extends Fragment implements View.OnClickListener {
    TextView textView;
    Button button, button1;
    Button persiapan, umroh, haji, dzikir, carahaji, caraumrah, peta, lokasi, tnj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        button = view.findViewById(R.id.btncity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(getActivity(), MapsActivity.class);
                startActivity(mintent);
            }
        });

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = view.findViewById(R.id.text_date);
        textViewDate.setText(currentDate);

        Intent intent = getActivity().getIntent();
        button.setText(intent.getStringExtra("mycity"));

        persiapan = view.findViewById(R.id.persiapanhaji);
        persiapan.setOnClickListener(this);
        umroh = view.findViewById(R.id.fiqihumroh);
        umroh.setOnClickListener(this);
        haji = view.findViewById(R.id.fiqihhaji);
        haji.setOnClickListener(this);
        dzikir = view.findViewById(R.id.dzikir);
        dzikir.setOnClickListener(this);
        caraumrah = view.findViewById(R.id.tatacara);
        caraumrah.setOnClickListener(this);
        carahaji = view.findViewById(R.id.tatacarhaji);
        carahaji.setOnClickListener(this);
        peta = view.findViewById(R.id.petajarak);
        peta.setOnClickListener(this);
        lokasi = view.findViewById(R.id.lokasi);
        lokasi.setOnClickListener(this);
        tnj = view.findViewById(R.id.tanyajawab);
        tnj.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.optionmenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.daftar) {
            startActivity(new Intent(getActivity(), DaftarIsi.class));
        } else if (item.getItemId() == R.id.rate) {
            startActivity(new Intent(getActivity(), Rate.class));
        } else if (item.getItemId() == R.id.tentang) {
            startActivity(new Intent(getActivity(), Tentang.class));
        } else if (item.getItemId() == R.id.search) {
            startActivity(new Intent(getActivity(), search.class));
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.persiapanhaji:
                Intent persiap = new Intent(getActivity(), persiapanhaji.class);
                startActivity(persiap);
                break;
            case R.id.fiqihhaji:
                Intent fhaj = new Intent(getActivity(), FiqihHaji.class);
                startActivity(fhaj);
                break;
            case R.id.fiqihumroh:
                Intent fum = new Intent(getActivity(), FiqihUmrah.class);
                startActivity(fum);
                break;
            case R.id.dzikir:
                Intent dz = new Intent(getActivity(), DzikirDoa.class);
                startActivity(dz);
                break;
        }
    }
}
