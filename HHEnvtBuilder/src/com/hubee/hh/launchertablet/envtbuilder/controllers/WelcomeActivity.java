package com.hubee.hh.launchertablet.envtbuilder.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.hubee.hh.launchertablet.envtbuilder.R;

public class WelcomeActivity extends Activity {
	private Button ignore, next;
// salut je suis carole
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        ignore = (Button) findViewById(R.id.welcome_ignore);
        ignore.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ignoreClick();
				
			}
        	
        });
        
        next = (Button) findViewById(R.id.welcome_next);
        next.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				nextClick();
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_welcome, menu);
        return true;
    }
    
    public void ignoreClick(){
    	System.exit(0);
    }
    
    public void nextClick(){
    	startActivity(new Intent(this, SetupAccountActivity.class));
    }
}
