package com.codermonkeys.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CasesAdapter extends RecyclerView.Adapter<CasesAdapter.CasesViewHolder> implements Filterable  {

    private Context mContext;
    private List<CasesItem> mItemCases;
    private List<CasesItem> mItemCasesAll;


    public CasesAdapter(Context mContext, List<CasesItem> mItemCases) {
        this.mContext = mContext;
        this.mItemCases = mItemCases;
        mItemCasesAll = new ArrayList<>(mItemCases);

    }

    @NonNull
    @Override
    public CasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_cases, parent, false);
        return new CasesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CasesViewHolder holder, int position) {

        CasesItem currentCases = mItemCases.get(position);


        String flagUrl = currentCases.getFlagUrl();
        String countryName = currentCases.getmCountryName();
        int totalCases = currentCases.getmTotalCases();
        int todayCases = currentCases.getmTodayCases();
        int totalDeaths = currentCases.getmTotalDeaths();
        int todayDeaths = currentCases.getmTodayDeaths();
        int recovered = currentCases.getmRecovered();
        int activeCases = currentCases.getmActiveCases();

        holder.mCountryName.setText(countryName);
        holder.mTotalCases.setText("Total Cases\n\t" + totalCases);
        holder.mTodayCases.setText("Today Cases\n\t" + todayCases);
        holder.mTotalDeaths.setText("Total Deaths\n\t" + totalDeaths);
        holder.mTodayDeaths.setText("Today Deaths\n\t" + todayDeaths);
        holder.mRecovered.setText(" Recovered\n\t" + recovered);
        holder.mActiveCases.setText("Active Cases\n\t" + activeCases);


        Glide.with(mContext).load(flagUrl).fitCenter().centerInside().into(holder.mFlagUrl);

    }

    @Override
    public int getItemCount() {
        return mItemCases.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

   private Filter filter = new Filter() {

        //runs of a background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<CasesItem> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0) {

                filteredList.addAll(mItemCasesAll);
            } else {

                String filterPattern = constraint.toString().toLowerCase().trim();
                for(CasesItem items: mItemCasesAll) {

                    if(items.getmCountryName().toLowerCase().contains(filterPattern)) {

                        filteredList.add(items);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        //runs on a ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mItemCases.clear();
            mItemCases.addAll((Collection<? extends CasesItem>) results.values);
            notifyDataSetChanged();
        }
    };

    public class CasesViewHolder extends RecyclerView.ViewHolder {

        private ImageView mFlagUrl;
        private TextView mCountryName, mTotalCases, mTodayCases, mTotalDeaths, mTodayDeaths, mRecovered, mActiveCases;
        public CasesViewHolder(@NonNull View itemView) {
            super(itemView);

            mFlagUrl = itemView.findViewById(R.id.image_view_flag);
            mCountryName = itemView.findViewById(R.id.text_view_country_name);
            mTodayCases = itemView.findViewById(R.id.text_view_today_cases);
            mTotalCases = itemView.findViewById(R.id.text_view_total_cases);
            mTotalDeaths = itemView.findViewById(R.id.text_view_total_deaths);
            mTodayDeaths = itemView.findViewById(R.id.text_view_today_deaths);
            mRecovered = itemView.findViewById(R.id.text_view_recovered);
            mActiveCases = itemView.findViewById(R.id.text_view_active_cases);


        }
    }




}
