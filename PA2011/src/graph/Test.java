package graph;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Super sup = new Super();
		Sub sb = new Sub();
		// sup = sb;
		List<Super> lSup= new ArrayList<Super>();
		lSup.add(sb);
		String str = new String();
		Integer i = new Integer(1);
		
		Sub2 sb2 = new Sub2();
		Super s1 = (Super)sb2;
		sb2 = (Sub2)s1;
	}
}

class Super {

}

class Sub extends Super {

}

class Sub2 extends Super{
	
}

class Fuck<T extends Number>{
	
}