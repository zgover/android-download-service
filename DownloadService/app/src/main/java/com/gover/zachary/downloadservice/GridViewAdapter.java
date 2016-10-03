// Zachary Gover
// MDF3 - 1610
// GridViewAdapter

package com.gover.zachary.downloadservice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.loopj.android.image.SmartImageView;

public class GridViewAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private ListImgItem viewHolder;

	public GridViewAdapter(Context applicationContext) {
		this.context = applicationContext;
	}

	@Override
	public int getCount() {
		return IMAGES.length;
	}

	@Override
	public Object getItem(int i) {
		return IMAGES[i];
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			// inflate the layout
			inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(R.layout.grid_view_item, null);

			// Setup view holder if the current view is null
			this.viewHolder = new ListImgItem();
			this.viewHolder.image = (SmartImageView) convertView.findViewById(R.id.imageView);
			convertView.setTag(this.viewHolder);

		} else {
			// Set the current view holder if we are not null
			this.viewHolder = (ListImgItem) convertView.getTag();
		}

		// Set the values for each view holder item
		String image = URL_BASE.concat(IMAGES[position]);

		// Return if that index is null
		if (image == null) { return convertView; }

		this.viewHolder.image.setImageUrl(image);

		return convertView;
	}

	// View Holder
	static class ListImgItem {
		SmartImageView image;
	}

}
