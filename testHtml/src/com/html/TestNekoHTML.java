package com.html;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestNekoHTML {

    public static String textExtractor(Node root) {
        //�����ı��ڵ�Ļ���ֱ�ӷ���
        if (root.getNodeType() == Node.TEXT_NODE) {
            return root.getNodeValue().trim();
        }
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            Element elmt = (Element) root;
            //�����ű�
            if (elmt.getTagName().equals("STYLE") || elmt.getTagName().equals("SCRIPT") || elmt.getTagName().equals("BR"))
                return "";

            NodeList children = elmt.getChildNodes();
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < children.getLength(); i++) {
                text.append(textExtractor(children.item(i)));
            }
            return text.toString();
        }
        //���������͵Ľڵ㣬���ؿ�ֵ
        return "";
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        DOMParser parser = new DOMParser();
        BufferedReader reader = new BufferedReader(new FileReader("F:\\IDEA\\Luence\\testHtml\\src\\com\\html\\out\\baidu.html"));
        parser.parse(new InputSource(reader));
        Document doc = parser.getDocument();
        Node body = doc.getElementsByTagName("body").item(0);
        String str = textExtractor(body);
        System.out.println(str);

    }

}
