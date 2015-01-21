package de.hof_university.iisys.pp_vinf12.lucene_clustering.gui.data;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * 
 * Ein Cluster aus Artikeln wird angelegt.
 * Diese Klasse wird verwendet, wenn Articles ausgelesen werden.
 * Dabei werden Artikel gem�� ihrer �hnlichkeit in einen Cluster zusammengefasst.
 * 
 * @author CK�pf
 * @version 1.1
 * 
 */

public class Cluster {
	
	private UUID clusterId;
	/** Artikel, der den Cluster in der Pr�sentation vertritt */
	private Article topArticle;
	/** gesamte Liste der Artikel im Cluster */
	private List<Article> articles;
	/** Erstellzeitpunkt des Clusters */
	private GregorianCalendar created;
	/** Letzte �nderung des Clusters */
	private GregorianCalendar lastChange;
	//TODO entfernen!!
	// private String test = "testCluster";
	// eiskalt getan. irgendwelche unerw�nschten Ergebnisse?
	//TODO Variable Vektor-Space-Model?
	// TODO Konstruktor? Also bitte..
	
	
	public UUID getClusterId() {
		return clusterId;
	}
	
	public void setClusterId(UUID clusterId) {
		this.clusterId = clusterId;
	}
	
	public Article getTopArticle() {
		return topArticle;
	}
	
	public void setTopArticle(Article topArticle) {
		this.topArticle = topArticle;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public GregorianCalendar getCreated() {
		return created;
	}
	
	public void setCreated(GregorianCalendar created) {
		this.created = created;
	}
	
	public GregorianCalendar getLastChange() {
		return lastChange;
	}
	
	public void setLastChange(GregorianCalendar lastChange) {
		this.lastChange = lastChange;
	}	
}
