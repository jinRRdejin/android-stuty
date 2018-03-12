import java.awt.TextArea;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;


public class IOFileTest {
	
	
	

	public static void main(String[] args) {
		FileInputStream in;
		FileOutputStream out;
		FileReader fr;
		FileWriter fw;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		
		
		
		try {
			File file = new File("D:\\gg.txt");
			out = new FileOutputStream(file);
			byte[] bytes = "Œ“∞ÆJava".getBytes();
			out.write(bytes);	
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file2 = new File("F:\\demo");
		TextArea textArea = new TextArea();
		if(file2.isFile()){
			file2.delete();
			textArea.append(file2.getAbsolutePath() + "\n\r");
		}else{
			File[] files = file2.listFiles();
			
			for (File file : files) {
				System.out.println(file);
				System.out.println(file.isFile());
				if(file.isFile()){
					
					file.delete();
					
				}else{
					System.out.println("----------");
				}
				
			}
			file2.delete();
		}
		
	}

}
