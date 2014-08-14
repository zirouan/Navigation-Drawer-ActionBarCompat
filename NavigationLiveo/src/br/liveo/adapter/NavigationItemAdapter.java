package br.liveo.adapter;

public class NavigationItemAdapter {

	public String title;
	public int counter;
	public int icon;
	public boolean isHeader;	
	public boolean isVisible = true;
	public boolean checked = !isVisible;	

	public NavigationItemAdapter(String title, int icon, boolean header,int counter, boolean visible) {
		this.title = title;
		this.icon = icon;
		this.isHeader = header;
		this.counter = counter;
	}
	
	public NavigationItemAdapter(String title, int icon, boolean header){
		this(title, icon, header, 0, true );
	}
	
	public NavigationItemAdapter(String title, int icon) {
		this(title, icon, false);
	}
}
