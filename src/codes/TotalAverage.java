package codes;

import java.io.*;
import java.util.Scanner;

public class TotalAverage {

	public static void main(String[] args) throws Exception{
		
		
		Scanner cmd = new Scanner(System.in);
		
		System.out.println("Enter no. of subjects");
		int subjectNumber = cmd.nextInt();
		
		System.out.println("Enter names of subjectName correctly");
		String[] subjectName = new String[subjectNumber];
		
		for(int p=0;p<subjectNumber;p++) {
			
			subjectName[p] = cmd.next();
			
		}
		
		
		
		System.out.println("Enter subjects folder location");
	    String name = cmd.nextLine();
	     name = cmd.nextLine();
	    cmd.close();
	    
	    String[] event = {"Task1","Rest1","Task2","Rest2"};
	    String[] E = {"T1","R1","T2","R2"};
	    String[] oxy = {"Oxy","Deoxy"};
	    
	   
	    int count = 0;
	    Double avg = 0.0;
	    Double totalAverage = 0.0;
	    
	    File average = new File("G:\\PROJECT files\\Refine  Data\\average data\\"+"totalAverage.txt");
	    
	    PrintWriter fileWriter = new PrintWriter(average);
	    
	    
	    
	    
	    
	    for(int p=0;p<4;p++) {
	    	
	    	fileWriter.print(event[p]+" ");
	    	fileWriter.print("Oxy"+" ");
			fileWriter.println("Deoxy");
	    	
	  
	    	for(int i=1;i<=16;i++) {
	    		
	    		fileWriter.print("Optode"+i+" ");
	
	    		for(int r=0;r<2;r++) {
	    			
	    			totalAverage = 0.0;
	    			
	    			for(int q=0;q<subjectNumber;q++) {
	    				
	    				
	    				
	    				avg = 0.0;
		    			count = 0;
		    			
		    			String address = name;
		    	
		    			address = name+"\\"+subjectName[q] + "\\"+event[p]+"\\Optode"+i+"\\Optode"+i+"_"+E[p]+"_"+oxy[r]+subjectName[q]+".txt";
			    		
			    		File file = new File(address);

			    		Scanner sc = new Scanner(file);
			    		
			    		
			    		while(sc.hasNextDouble()){
			    			
			    			count = count+1;
			    			avg = avg + sc.nextDouble();
			    			
			    		}
			    		
			    		sc.close();
			    		
			    		avg = avg/count;
			    		
			    		totalAverage = totalAverage + avg;
			    		
	    			}
			    		
	    			totalAverage = totalAverage/subjectNumber;
	    						
	    			
	    			
	    		
	    					
	    					if(r == 0) {
				    			
				    			fileWriter.print(totalAverage+" ");
				    			
				    		}
				    		else {
				    			
				    			fileWriter.println(totalAverage);
				    		}
	  		
	    		}
	    	}
	    	
	    }
	    
	    fileWriter.close();
	    System.out.println("Done!!!");


	  }

	}


