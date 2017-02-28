package com.annadalnoki.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;

import com.annadalnoki.androidtest.R;

/**
 * Created by Anna on 17/02/28.
 */

public class DetailedPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_page);
    }
}
