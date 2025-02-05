package com.example.movie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private List<Trenting> trentingList=new ArrayList<>();
    private Context context;

    public MovieAdapter(List<Trenting> trentingList, Context context) {
        this.trentingList = trentingList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movierecycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        try {
            Glide.with(context).load(trentingList.get(position).getPoster()).into(holder.imageView);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //ImageView iv=v.findViewById();
                    Intent intent=new Intent(context,Detailed.class);
                    intent.putExtra("title",trentingList.get(position).getTitle());
                    intent.putExtra("release",trentingList.get(position).getReleasedate());
                    intent.putExtra("overview",trentingList.get(position).getOverview());
                    intent.putExtra("id",trentingList.get(position).getId());
                    intent.putExtra("poster",trentingList.get(position).getPoster());
                    intent.putExtra("rate",trentingList.get(position).getRate());
                    intent.putExtra("lang",trentingList.get(position).getLang());
                    intent.putExtra("age",trentingList.get(position).getAge());
                    context.startActivity(intent);
                    //holder.poster.setImageBitmap(trentingList.get(position).getPoster());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 20;
        //return trentingList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
