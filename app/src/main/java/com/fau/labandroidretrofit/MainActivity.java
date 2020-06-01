package com.fau.labandroidretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapters.ApiAdapter;
import adapters.ApiService;
import adapters.CountriesListAdapter;
import models.Country;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_countries;
    private List<Country> countriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rv_countries = findViewById(R.id.rv_countries);
        this.countriesList = getCountries();

        CountriesListAdapter myCountriesAdapter = new CountriesListAdapter(this.countriesList);
        this.rv_countries.setLayoutManager(new LinearLayoutManager(this));
        this.rv_countries.setAdapter(myCountriesAdapter);
    }

    //aqui debemos hacer la llamada al API
    private List<Country> getCountries(){
        ApiService myService = ApiAdapter.getAPICountriesList();
        List<Country> myCountriesList = (List<Country>) myService.getCountries();

        return myCountriesList;
    }
}