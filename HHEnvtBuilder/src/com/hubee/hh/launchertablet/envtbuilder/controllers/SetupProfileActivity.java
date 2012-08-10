package com.hubee.hh.launchertablet.envtbuilder.controllers;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.hubee.hh.launchertablet.envtbuilder.R;

public class SetupProfileActivity extends FragmentActivity {
	RadioGroup age_chooser, occupation_chooser;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_profile_setup);
		age_chooser = (RadioGroup) findViewById(R.id.age_chooser);
		//age_chooser.
		age_chooser.setOnCheckedChangeListener(ToggleListener);
		occupation_chooser = (RadioGroup) findViewById(R.id.occupation_chooser);

		occupation_chooser.setOnCheckedChangeListener(ToggleListener);
	}

	static final RadioGroup.OnCheckedChangeListener ToggleListener = new RadioGroup.OnCheckedChangeListener() {
		public void onCheckedChanged(final RadioGroup radioGroup, final int i) {
			for (int j = 0; j < radioGroup.getChildCount(); j++) {
				final ToggleButton view = (ToggleButton) radioGroup
						.getChildAt(j);
				view.setChecked(view.getId() == i);
			}
		}
	};

	public void onToggle(View view) {
	    ((RadioGroup)view.getParent()).check(view.getId());
	    // app specific stuff ..
	}
	public void ignoreClick() {
		final Dialog dialog = new Dialog(SetupProfileActivity.this);
		dialog.setContentView(R.layout.dialog_ignore);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setCancelable(true);
		dialog.show();
	}
}
