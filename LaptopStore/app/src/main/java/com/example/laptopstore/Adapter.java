package com.example.laptopstore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHold> {
    private LayoutInflater mInflater;
    private Context context;

    private ArrayList<lap> list;

    // data is passed into the constructor
    public Adapter(ArrayList<lap> list, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    //link cardview with adapter
    public ViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.cardview, viewGroup, false);
        return new ViewHold(view);
    }

    @Override
    //fill my items b item of cardview
    public void onBindViewHolder(@NonNull ViewHold viewHold, final int i) {
        int l = list.get(i).img;
        viewHold.i.setImageResource(l);
        String l2 = list.get(i).name;
        viewHold.t.setText(l2);
        viewHold.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, LapActivity.class);
                in.putExtra("Tiltle", list.get(i).getName());

                in.putExtra("iv", list.get(i).getImg());
                in.putExtra("des", list.get(i).getLap_de()); //
                context.startActivity(in);
            }
        });

    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public void add(lap lap) {
        list.add(lap);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //to linke the item of cardview in new var
    public class ViewHold extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView i;
        TextView t;

        public ViewHold(@NonNull View itemView) {
            super(itemView);
            i = (ImageView) itemView.findViewById(R.id.iv);
            t = (TextView) itemView.findViewById(R.id.tv);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }

    }

}

