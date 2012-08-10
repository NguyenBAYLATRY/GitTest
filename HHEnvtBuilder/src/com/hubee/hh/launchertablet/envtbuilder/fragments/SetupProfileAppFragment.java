package com.hubee.hh.launchertablet.envtbuilder.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hubee.hh.launchertablet.envtbuilder.R;

public class SetupProfileAppFragment extends ListFragment {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		SetupProfileDetailFragment fragment = (SetupProfileDetailFragment) getFragmentManager()
				.findFragmentById(R.id.app_detail_fragment);
		if (fragment != null && fragment.isInLayout()) {
			fragment.setText(item);
		} 

	}
}