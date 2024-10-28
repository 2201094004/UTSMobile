package com.syaviraindahmaryam.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public CustomSpinnerAdapter(Context context, String[] values) {
        super(context, R.layout.spinner_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        TextView textView = rowView.findViewById(R.id.text_view_spinner);

        textView.setText(values[position]);

        if (position == 0) {
            textView.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
        } else {
            textView.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
        }

        return rowView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View rowView = getView(position, convertView, parent);
        return rowView;
    }
}
