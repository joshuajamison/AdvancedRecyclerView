package com.codeundone.advancedrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codeundone.advancedrecyclerview.animator.ItemAnimatorActivity;
import com.codeundone.advancedrecyclerview.complex.ComplexDecorationActivity;
import com.codeundone.advancedrecyclerview.simple.SimpleDecorationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.main_titles, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClicked(position);
            }
        });
    }

    private void onItemClicked(int position) {
        final Intent sdIntent = new Intent(this, SimpleDecorationActivity.class);
        switch (position) {
            case 0:
                startActivity(sdIntent);
                break;
            case 1:
                sdIntent.putExtra(SimpleDecorationActivity.KEY_DECORATION, 1);
                startActivity(sdIntent);
                break;
            case 2:
                sdIntent.putExtra(SimpleDecorationActivity.KEY_DECORATION, 2);
                startActivity(sdIntent);
                break;
            case 3:
                startActivity(new Intent(this, ComplexDecorationActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, ItemAnimatorActivity.class));
                break;
        }
    }
}
