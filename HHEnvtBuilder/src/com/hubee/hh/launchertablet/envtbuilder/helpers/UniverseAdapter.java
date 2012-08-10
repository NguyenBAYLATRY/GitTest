package com.hubee.hh.launchertablet.envtbuilder.helpers;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.devsmart.android.ui.HorizontalListView;
import com.hubee.hh.launchertablet.envtbuilder.R;
import com.hubee.hh.launchertablet.model.Universe;


public class UniverseAdapter extends ArrayAdapter<Universe>{
	private final Context context;
	private final ArrayList<Universe> values;
	
	public UniverseAdapter(Context context, ArrayList<Universe> values) {
		super(context, R.layout.universe_row, values);
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.universe_row, parent, false);
		TextView universe_name = (TextView) rowView.findViewById(R.id.universe_name);
		HorizontalListView apps_list = (HorizontalListView) rowView.findViewById(R.id.apps_list);
		
		AppAdapter adapter = new AppAdapter(context, values.get(position).apps);
		apps_list.setAdapter(adapter);
		
		universe_name.setText(values.get(position).name);
		
		return rowView;
	}
	
	

}
