package adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fau.labandroidretrofit.R;

import java.util.List;

import models.Country;

public class CountriesListAdapter extends RecyclerView.Adapter<CountriesListAdapter.CountriesViewHolder>{

    List<Country> countriesList;

    public CountriesListAdapter(List<Country> countriesList) {

        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.countries_list_item, parent, false);
        CountriesViewHolder viewHolder = new CountriesViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        //llamada al API
        ApiService myService = ApiAdapter.getAPICountriesList();
        countriesList = (List<Country>) myService.getCountries();
        //llamada al API

        Country cc = countriesList.get(position);
        holder.countries_name.setText(cc.getCountry());
    }

    //cuenta la cantidad de items que se reciben
    @Override
    public int getItemCount() {

        return countriesList.size();
    }

    //viewholder para llenar el contenido de cada item
    public static class CountriesViewHolder extends RecyclerView.ViewHolder {
        public TextView countries_name;

        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);

            this.countries_name = (TextView) itemView.findViewById(R.id.tv_country_name);
        }
    }
}
