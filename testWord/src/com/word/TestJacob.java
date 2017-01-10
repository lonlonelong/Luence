//package com.word;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//
//public class TestJacob {
//
//
//	public static void extractDoc(String inputFIle, String outputFile) {
//		   boolean flag = false;
//
//		   // ��WordӦ�ó���
//		   ActiveXComponent app = new ActiveXComponent("Word.Application");
//		   try {
//		      // ����word���ɼ�
//		      app.setProperty("Visible", new Variant(false));
//		      // ��word�ļ�
//		      Dispatch doc1 = app.getProperty("Documents").toDispatch();
//		      Dispatch doc2 = Dispatch.invoke(
//		            doc1,
//		            "Open",
//		            Dispatch.Method,
//		            new Object[] { inputFIle, new Variant(false),
//		                  new Variant(true) }, new int[1]).toDispatch();
//		      // ��Ϊtxt��ʽ���浽��ʱ�ļ� Variant(7)
//		      // ��Ϊhtml��ʽ���浽��ʱ�ļ� Variant(8)
//		      Dispatch.invoke(doc2, "SaveAs", Dispatch.Method, new Object[] {
//		            outputFile, new Variant(8) }, new int[1]);
//		      // �ر�word
//		      Variant f = new Variant(false);
//		      Dispatch.call(doc2, "Close", f);
//		      flag = true;
//		   } catch (Exception e) {
//		      e.printStackTrace();
//		   } finally {
//		      app.invoke("Quit", new Variant[] {});
//		   }
//		   if (flag == true) {
//		      System.out.println("Transformed Successfully");
//		   } else {
//		      System.out.println("Transform Failed");
//		   }
//		}
//	public static void main(String[] args) {
//		extractDoc("d:/test.doc","d:/test.htm");
//
//	}
//
//}
