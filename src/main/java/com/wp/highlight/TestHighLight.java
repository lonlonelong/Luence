package com.wp.highlight;


	import net.paoding.analysis.analyzer.PaodingAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

import java.io.StringReader;

	public class TestHighLight {
		

		public static void main(String[] args) throws Exception{
			
			Searcher searcher = new IndexSearcher("F:\\IDEA\\Luence\\src\\main\\java\\com\\wp\\data\\index");

			PaodingAnalyzer analyzer=new PaodingAnalyzer();
			String field = "contents";
			String queryStr = "����";
			
			 QueryParser parser = new QueryParser(field, analyzer);
			 Query query = parser.parse(queryStr);
		        
			 TopDocCollector  collector = new TopDocCollector(10);
	        
			 searcher.search(query,collector);
			 ScoreDoc[] hits =collector.topDocs().scoreDocs;
			 
			 //������ʾ����
			 Highlighter highlighter = null;
					
			 SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<font color='blue'>","</font>");  

			 
			 highlighter = new Highlighter(simpleHTMLFormatter,new QueryScorer(query)); 
			 highlighter.setTextFragmenter(new SimpleFragmenter(200));//���200��ָ���ؼ����ַ�����context
	                                     //�ĳ��ȣ�������Լ��趨����Ϊ�����ܷ�����ƪ��������
			 Document doc;
			 for(int i=0;i<hits.length;i++){
				 
				 System.out.println(hits[i].doc);
				 System.out.println(hits[i].score);
				//��ӡ�ĵ�������
				 doc = searcher.doc(hits[i].doc);
//				 System.out.println(doc.toString());

					 
				//��������ʾ
				 
				 TokenStream tokenStream =new PaodingAnalyzer().tokenStream("contents", new StringReader(doc.get("contents")));
				 System.out.println(highlighter.getBestFragment(tokenStream,doc.get("contents")));
				 System.out.println("--------------------");
				 
			 }

				 
	 

			

	        
		}
		
		

	}
