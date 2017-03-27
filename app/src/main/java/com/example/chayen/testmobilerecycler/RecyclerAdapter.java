package com.example.chayen.testmobilerecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chayen on 27-Mar-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private MyClickListener mCallback;
    private ArrayList<RecyclerAdapterClass> mDataset;
    private Context context;

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_adapter_list, parent, false);
        ViewHolder dataObjHolder = new ViewHolder(view);
        context = parent.getContext();
        return dataObjHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.recycler_textname.setText(mDataset.get(position).getTextview());
        Picasso.with(context).load(mDataset.get(position).getImageview()).into(holder.recycler_image);
    }

    @Override
    public int getItemCount() {
//        Log.d("testRecycler", "" + mDataset.size());
        return mDataset.size();
    }

    public void setOnItemClickListener(MyClickListener mCallback){
        this.mCallback = mCallback;
    }

    public RecyclerAdapter(ArrayList<RecyclerAdapterClass> myDataset){
        mDataset = myDataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView recycler_textname;
        private ImageView recycler_image;

        public ViewHolder(View itemView) {
            super(itemView);
            recycler_textname = (TextView)itemView.findViewById(R.id.recycler_adaptername);
            recycler_image = (ImageView)itemView.findViewById(R.id.recycler_adapterimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallback.onItemClick(getAdapterPosition(), v);
        }
    }

    public interface MyClickListener{
        public void onItemClick(int position, View v);
    }
}
