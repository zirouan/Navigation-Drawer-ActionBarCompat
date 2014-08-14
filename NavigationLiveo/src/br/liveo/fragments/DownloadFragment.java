package br.liveo.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import br.liveo.navigationliveo.R;
import br.liveo.utils.Constant;
import br.liveo.utils.Menus;

public class DownloadFragment extends Fragment {

	private boolean mSearchCheck;
	private TextView mTxtDownload;
	
	public DownloadFragment newInstance(String text){
		DownloadFragment mFragment = new DownloadFragment();		
		Bundle mBundle = new Bundle();
		mBundle.putString(Constant.TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View rootView = inflater.inflate(R.layout.download_fragment, container, false);
		
		mTxtDownload = (TextView) rootView.findViewById(R.id.txtDownload);
		mTxtDownload.setText(getArguments().getString(Constant.TEXT_FRAGMENT));
		
		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));		
		return rootView;		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);		
		inflater.inflate(R.menu.menu, menu);
		 	    
		SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(Menus.SEARCH));
	    searchView.setQueryHint(this.getString(R.string.search));
	    
	    ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text))
        .setHintTextColor(getResources().getColor(R.color.white));	    
	    searchView.setOnQueryTextListener(OnQuerySearchView);
					    	   	    
		menu.findItem(Menus.ADD).setVisible(true);
		menu.findItem(Menus.UPDATE).setVisible(true);		
		menu.findItem(Menus.SEARCH).setVisible(true);		
  	    
		mSearchCheck = false;	
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {

		case Menus.ADD:	    	
			break;				
		
		case Menus.UPDATE:	    	
			break;				
			
		case Menus.SEARCH:
			mSearchCheck = true;
			break;
		}		
		return true;
	}	
	
	private OnQueryTextListener OnQuerySearchView = new OnQueryTextListener() {
		
		@Override
		public boolean onQueryTextSubmit(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean onQueryTextChange(String arg0) {
			// TODO Auto-generated method stub
			if (mSearchCheck){
				// implement your search here
			}
			return false;
		}
	};					
}
