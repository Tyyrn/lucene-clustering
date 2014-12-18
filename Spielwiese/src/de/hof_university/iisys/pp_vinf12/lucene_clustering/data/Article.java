package de.hof_university.iisys.pp_vinf12.lucene_clustering.data;

import java.util.GregorianCalendar;

//@author ckoepf
//last modified: 12.12.2014

public class Article {
	
	//TODO Kommentar hinzuf�gen

	private String title;
	private String description;
	private String source;
	private String language;
	private String text;
	private String logo;
	private String link;
	private GregorianCalendar date;

	//Wird f�r XML-Parser ben�tigt!
	public Article(){
	}
	
	public Article(String title, String description, String source,
			String language, String text, String logo, String link,
			GregorianCalendar date) {
		super();
		this.title = title;
		this.description = description;
		this.source = source;
		this.language = language;
		this.text = text;
		this.logo = logo;
		this.link = link;
		this.date = date;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//Defaultwert f�r XML-Dateien die kein Logo haben, setzen
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	
}
