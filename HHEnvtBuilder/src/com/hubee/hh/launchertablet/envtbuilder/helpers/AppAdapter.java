package com.hubee.hh.launchertablet.envtbuilder.helpers;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hubee.hh.launchertablet.envtbuilder.R;
import com.hubee.hh.launchertablet.model.App;

public class AppAdapter extends ArrayAdapter<App> {

	Context context;
	ArrayList<App> values;

	public AppAdapter(Context context, ArrayList<App> values) {
		super(context, R.layout.app_row, values);
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.app_row, parent, false);
		TextView app_label = (TextView) rowView.findViewById(R.id.app_label);
	    ImageView app_img = (ImageView) rowView.findViewById(R.id.app_img);
	    app_label.setText(values.get(position).name);
		
		return rowView;
	}
}
