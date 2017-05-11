package com.bhacking;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SquareRetangleOthers {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int square = 0;
		int retangles = 0;
		int other = 0;
		
		while (scan.hasNextLine()){
			String spaceObject = scan.nextLine();
			
			if(spaceObject.equals("end"))
				break;
			
			StringTokenizer tokenizer = new StringTokenizer(spaceObject, " ");
			
			int ladoA = new Integer(tokenizer.nextToken());
			int ladoB = new Integer(tokenizer.nextToken());
			int ladoC = new Integer(tokenizer.nextToken());
			int ladoD = new Integer(tokenizer.nextToken());
			
			if( ladoA <= 0 || ladoB <= 0 ||  ladoC <= 0 ||  ladoD <= 0 ){
				other = other + 1;
			
			}else if (ladoA == ladoB && ladoB == ladoC && ladoC == ladoD) {
				square = square + 1;
			
			}else if(ladoA == ladoC && ladoB == ladoD){
				retangles = retangles + 1;
			
			}else{
				other = other + 1;
			}
			
		}
		
		System.out.println(square + " " + retangles + " " + other);
		
	}
	

	
	
	
	

}
