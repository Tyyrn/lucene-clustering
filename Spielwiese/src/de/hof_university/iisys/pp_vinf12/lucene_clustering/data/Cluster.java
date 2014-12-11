package de.hof_university.iisys.pp_vinf12.lucene_clustering.data;

import java.util.GregorianCalendar;
import java.util.List;

//@author ckoepf
//change 06.11.2014

public class Cluster implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5126206769651649559L;
	private Article topArticle;
	private List<Article> articles;
	private GregorianCalendar created;
	private GregorianCalendar lastChange;
	//TODO entfernen!!
	private String test = "testCluster";
	//TODO Variable Vektor-Space-Model?
	
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
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	
}
