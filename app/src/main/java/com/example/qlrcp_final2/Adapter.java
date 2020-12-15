package com.example.qlrcp_final2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewClass> {

    ArrayList<String> tenphim;
    ArrayList<String> theloai;
    Context context;

    public Adapter(ArrayList<String> tenphim, ArrayList<String> theloai,Context context) {
        this.tenphim = tenphim;
        this.theloai = theloai;
        this.context=context;
    }





    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_dsphim,parent,false);
        MyViewClass myViewClass = new MyViewClass(view);

        return myViewClass;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.tenphim.setText(tenphim.get(position));
        holder.theloai.setText(theloai.get(position));
    }

    @Override
    public int getItemCount() {
        return tenphim.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder{

        TextView tenphim;
        TextView theloai;

        public MyViewClass(@NonNull View itemView) {
            super(itemView);

            tenphim=(TextView) itemView.findViewById(R.id.tenphim);
            theloai=(TextView) itemView.findViewById(R.id.theloai);


        }
    }

}

