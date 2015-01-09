package de.hof_university.iisys.pp_vinf12.lucene_clustering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.SlowCompositeReaderWrapper;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefIterator;
import org.apache.lucene.util.Version;

import de.hof_university.iisys.pp_vinf12.lucene_clustering.data.Article;
import de.hof_university.iisys.pp_vinf12.lucene_clustering.lucene.ArticleIndexer;
import de.hof_university.iisys.pp_vinf12.lucene_clustering.xml.FileIterator;
import de.hof_university.iisys.pp_vinf12.lucene_clustering.xml.XMLParser;

public class Test {
	
	public static void main(String[] args) throws IOException, ParseException {
		FileIterator it = new FileIterator("testfiles");
		XMLParser parser = new XMLParser();
		ArticleIndexer indexer = new ArticleIndexer("lucene.index");
		
		List<Article> articles = new ArrayList<Article>();
		List<String> files = it.getFileList();
		
		System.out.println("Files: " + files.size());
		
		for(String file : files) {
			Article article = parser.parse(file);
			articles.add(article);		
		}
		
		try {
			indexer.writeArticlesToIndex(articles);
		} catch (IOException e) {
			System.err.println("Indexen fehlgeschlagen \n �h jetzt fertig\n");
			System.err.println(e.getMessage());		
		}
		
		SimpleFSDirectory dir = new SimpleFSDirectory(new File("lucene.index"));
		DirectoryReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
		QueryParser queryParser = new QueryParser(Version.LUCENE_45, "title", analyzer);
		
		Query query = queryParser.parse("a");
		TopDocs td = searcher.search(query, 10);
		ScoreDoc[] sd = td.scoreDocs;
		for (int j = 0; j < sd.length; ++j) {
			Document doc = searcher.doc(sd[j].doc);
			System.out.println(doc.get("source") + " // " + doc.get("title") + " // " + doc.get("date"));
		}
		
	}

}
