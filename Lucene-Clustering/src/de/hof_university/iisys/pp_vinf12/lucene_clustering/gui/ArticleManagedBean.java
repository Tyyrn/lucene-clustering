package de.hof_university.iisys.pp_vinf12.lucene_clustering.gui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import de.hof_university.iisys.pp_vinf12.lucene_clustering.gui.data.Cluster;
import de.hof_university.iisys.pp_vinf12.lucene_clustering.gui.lucene.BeanData;
import de.hof_university.iisys.pp_vinf12.lucene_clustering.gui.lucene.BeanDataImpl;

@RequestScoped
@ManagedBean(name="amb")
public class ArticleManagedBean {
	private List<Cluster> clusterList = new ArrayList<Cluster>();
	private String searchString;
	private int first;
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	private BeanData data = new BeanDataImpl();

	public List<Cluster> getClusterList() {
		return clusterList;
	}
	
	public void setClusterList(List<Cluster> clusterList) {
		this.clusterList = clusterList;
	}
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	//Wenn auf der Search-Seite Enter gedr�ckt wird
	public void searchStringChanged(ValueChangeEvent vce)
	{
		this.searchString = (String)vce.getNewValue();
		search(searchString);
	}
	
	//Wenn der Suche-Button bet�tigt wird
	public void searchButtonUsed()
	{
		search(searchString);
	}
	
	private void search(String searchString){
	    setClusterList(data.getClusterList(searchString));
	}
	
	public String weiter() {
	    first = first + 1;
	    if (first > clusterList.size()) {
	        first = clusterList.size() - 1;
	    }
	    return null;
	}
	 
	public String zurueck() {
	    first = first - 1;
	    if (first <= 0) {
	        first = 1;
	    }
	     
	    return null;
	}
	
	public ArticleManagedBean(){
    }
	
	//Initialisierung index.xhtml
    public void onPageLoadIndex() {
    	setClusterList(data.getClusterList());
     }
    
	//Initialisierung equalArticles.xhtml
    public void onPageLoadEqualArticles() {
    	setClusterList(data.getEqualClusterList());
     }
}