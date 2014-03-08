package br.liveo.utils;

import android.content.Context;
import br.liveo.navigationliveo.R;

public class Utils {

	//Set all the navigation icons and always to set "zero 0" for the item is a category
	public static int[] iconNavigation = new int[] { 
		0, R.drawable.ic_action_download, R.drawable.ic_action_divisao, R.drawable.ic_action_delete,
		R.drawable.ic_action_update, R.drawable.ic_action_done, 0, R.drawable.ic_action_settings, 
		R.drawable.ic_action_add, R.drawable.ic_action_discard, 0, R.drawable.ic_action_map, R.drawable.ic_action_share};	
	
	//get title of the item navigation
	public static String getTitleItem(Context context, int posicao){		
		String[] titulos = context.getResources().getStringArray(R.array.nav_menu_items);  
		return titulos[posicao];
	} 
	
}
