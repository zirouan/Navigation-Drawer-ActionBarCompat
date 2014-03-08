package br.liveo.navigationliveo;

import android.content.Context;
import br.liveo.adapter.NavigationAdapter;
import br.liveo.adapter.NavigationItemAdapter;
import br.liveo.utils.Utils;

public class NavigationList {
	
	public static NavigationAdapter getNavigationAdapter(Context context){
		
		NavigationAdapter navigationAdapter = new NavigationAdapter(context);		
		String[] menuItems = context.getResources().getStringArray(R.array.nav_menu_items);		
		for (int i = 0; i < menuItems.length; i++) {

			String title = menuItems[i];				
			if (i == 0 || i == 6 || i == 10){ //Set category navigation position 0 = menu_zero, 
				                              //                                 6 = menu_six, 10 = menu_ten
				navigationAdapter.addHeader(title);			
			}else{
			
				NavigationItemAdapter itemNavigation;				
				switch (i) {
				case 1:
					itemNavigation = new NavigationItemAdapter(title, Utils.iconNavigation[i], false, 1);														
					break;
				default:
					itemNavigation = new NavigationItemAdapter(title, Utils.iconNavigation[i]);									
					break;
				}		
				navigationAdapter.addItem(itemNavigation);
			}
		}		
		return navigationAdapter;			
	}	
}
