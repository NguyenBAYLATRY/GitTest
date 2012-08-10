package com.hubee.hh.launchertablet.envtbuilder.controllers;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.hubee.hh.launchertablet.envtbuilder.R;
import com.hubee.hh.launchertablet.model.Data;

public class SplashActivity extends Activity {
	public static final String PREFS_NAME = "PreferencesFile";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LOW_PROFILE);
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		setContentView(R.layout.activity_welcome);

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		Data.first_setup_ok = settings.getBoolean("first_setup_ok", false);
		Data.first_user_ok = settings.getBoolean("first_user_ok", false);
		if (!Data.first_setup_ok)
			startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
		this.finish();
	}

}
