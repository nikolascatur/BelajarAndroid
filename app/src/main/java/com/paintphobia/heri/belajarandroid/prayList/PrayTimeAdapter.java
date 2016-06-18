package com.paintphobia.heri.belajarandroid.prayList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paintphobia.heri.belajarandroid.R;
import com.paintphobia.heri.belajarandroid.services.PrayTimes;
import com.paintphobia.heri.belajarandroid.ui.custom.CustomTextView;

import java.util.ArrayList;

/**
 * Created by heri on 6/12/2016.
 */
public class PrayTimeAdapter extends RecyclerView.Adapter<PrayTimeAdapter.ViewHolder>{

    private ArrayList<PrayTimes> item;

    public PrayTimeAdapter(ArrayList<PrayTimes> item) {
        this.item = item;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pray_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textPrayDate.setText(item.get(position).getDate_for());
        holder.textFajr.setText(item.get(position).getFajr());
        holder.textShurooq.setText(item.get(position).getShurooq());
        holder.textDhuhr.setText(item.get(position).getDhuhr());
        holder.textAsr.setText(item.get(position).getAsr());
        holder.textMaghrib.setText(item.get(position).getMaghrib());
        holder.textIsha.setText(item.get(position).getIsha());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CustomTextView textPrayDate,textFajr, textShurooq, textDhuhr, textAsr, textMaghrib, textIsha;
        public ViewHolder(View itemView) {
            super(itemView);

            textPrayDate = (CustomTextView) itemView.findViewById(R.id.text_item_date);
            textFajr = (CustomTextView) itemView.findViewById(R.id.text_fajr);
            textShurooq = (CustomTextView) itemView.findViewById(R.id.text_shurooq);
            textDhuhr = (CustomTextView) itemView.findViewById(R.id.text_dhuhr);
            textAsr = (CustomTextView) itemView.findViewById(R.id.text_asr);
            textMaghrib = (CustomTextView) itemView.findViewById(R.id.text_maghrib);
            textIsha = (CustomTextView) itemView.findViewById(R.id.text_isha);
        }
    }
}
