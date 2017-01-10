package com.html;

import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class TestJTidy {

	/**
	 * @param args
	 * @throws Exception 
	 */

    /**
     * JTidy�������ǽ�htmlתΪ�淶��xml�ĵ�
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(new File("F:\\IDEA\\Luence\\testHtml\\src\\com\\html\\out\\baidu.html"));
		InputStreamReader isr=new InputStreamReader(fis,"GBK");
		
        FileOutputStream fos=new FileOutputStream(new File("F:\\IDEA\\Luence\\testHtml\\src\\com\\html\\out\\baidu1.xml"));
        Tidy tidy=new Tidy();
        //ʹ��xml��ǩ�淶
        tidy.setXmlTags(true);

        tidy.setMakeClean(true);
        Document doc=tidy.parseDOM(isr, null);
        tidy.pprint(doc, fos);
        fos.close();
        fis.close();
        isr.close();
	}

}
