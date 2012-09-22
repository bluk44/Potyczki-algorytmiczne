package tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sprawdzarka {

	public void check(Task task, File testDir) throws FileNotFoundException {
		HashMap<String, File> inputFiles = new HashMap<String, File>(), outputFiles = new HashMap<String, File>();
		ArrayList<String> testNames = new ArrayList<String>();

		if (testDir.isDirectory()) {
			File[] files = testDir.listFiles();
			for (File f : files) {
				String pathName = f.getPath();
				if (pathName.endsWith("in")) {
					int dot = pathName.indexOf(".");
					inputFiles.put(pathName.substring(0, dot), f);
					testNames.add(pathName.substring(0, dot));

				} else if (pathName.endsWith("out")) {
					int dot = pathName.indexOf(".");
					outputFiles.put(pathName.substring(0, dot), f);
				}
			}
		}
		String[] names = new String[testNames.size()];
		testNames.toArray(names);
		Arrays.sort(names);

		for (int i = 0; i < names.length; i++) {
			FileInputStream ansIn = new FileInputStream(names[i] + ".out");
			FileInputStream testIn = new FileInputStream(names[i] + ".out");
			println(names[i] + ": ");
			byte[] answer = readAnswer(ansIn);
			byte[] result = task.solve(testIn);

			String sAns = new String(answer);
			String sRes = new String(result);

			if (isCorrect(result, answer)) {
				System.out.println("OK: "+ sAns + "RESULT: "+ sRes);
			} else {
				println("FAIL: "+ sAns + sRes);
			}
		}
	}

	private byte[] readAnswer(InputStream in) {
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

	private boolean isCorrect(byte[] b1, byte[] b2) {
		if (b1.length != b2.length) {
			return false;
		} else {
			for (int i = 0; i < b2.length; i++) {
				if (b1[i] != b2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	private void println(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		Sprawdzarka spr = new Sprawdzarka();
		Chuj chuj = new Chuj();
		try {
			spr.check(chuj, new File("testy/PAL"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Chuj implements Task {

	@Override
	public byte[] solve(InputStream in) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte b = 0;
		try {
			while ((b = (byte) in.read()) != -1) {
				out.write(b);
			}
			return out.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return out.toByteArray();
	}

}
