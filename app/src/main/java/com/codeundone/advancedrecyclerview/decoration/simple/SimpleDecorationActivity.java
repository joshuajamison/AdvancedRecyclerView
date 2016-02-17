package com.codeundone.advancedrecyclerview.decoration.simple;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codeundone.advancedrecyclerview.DetailActivity;
import com.codeundone.advancedrecyclerview.R;
import com.codeundone.advancedrecyclerview.data.DummyData;
import com.codeundone.advancedrecyclerview.data.DummyDataAdapter;

public class SimpleDecorationActivity extends DetailActivity {

    public static final String KEY_DECORATION = "keyDecoration";
    public static final int VALUE_DECORATION_1 = 0;
    public static final int VALUE_DECORATION_2 = 1;
    public static final int VALUE_DECORATION_3 = 2;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        final Bundle extras = getIntent().getExtras();
        final int decValue = extras == null ? VALUE_DECORATION_1 : extras.getInt(KEY_DECORATION, VALUE_DECORATION_1);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.simple_decorators);
        }

        final DummyDataAdapter adapter = new DummyDataAdapter(this, DummyData.createDummyDataList());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        switch (decValue) {
            case VALUE_DECORATION_1:
                recyclerView.addItemDecoration(new Simple1Decoration(this));
                break;
            case VALUE_DECORATION_2:
                recyclerView.addItemDecoration(new Simple2Decoration(this));
                break;
            case VALUE_DECORATION_3:
                recyclerView.addItemDecoration(new Simple1Decoration(this));
                recyclerView.addItemDecoration(new Simple2Decoration(this));
                break;
        }

        recyclerView.setAdapter(adapter);
    }

}
