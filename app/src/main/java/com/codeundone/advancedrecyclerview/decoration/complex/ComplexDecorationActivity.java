package com.codeundone.advancedrecyclerview.decoration.complex;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codeundone.advancedrecyclerview.DetailActivity;
import com.codeundone.advancedrecyclerview.R;
import com.codeundone.advancedrecyclerview.data.DummyData;
import com.codeundone.advancedrecyclerview.data.DummyDataAdapter;

import java.util.List;

public class ComplexDecorationActivity extends DetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.complex_decorator);
        }

        final List<DummyData> data = DummyData.createDummyDataListSorted();
        final DummyDataAdapter adapter = new DummyDataAdapter(this, data);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.addItemDecoration(new ComplexDecoration(this, new ComplexDecoration.Callback() {
            @Override
            public long getGroupId(int position) {
               return Character.toUpperCase(data.get(position).title.charAt(0));
            }

            @Override
            public String getGroupFirstLine(int position) {
                return data.get(position).title.substring(0, 1).toUpperCase();
            }
        }));

        recyclerView.setAdapter(adapter);
    }

}
