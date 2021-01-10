package edu.upc.dsa.minimo2entregable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import edu.upc.dsa.minimo2entregable.models.Element;
import edu.upc.dsa.minimo2entregable.models.Museums;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Element> elements;
    private Context context;
    private View.OnClickListener listener;


    public void setData(List<Element> elements){
        this.elements = elements;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new MyAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_recyclerview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Element element = elements.get(position);
        String descripcion = element.getAdrecaNom();
        String URL_IMG=element.getImatge().get(0);
        Glide.with(context).load(URL_IMG).into(holder.imageView);
        holder.descripcion.setText(descripcion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("item", element);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView descripcion;
        ImageView imageView;
        public  View layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            descripcion = itemView.findViewById(R.id.descripcion);
            imageView=itemView.findViewById(R.id.icon);

        }
    }
}
