package com.example.colorcodes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> implements Filterable {
    Context context;
    ArrayList<ColorModel> colorList;
    ArrayList<ColorModel> colorListFull;

    public ColorAdapter(Context context, ArrayList<ColorModel> colorList) {
        this.context = context;
        this.colorList = colorList;
        this.colorListFull = new ArrayList<>(colorList);
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        ColorModel color = colorList.get(position);
        holder.colorName.setText(color.getName());
        holder.colorCode.setText(color.getHexCode());
        holder.itemView.setBackgroundColor(Color.parseColor(color.getHexCode()));

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "Color Code: " + color.getHexCode(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {
        TextView colorName, colorCode;
        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            colorName = itemView.findViewById(R.id.colorName);
            colorCode = itemView.findViewById(R.id.colorCode);
        }
    }

    @Override
    public Filter getFilter() {
        return colorFilter;
    }

    private final Filter colorFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ColorModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(colorListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ColorModel color : colorListFull) {
                    if (color.getName().toLowerCase().contains(filterPattern) ||
                        color.getHexCode().toLowerCase().contains(filterPattern)) {
                        filteredList.add(color);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            colorList.clear();
            colorList.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}
