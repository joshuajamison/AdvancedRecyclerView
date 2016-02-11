package com.codeundone.advancedrecyclerview.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codeundone.advancedrecyclerview.R;

public class DummyDataHolder extends RecyclerView.ViewHolder {
    public TextView titleText;
    public TextView descText;
    public TextView metaText;

    public static DummyDataHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new DummyDataHolder(inflater.inflate(R.layout.item_dummy_data, parent, false));
    }

    public DummyDataHolder(View itemView) {
        super(itemView);
        titleText = (TextView) itemView.findViewById(R.id.title_text);
        descText = (TextView) itemView.findViewById(R.id.desc_text);
        metaText = (TextView) itemView.findViewById(R.id.meta_text);
    }

    public void bind(DummyData data) {
        titleText.setText(data.title);
        descText.setText(data.desc);
        metaText.setText(data.meta);
    }
}
