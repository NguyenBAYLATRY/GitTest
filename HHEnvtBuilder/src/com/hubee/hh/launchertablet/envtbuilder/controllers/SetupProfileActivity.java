package com.hubee.hh.launchertablet.envtbuilder.controllers;

import com.hubee.hh.launchertablet.envtbuilder.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class SetupProfileActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_profile_setup);
	}
}
