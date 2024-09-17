package pages;

import java.util.ArrayList;

public class IntegerCode {

	public static void main(String[] args) {
	

		
//				Create a list which can accept another list as an element.
//		        List 1- 11,22,33
//			    List 2-  9,19,29	
//			    List 3-  7,17,27
//			Hint - ArrayList<ArrayList<Integer>> l1=new ArrayList<>(); 	
				
				ArrayList<ArrayList<Integer>> l4=new ArrayList<>();
			
				ArrayList<Integer> l1=new ArrayList<>(); 	
				l1.add(11);
				l1.add(22);
				l1.add(33);
				ArrayList<Integer> l2=new ArrayList<>(); 	
				l2.add(9);
				l2.add(19);
				l2.add(29);
				ArrayList<Integer> l3=new ArrayList<>(); 
				l3.add(7);
				l3.add(17);
				l3.add(27);
				
				System.out.println(l1.addAll(l3));
				
				
			}

		


	}


