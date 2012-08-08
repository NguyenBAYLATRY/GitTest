package com.hubee.hh.launchertablet.envtbuilder.controllers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.hubee.hh.launchertablet.envtbuilder.R;

public class SetupAccountActivity extends Activity {
	private Button add, next, previous, ignore;
	private TextView options, password;
	private CheckBox parental, size;
	private EditText user_input;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		setContentView(R.layout.activity_account_setup);

		add = (Button) findViewById(R.id.add_password);
		add.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final Dialog dialog = new Dialog(SetupAccountActivity.this);
				dialog.setContentView(R.layout.dialog_password_account_setup);
				dialog.setCanceledOnTouchOutside(true);
				dialog.setCancelable(true);
				Button ok = (Button) dialog.findViewById(R.id.setup_password);
				ok.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				dialog.show();
				
			}
		});
		next = (Button) findViewById(R.id.user_input_next);
		next.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(SetupAccountActivity.this, SetupProfileActivity.class));
			}
		});
		previous = (Button) findViewById(R.id.user_input_previous);
		previous.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				previousClick();
				
			}
			
		});
		ignore = (Button) findViewById(R.id.user_input_ignore);
		ignore.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				ignoreClick();
				
			}
			
		});
		

		options = (TextView) findViewById(R.id.options_textview);
		password = (TextView) findViewById(R.id.password_textview);

		parental = (CheckBox) findViewById(R.id.parental_control);
		size = (CheckBox) findViewById(R.id.text_size);

		user_input = (EditText) findViewById(R.id.user_input_edittext);
		user_input.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				if(s.length() != 0)
					enable();
				else
					disable();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});
		
		disable();
	}

	public void ignoreClick() {
		System.exit(0);
	}

	public void enable() {
		add.setVisibility(View.VISIBLE);
		next.setVisibility(View.VISIBLE);
		options.setVisibility(View.VISIBLE);
		password.setVisibility(View.VISIBLE);
		parental.setVisibility(View.VISIBLE);
		size.setVisibility(View.VISIBLE);
	}
	
	public void disable() {
		add.setVisibility(View.INVISIBLE);
		next.setVisibility(View.INVISIBLE);
		options.setVisibility(View.INVISIBLE);
		password.setVisibility(View.INVISIBLE);
		parental.setVisibility(View.INVISIBLE);
		size.setVisibility(View.INVISIBLE);
	}
	
	public void previousClick() {
		this.finish();
	}
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK)
			this.finish();
		return false;
	}
}
