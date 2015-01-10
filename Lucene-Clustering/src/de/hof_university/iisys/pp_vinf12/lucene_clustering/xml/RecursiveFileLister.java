package de.hof_university.iisys.pp_vinf12.lucene_clustering.xml;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileLister {
	
	List<String> fileList = new ArrayList<String>();
	File[] path; // Oberster Ordner �ber den iteriert wird
	
	public RecursiveFileLister(String path){
		this.path = new File(path).listFiles();
		listFiles(this.path);
	}
	
	public List<String> getFileList() {
		return fileList;
	}

	public void listFiles(){
		listFiles(path);
	}
	
	//Speichert alle Dateien aller Unterordner in der Liste fileList
	private void listFiles(File[] files) {
		System.out.println("listFiles");
	    for (File file : files) {
	        if (file.isDirectory()) {
	            listFiles(file.listFiles()); 
	        } else {
	            fileList.add(file.getAbsolutePath());
	        }
	    }
	}
	
}
