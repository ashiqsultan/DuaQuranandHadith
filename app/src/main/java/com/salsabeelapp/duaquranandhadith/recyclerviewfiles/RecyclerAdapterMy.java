package com.salsabeelapp.duaquranandhadith.recyclerviewfiles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salsabeelapp.duaquranandhadith.QuranDua;
import com.salsabeelapp.duaquranandhadith.R;

import java.util.ArrayList;

/**
 * Created by zashiq on 21-Aug-16.
 */

public class RecyclerAdapterMy extends RecyclerView.Adapter<RecyclerAdapterMy.RecyclerHoldMy> {

    private Context context;
    private ArrayList<GetandSet> gsList;
    private LayoutInflater inflater;


    public RecyclerAdapterMy(ArrayList<GetandSet> gsList, Context context) {
        this.gsList = gsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerHoldMy onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.dua_list_item, parent, false);

        return new RecyclerHoldMy(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHoldMy holder, int position) {

        QuranDua qd = new QuranDua();

        final GetandSet gsItem = gsList.get(position);

        holder.tvArabictext.setText(gsItem.getArabictext());
        holder.tvTamiltext.setText(gsItem.getTamiltext());
        holder.tvReference.setText(gsItem.getReference());

        if (QuranDua.viewBothBoolean) {
            holder.tvArabictext.setVisibility(View.VISIBLE);
            holder.tvTamiltext.setVisibility(View.VISIBLE);
            holder.tvArabictext.setTextSize(30);
            holder.tvTamiltext.setTextSize(QuranDua.TAMILFONTSIZE);
            Log.d("TAG", "THATS WORKING Both");
        } else if (QuranDua.viewArabicBoolean) {
            holder.tvArabictext.setVisibility(View.VISIBLE);
            holder.tvTamiltext.setVisibility(View.INVISIBLE);
            holder.tvTamiltext.setTextSize(1);
            Log.d("TAG", "THATS WORKING Arabic");
        } else if (QuranDua.viewTamilBoolean) {
            holder.tvArabictext.setVisibility(View.INVISIBLE);
            holder.tvTamiltext.setVisibility(View.VISIBLE);
            holder.tvArabictext.setTextSize(1);
            holder.tvTamiltext.setTextSize(QuranDua.TAMILFONTSIZE);
            Log.d("TAG", "THATS WORKING Tamil");
        }

        /*if (qd.b1.booleanValue()) {
            holder.tvArabictext.setVisibility(View.VISIBLE);
            holder.tvTamiltext.setVisibility(View.VISIBLE);
        }else if (isArabic) {
            holder.tvArabictext.setVisibility(View.VISIBLE);
            holder.tvTamiltext.setVisibility(View.INVISIBLE);
        }else if(isTamil){
            holder.tvArabictext.setVisibility(View.INVISIBLE);
            holder.tvTamiltext.setVisibility(View.VISIBLE);
        }*/

        if (position == getItemCount() - 1) {
            holder.dividerLine.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return gsList.size();
    }

    //Holder class
    class RecyclerHoldMy extends RecyclerView.ViewHolder {

        TextView tvArabictext;
        TextView tvTamiltext;
        TextView tvReference;
        View dividerLine;
        View container01;

        public RecyclerHoldMy(View itemView) {
            super(itemView);
            context = itemView.getContext();

            tvArabictext = (TextView) itemView.findViewById(R.id.tvArabictext);
            tvTamiltext = (TextView) itemView.findViewById(R.id.tvTamiltext);
            tvReference = (TextView) itemView.findViewById(R.id.tvReference);
            dividerLine = itemView.findViewById(R.id.dividerLine);
            container01 = itemView.findViewById(R.id.LLforDuaTextItems);

            //We'll need the container later on, when we add an View.OnClickListener
            // container = itemView.findViewById(R.id.cont_item_root);
        }

    }
}
