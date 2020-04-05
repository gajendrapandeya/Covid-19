package com.codermonkeys.covid_19;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {

    private Context mContext;
    private ArrayList<HospitalItems> hospitalItems;

    public HospitalAdapter(Context mContext, ArrayList<HospitalItems> hospitalItems) {
        this.mContext = mContext;
        this.hospitalItems = hospitalItems;
    }

    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hospital_item, parent, false);
        return new HospitalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {

        HospitalItems currentItems = hospitalItems.get(position);
        Log.d("TAG", "onBindViewHolder: " + currentItems.getmHospitalName());
        holder.mTextViewHospitalName.setText(currentItems.getmHospitalName());
        holder.mTextViewHospitalOpenTime.setText(currentItems.getmHospitalOpenHours());
        holder.mTextViewHospitalContact.setText(currentItems.getmHospitalContact());
    }

    @Override
    public int getItemCount() {
        return hospitalItems.size();
    }

    public class HospitalViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewHospitalName, mTextViewHospitalOpenTime, mTextViewHospitalContact;

        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewHospitalName = itemView.findViewById(R.id.text_view_one);
            mTextViewHospitalOpenTime = itemView.findViewById(R.id.text_view_two);
            mTextViewHospitalContact = itemView.findViewById(R.id.text_view_three);
        }
    }
}
