package com.example.myapplication.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.entity.Exercise;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Exercise> exercises;



    public RecyclerViewAdapter(List<Exercise> exercises) {

        this.exercises = exercises;

    }



    @NonNull

    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.item_exercise, parent, false);

        ViewHolder holder = new ViewHolder(view);

        // 设置Item点击的监听器

        view.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                // 跳转到习题详情页

            }

        });

        return holder;

    }



    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        Exercise exercise = exercises.get(position);

        holder.tvOrder.setText(String.valueOf(exercise.getId()));

        holder.tvTitle.setText(exercise.getTitle());

        holder.tvSubTitle.setText(exercise.getSubTitle());



        // 设置圆角背景的颜色

        GradientDrawable drawable = (GradientDrawable) holder.tvOrder.getBackground();

        drawable.setColor(Color.parseColor(exercise.getBgColor()));

    }



    @Override

    public int getItemCount() {

        return exercises.size();

    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrder, tvTitle, tvSubTitle;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tvOrder = itemView.findViewById(R.id.tv_order);

            tvTitle = itemView.findViewById(R.id.tv_title);

            tvSubTitle = itemView.findViewById(R.id.tv_sub_title);

        }

    }

}