package de.kittybot.kittybot.objects;

public class TitleInfo{

	private final String title;
	private final String url;

	public TitleInfo(String title, String url){
		this.title = title;
		this.url = url;
	}

	public TitleInfo(String title){
		this.title = title;
		this.url = null;
	}

	public String getTitle(){
		return this.title;
	}

	public String getUrl(){
		return this.url;
	}

}
