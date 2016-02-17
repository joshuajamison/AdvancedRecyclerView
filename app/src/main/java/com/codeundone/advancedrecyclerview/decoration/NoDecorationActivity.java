package com.codeundone.advancedrecyclerview.decoration;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codeundone.advancedrecyclerview.DetailActivity;
import com.codeundone.advancedrecyclerview.R;
import com.codeundone.advancedrecyclerview.data.DummyData;
import com.codeundone.advancedrecyclerview.data.DummyDataAdapter;

public class NoDecorationActivity extends DetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.no_decorators);
        }

        final DummyDataAdapter adapter = new DummyDataAdapter(this, DummyData.createDummyDataList());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

}
