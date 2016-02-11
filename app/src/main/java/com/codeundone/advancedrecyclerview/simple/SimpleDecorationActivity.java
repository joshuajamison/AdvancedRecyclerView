package com.codeundone.advancedrecyclerview.simple;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeundone.advancedrecyclerview.DetailActivity;
import com.codeundone.advancedrecyclerview.R;
import com.codeundone.advancedrecyclerview.data.DummyData;
import com.codeundone.advancedrecyclerview.data.DummyDataHolder;

import java.util.List;

public class SimpleDecorationActivity extends DetailActivity {

    public static final String KEY_DECORATION = "keyDecoration";
    public static final int VALUE_DECORATION_1 = 0;
    public static final int VALUE_DECORATION_2 = 1;
    public static final int VALUE_DECORATION_3 = 2;

    RecyclerView recyclerView;
    private List<DummyData> dummyDataList;

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

        dummyDataList = DummyData.createDummyDataList();

        final SimpleAdapter adapter = new SimpleAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        switch (decValue) {
            case VALUE_DECORATION_1:
                recyclerView.addItemDecoration(new Simple1Decoration(this, Color.BLACK));
                break;
            case VALUE_DECORATION_2:
                recyclerView.addItemDecoration(new Simple2Decoration(this, Color.BLUE, Color.RED));
                break;
            case VALUE_DECORATION_3:
                recyclerView.addItemDecoration(new Simple1Decoration(this, Color.BLACK));
                recyclerView.addItemDecoration(new Simple2Decoration(this, Color.BLUE, Color.RED));
                break;
        }

        recyclerView.setAdapter(adapter);
    }

    public class SimpleAdapter extends RecyclerView.Adapter<SimpleHolder> {

        private final LayoutInflater inflater;

        public SimpleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getItemCount() {
            return dummyDataList.size();
        }

        @Override
        public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = inflater.inflate(R.layout.item_dummy_data, parent, false);
            return new SimpleHolder(view);
        }

        @Override
        public void onBindViewHolder(SimpleHolder holder, int position) {
            holder.bind(dummyDataList.get(position));
        }
    }

    public class SimpleHolder extends DummyDataHolder {
        public SimpleHolder(View itemView) {
            super(itemView);
        }
    }
}
