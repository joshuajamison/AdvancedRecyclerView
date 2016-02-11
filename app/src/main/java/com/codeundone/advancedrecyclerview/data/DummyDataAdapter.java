package com.codeundone.advancedrecyclerview.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codeundone.advancedrecyclerview.R;

import java.util.List;

public class DummyDataAdapter extends RecyclerView.Adapter<DummyDataHolder> {

    private final LayoutInflater inflater;
    private final List<DummyData> data;

    public DummyDataAdapter(Context context, List<DummyData> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public DummyDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DummyDataHolder(inflater.inflate(R.layout.item_dummy_data, parent, false));
    }

    @Override
    public void onBindViewHolder(DummyDataHolder holder, int position) {
        holder.bind(data.get(position));
    }
}
