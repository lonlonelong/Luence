package pdf;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.pdfbox.searchengine.lucene.LucenePDFDocument;

import java.io.File;
import java.io.IOException;

/**
 * Created by ��Ƽ on 2017/1/10 0010.
 */
public class TestLucenePDFDocument {

    public static void main(String[] args) throws IOException {

        String indexDir = "F:\\IDEA\\Luence\\testPdfbox\\src\\pdf\\index";

//        δ���Ҷ��ִ�����lucenePdf��������
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriter writer = new IndexWriter(indexDir,analyzer,true);
        Document document = LucenePDFDocument.getDocument(new File("C:/Users/wang0/Desktop/��Ƽ.pdf"));
        writer.addDocument(document);
        writer.close();
    }
}
