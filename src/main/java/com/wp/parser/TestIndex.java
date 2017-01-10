package com.wp.parser;

import net.paoding.analysis.analyzer.PaodingAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;

public class TestIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String [] ids={"1","2","3","4"};
		String [] names={"����","����","zhangsan ","zhangsun"};
		String [] addresses={"��ס�ڱ���","��ס���Ͼ�","��������","nanning"};
		String [] birthdays={"19820720","19840203","19770409","19830130"};
		Analyzer analyzer=new PaodingAnalyzer();
		String indexDir="F:\\IDEA\\Luence\\src\\main\\java\\com\\wp\\parser\\index";
		Directory dir=FSDirectory.getDirectory(indexDir);

		//true ��ʾ�����򸲸ǵ�ǰ������false��ʾ�Ե�ǰ��������׷��
		//Default value is 128
		IndexWriter writer=new IndexWriter(dir,analyzer,true,IndexWriter.MaxFieldLength.LIMITED);

		for(int i=0;i<ids.length;i++){
			Document document=new Document();
			document.add(new Field("id",ids[i],Field.Store.YES,Field.Index.ANALYZED));
			document.add(new Field("name",names[i],Field.Store.YES,Field.Index.ANALYZED));
			document.add(new Field("address",addresses[i],Field.Store.YES,Field.Index.ANALYZED));
			document.add(new Field("birthday",birthdays[i],Field.Store.YES,Field.Index.ANALYZED));
			writer.addDocument(document);
		}

		writer.optimize();

		writer.close();
		System.out.println("ok");
	}

}
