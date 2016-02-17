package com.codeundone.advancedrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codeundone.advancedrecyclerview.decoration.NoDecorationActivity;
import com.codeundone.advancedrecyclerview.decoration.complex.ComplexDecorationActivity;
import com.codeundone.advancedrecyclerview.decoration.simple.SimpleDecorationActivity;

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
        final Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, NoDecorationActivity.class);
                break;
            case 1:
                intent.setClass(this, SimpleDecorationActivity.class);
                break;
            case 2:
                intent.setClass(this, SimpleDecorationActivity.class);
                intent.putExtra(SimpleDecorationActivity.KEY_DECORATION, 1);
                break;
            case 3:
                intent.setClass(this, SimpleDecorationActivity.class);
                intent.putExtra(SimpleDecorationActivity.KEY_DECORATION, 2);
                break;
            case 4:
            default:
                intent.setClass(this, ComplexDecorationActivity.class);
                break;
        }
        startActivity(intent);
    }
}
