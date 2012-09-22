package tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Sprawdzarka {
	
	public void check(Task task, File testDir) throws FileNotFoundException{
		//HashMap<String, File> inputFiles = new HashMap<String, File>(), outputFiles = new HashMap<String, File>();
		FileInputStream ansIn = new FileInputStream("testy/PAL/test0.out");
		FileInputStream testIn = new FileInputStream("testy/PAL/test0.in");
		byte[] answer = readAnswer(ansIn);
		byte[] result = task.solve(testIn);
		
		String sAns = new String(answer);
		String sRes = new String(result);
		
		if(isCorrect(result, answer)){
			println("OK: "+sAns+" ["+sRes+"]");
		} else{
			println("FAIL: "+sAns+" ["+sRes+"]");
		}
		
	}
	
	private byte[] readAnswer(InputStream in){
		ByteArrayOutputStream ansOut = new ByteArrayOutputStream();
		byte b = 0;
		try {
			while ((b = (byte) in.read()) != -1) {
				ansOut.write(b);
			}
			return ansOut.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean isCorrect(byte[] b1, byte[] b2){
		if(b1.length != b2.length){
			return false;
		}
		else{
			for(int i=0;i<b2.length;i++){
				if(b1[i] != b2[i]){
					return false;
				}
			}
		}
		return true;
	}
	
	private void println(String s){
		System.out.println(s);
	}
	
	public static void main(String[] args){

 	}
}
