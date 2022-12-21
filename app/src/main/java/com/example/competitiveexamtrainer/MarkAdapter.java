package com.example.competitiveexamtrainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MarkAdapter extends RecyclerView.Adapter<MarkAdapter.ViewHolder> {

    Context context;
    List<MarkModel> mark_list;

    public MarkAdapter(Context context,List<MarkModel> mark_list) {
        this.context = context;
        this.mark_list = mark_list;
    }

    @NonNull
    @Override
    public MarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.marklist_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarkAdapter.ViewHolder holder, int position) {
        if(mark_list != null && mark_list.size() > 0){
            MarkModel model = mark_list.get(position);
            holder.text_rank.setText(String.valueOf(model.getRank()));
            holder.text_name.setText(model.getName());
            holder.text_mark.setText(String.valueOf(model.getMark()));
        }
        else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return mark_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_rank,text_name,text_mark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_rank = itemView.findViewById(R.id.tv_rank);
            text_name = itemView.findViewById(R.id.tv_name);
            text_mark = itemView.findViewById(R.id.tv_mark);
        }
    }
}
