package br.liveo.adapter;

import java.util.HashSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import br.liveo.navigationliveo.NavigationMain;
import br.liveo.navigationliveo.R;

public class NavigationAdapter extends ArrayAdapter<NavigationItemAdapter> {

	private ViewHolder holder;	
	private HashSet<Integer> checkedItems;
	public NavigationAdapter(Context context) {
		super(context, 0);
		this.checkedItems = new HashSet<Integer>();		
	}

	public void addHeader(String title) {
		add(new NavigationItemAdapter(title, 0, true));
	}

	public void addItem(String title, int icon) {
		add(new NavigationItemAdapter(title, icon, false));
	}

	public void addItem(NavigationItemAdapter itemModel) {
		add(itemModel);
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		return getItem(position).isHeader ? 0 : 1;
	}

	@Override
	public boolean isEnabled(int position) {
		return !getItem(position).isHeader;
	}

	public void setChecked(int pos, boolean checked)
    {
        if (checked) {
            this.checkedItems.add(Integer.valueOf(pos));
        } else {
            this.checkedItems.remove(Integer.valueOf(pos));
        }    
        
        this.notifyDataSetChanged();        
    }

	public void resetarCheck()
    {
        this.checkedItems.clear();
        this.notifyDataSetChanged();
    }	
	
	public static class ViewHolder {
		public final ImageView icon;		
		public final TextView title;
		public final TextView counter;		
		public final LinearLayout colorLinear;
		public final View viewNavigation;

		public ViewHolder(TextView title, TextView counter, ImageView icon, LinearLayout colorLinear, View viewNavigation) {
			this.title = title;
			this.counter = counter;
			this.icon = icon;			
			this.colorLinear = colorLinear;
			this.viewNavigation = viewNavigation;
		}
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		holder = null;		
		View view = convertView;
		NavigationItemAdapter item = getItem(position);
		
		if (view == null) {

			int layout = 0;
			layout = R.layout.navigation_item_counter;			
			if (item.isHeader){
				layout = R.layout.navigation_header_title;
			}

			view = LayoutInflater.from(getContext()).inflate(layout, null);

			TextView txttitle = (TextView) view.findViewById(R.id.title);
			TextView txtcounter = (TextView) view.findViewById(R.id.counter);
			ImageView imgIcon = (ImageView) view.findViewById(R.id.icon);
			View viewNavigation = (View) view.findViewById(R.id.viewNavigation);
			
			LinearLayout linearColor = (LinearLayout) view.findViewById(R.id.ns_menu_row);
			view.setTag(new ViewHolder(txttitle, txtcounter, imgIcon, linearColor, viewNavigation));
		}
		
		if (holder == null && view != null) {
			Object tag = view.getTag();
			if (tag instanceof ViewHolder) {
				holder = (ViewHolder) tag;
			}
		}
				
		if (item != null && holder != null) {
			if (holder.title != null)
				holder.title.setText(item.title);

			if (holder.counter != null) {
				if (item.counter > 0) {
					holder.counter.setVisibility(View.VISIBLE);
					
					int counter = ((NavigationMain)getContext()).getCounterItemDownloads();
					holder.counter.setText("" + counter);
				} else {
					holder.counter.setVisibility(View.GONE);
				}
			}

			if (holder.icon != null) {
				if (item.icon != 0) {
					holder.icon.setVisibility(View.VISIBLE);
					holder.icon.setImageResource(item.icon);
				} else {
					holder.icon.setVisibility(View.GONE);
				}
			}
		}
	    
		if (!item.isHeader) {
			if (checkedItems.contains(Integer.valueOf(position))) {
				holder.viewNavigation.setVisibility(View.VISIBLE);
			} else {				
				holder.viewNavigation.setVisibility(View.GONE);				
			}
			view.setBackgroundResource(R.drawable.seletor_item_navigation);			
		}
		
	    return view;		
	}

}
