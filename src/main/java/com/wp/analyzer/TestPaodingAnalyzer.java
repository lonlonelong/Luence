package com.wp.analyzer;

import net.paoding.analysis.analyzer.PaodingAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import java.io.IOException;
import java.io.StringReader;

public class TestPaodingAnalyzer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Analyzer analyzer=new PaodingAnalyzer();
		String input="�ô���Դ������ά���ձ����Ŵ򿪺�,�������,����Ϊ�������й����⽭��һ���ĺ����Ļ������ݱ������,�����ձ����Ǻ�������Ҳ�кͷ�";
		TokenStream ts = analyzer.tokenStream("", new StringReader(input));
		Token token=new Token();
		while((token=ts.next(null))!=null){
			System.out.println(token.term());
		}

	}

}
