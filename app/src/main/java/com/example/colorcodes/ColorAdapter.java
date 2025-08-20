package com.example.colorscodes;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    private List<ColorModel> colorList;
    private List<ColorModel> fullList;

    public ColorAdapter(List<ColorModel> colorList) {
        this.colorList = colorList;
        this.fullList = new ArrayList<>(colorList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_color, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ColorModel color = colorList.get(position);
        holder.colorName.setText(color.getName());
        holder.colorCode.setText(color.getCode());
        holder.colorView.setBackgroundColor(Color.parseColor(color.getCode()));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public void filter(String text) {
        colorList.clear();
        if (text == null || text.isEmpty()) {
            colorList.addAll(fullList);
        } else {
            text = text.toLowerCase();
            for (ColorModel item : fullList) {
                if (item.getName().toLowerCase().contains(text) || item.getCode().toLowerCase().contains(text)) {
                    colorList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView colorName, colorCode;
        View colorView;

        public ViewHolder(View itemView) {
            super(itemView);
            colorName = itemView.findViewById(R.id.colorName);
            colorCode = itemView.findViewById(R.id.colorCode);
            colorView = itemView.findViewById(R.id.colorView);
        }
    }
}
