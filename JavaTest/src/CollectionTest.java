import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.omg.CORBA.portable.OutputStream;


public class CollectionTest {

	
	public static void main(String[] args) {
		ArrayList<String>list = new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.set(0, "ee");
		list.add("456");
		list.add("ggg");
		list.add("ggg");
		int l = list.size();
		
		for (String string : list) {
			System.out.print(string);
		}
		System.out.println("-------------");
		//set 
		HashSet<String> set = new HashSet<String>();
		set.addAll(list);
		for (String string : set) {
			System.out.print(string);
		}
		System.out.println("--------------");
		//map
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a1");
		map.put(2, "a2");
		map.put(3, "a3");
		map.put(4, "a4");
		map.put(4, "a5");
		//遍历
		boolean bo = map.containsValue("a5");
		System.out.println("bo = " + bo);
		for (Integer  key : map.keySet()) {
			System.out.println("key= "+key+" and value= "+map.get(key));
		}
		System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<Integer, String>>  it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, String> entry = it.next();
			System.out.print(entry.getValue());
		}
		CollectionTest ct = new CollectionTest();
		try {
			ct.testIOPutStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//流
	public void testIOPutStream() throws IOException{
		
	/*	InputStream in;
		Reader reader;
		OutputStream out;
		Writer writer;*/
		
		FileReader reader = null;
		FileWriter writer = null;
		char[] temm = new char[512];
		
		try {
			reader = new FileReader("D:\\gg.txt");
			writer = new FileWriter("D:\\gg1.txt");
			while  (reader.read(temm)!= -1) {
				writer.write(temm);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader.close();
		writer.close();
		
	
	}
}
