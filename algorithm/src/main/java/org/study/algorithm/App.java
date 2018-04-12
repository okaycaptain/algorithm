package org.study.algorithm;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		List<A> list = new ArrayList<>();
    		A aa = new A();
    		aa.setName("a");
    		
    		A bb = new A();
    		bb.setName("b");
    		list.add(aa);
    		list.add(bb);
    		
    		Map<String,Long> map = new HashMap<>();
    		map.put("a", 1000L);
    		for(A obj: list) {
    			obj.setCount(map.get(obj.getName()));
    		}
    		
        System.out.println( "Hello World!" );
    }
}
