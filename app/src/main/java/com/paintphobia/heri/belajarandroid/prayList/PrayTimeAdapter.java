package com.paintphobia.heri.belajarandroid.prayList;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paintphobia.heri.belajarandroid.R;
import com.paintphobia.heri.belajarandroid.services.PrayTimes;
import com.paintphobia.heri.belajarandroid.ui.custom.CustomTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heri on 6/12/2016.
 */
public class PrayTimeAdapter extends RecyclerView.Adapter<PrayTimeAdapter.ViewHolder>{

    private ArrayList<PrayTimes> item;
    private Context context;

    public PrayTimeAdapter(ArrayList<PrayTimes> item) {
        this.item = item;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pray_list, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardView.bringToFront();
        holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimary));

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

        @BindView(R.id.text_item_date)
        CustomTextView textPrayDate;

        @BindView(R.id.text_fajr)
        CustomTextView textFajr;

        @BindView(R.id.text_shurooq)
        CustomTextView textShurooq;

        @BindView(R.id.text_dhuhr)
        CustomTextView textDhuhr;

        @BindView(R.id.text_asr)
        CustomTextView textAsr;

        @BindView(R.id.text_maghrib)
        CustomTextView textMaghrib;

        @BindView(R.id.text_isha)
        CustomTextView textIsha;

        @BindView(R.id.cardView)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
