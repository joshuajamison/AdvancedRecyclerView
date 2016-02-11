package com.codeundone.advancedrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public abstract class DetailActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
