package com.demotxt.myapp.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.demotxt.myapp.myapplication.R;
import com.demotxt.myapp.myapplication.activities.JobActivity;
import com.demotxt.myapp.myapplication.model.Job;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aws on 11/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Job> mData;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Job> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, JobActivity.class);
                i.putExtra("Bewerber_Kontakt", mData.get(viewHolder.getAdapterPosition()).getBewerber_Kontakt());
                i.putExtra("Bundesland", mData.get(viewHolder.getAdapterPosition()).getBundesland());
                i.putExtra("Einsatzort", mData.get(viewHolder.getAdapterPosition()).getEinsatzort());
                i.putExtra("Stelle_Aktiv_bis", mData.get(viewHolder.getAdapterPosition()).getStelle_Aktiv_bis());
                i.putExtra("Anscheiben_zur_Stelle", mData.get(viewHolder.getAdapterPosition()).getAnscheiben_zur_Stelle());
                i.putExtra("Bezeichnung_der_Stelle", mData.get(viewHolder.getAdapterPosition()).getBezeichnung_der_Stelle());
                i.putExtra("Logo", mData.get(viewHolder.getAdapterPosition()).getLogo());

                i.putExtra("E_Mail", mData.get(viewHolder.getAdapterPosition()).getE_Mail());
                i.putExtra("street", mData.get(viewHolder.getAdapterPosition()).getStreet());
                i.putExtra("anspreshpartner", mData.get(viewHolder.getAdapterPosition()).getAnspreshpartner());
                i.putExtra("umzeit", mData.get(viewHolder.getAdapterPosition()).getUmzeit());
                i.putExtra("abteilung", mData.get(viewHolder.getAdapterPosition()).getAbteilung());

                mContext.startActivity(i);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.bewerberkontant_item.setText(mData.get(position).getBewerber_Kontakt());
        holder.bundesland_item.setText(mData.get(position).getBundesland());
        holder.einsatzort_item.setText(mData.get(position).getEinsatzort());
        if (mData.get(position).getStelle_Aktiv_bis().isEmpty()) {
            holder.stelleaktivbis_item.setText("Stelle aktiv bis: Unbekannt");
        } else {
            holder.stelleaktivbis_item.setText("Stelle aktiv bis: " + mData.get(position).getStelle_Aktiv_bis());
        }

//        Glide.with(mContext).load(mData.get(position).getLogo()).apply(option).into(holder.img_thumbnail);
        Picasso.get().load(mData.get(position).getLogo()).into(holder.img_thumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bewerberkontant_item;
        TextView bundesland_item;
        TextView einsatzort_item;
        TextView stelleaktivbis_item;

        ImageView img_thumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            bewerberkontant_item = itemView.findViewById(R.id.bewerberkontaktitem);
            bundesland_item = itemView.findViewById(R.id.bundeslanditem);
            einsatzort_item = itemView.findViewById(R.id.einsatzortitem);
            stelleaktivbis_item = itemView.findViewById(R.id.stelleaktivbis);

            img_thumbnail = itemView.findViewById(R.id.logoitem);

        }
    }

}
