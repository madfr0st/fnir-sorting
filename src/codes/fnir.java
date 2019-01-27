package codes;

import java.io.*;
import java.util.Scanner;

public class fnir{

	// method for subtracting time

      public static int event(int A,int B,int a,int b){

          int ones = 0;
          int tens = 0;
          int sec = 0;

          if(B>=b){
            ones = B-b;
          }
          else{
            ones = B+60-b;
            A = A-1;
          }

          if(A>=a){
            tens = A-a;
          }
          else{
            tens = A+60-a;
          }

          sec = ones+60*tens;
          return sec;

      }

      // main method

      public static void main (String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of Subject");
        String subjectName = sc.nextLine();

        System.out.println("Enter no. of Data rows");
        int elements = sc.nextInt();
        elements = elements*38;



        // time of each event

        System.out.println("Enter StartTime in the format   MM SS");
        //int H0 = sc.nextInt();
        int M0 = sc.nextInt();
        int S0 = sc.nextInt();

        System.out.println("Enter Time of Mark1 in the format   MM SS");
      //  int H1 = sc.nextInt();
        int M1 = sc.nextInt();
        int S1 = sc.nextInt();

        System.out.println("Enter Time of Mark2 in the format   MM SS");
       // int H2 = sc.nextInt();
        int M2 = sc.nextInt();
        int S2 = sc.nextInt();

        System.out.println("Enter Time of Mark3 in the format   MM SS");
       // int H3 = sc.nextInt();
        int M3 = sc.nextInt();
        int S3 = sc.nextInt();

        System.out.println("Enter Time of Mark4 in the format   MM SS");
       // int H4 = sc.nextInt();
        int M4 = sc.nextInt();
        int S4 = sc.nextInt();

        System.out.println("Enter Time of Mark5 in the format  MM SS");
       // int H5 = sc.nextInt();
        int M5 = sc.nextInt();
        int S5 = sc.nextInt();



        // duration of each event
        // each sec have 10 samples

        int durationBaseline = 10*(event(M1,S1,M0,S0)-3);
        int durationTask1 = 10*(event(M2,S2,M1,S1)-2);
        int durationRest1 = 10*(event(M3,S3,M2,S2)-2);
        int durationTask2 = 10*(event(M4,S4,M3,S3)-2);
        int durationRest2 = 10*(event(M5,S5,M4,S4)-2);

        
        // array of allData including Time

         double[] data = new double[elements];

         System.out.println("Paste all the data including Time colomn till END");

         for(int i=0;i<elements;i++){

           data[i] = sc.nextDouble();

         }
         
         
         
         // making directory
         
         File file = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName);
         
         file.mkdir();
         
         File file1 = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task1");
         File file2 = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest1");
         File file3 = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task2");
         File file4 = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest2");
         
         file1.mkdir();
         file2.mkdir();
         file3.mkdir();
         file4.mkdir();
         
         for(int i=1;i<=16;i++) {
        	 
        	 File optode = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task1\\Optode"+i);
        	 optode.mkdir();
        	 
         }
         
         for(int i=1;i<=16;i++) {
        	 
        	 File optode = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest1\\Optode"+i);
        	 optode.mkdir();
        	 
         }
         
         for(int i=1;i<=16;i++) {
        	 
        	 File optode = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task2\\Optode"+i);
        	 optode.mkdir();
        	 
         }
         
         for(int i=1;i<=16;i++) {
        	 
        	 File optode = new File("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest2\\Optode"+i);
        	 optode.mkdir();
        	 
         }
         
         

         int count = 0;
         int colomn = 0;

         
         
         // Task1 Data oxy

         for(int i=1;i<=16;i++){

           
           colomn = 2*(i-1)+1;
           count = colomn+38*durationBaseline;
          
            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task1\\Optode"+i+"\\Optode"+i+"_T1_Oxy"+subjectName+".txt");

            for(int p=1;p<=durationTask1;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         

         // Task1 Data deoxy

         for(int i=1;i<=16;i++){

           
           colomn = 2*i;
           count = colomn+38*durationBaseline;
           

            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task1\\Optode"+i+"\\Optode"+i+"_T1_Deoxy"+subjectName+".txt");

            for(int p=1;p<=durationTask1;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         

         // Rest1 Data oxy

         for(int i=1;i<=16;i++){

           
           colomn = 2*(i-1)+1;
           count = colomn+38*(durationBaseline+durationTask1);
          
            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest1\\Optode"+i+"\\Optode"+i+"_R1_Oxy"+subjectName+".txt");

            for(int p=1;p<=durationRest1;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         

         // Rest1 Data deoxy

         for(int i=1;i<=16;i++){

           
           colomn = 2*i;
           count = colomn+38*(durationBaseline+durationTask1);


            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest1\\Optode"+i+"\\Optode"+i+"_R1_Deoxy"+subjectName+".txt");

            for(int p=1;p<=durationRest1;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         

         // Task2 Data oxy

         for(int i=1;i<=16;i++){

           
           colomn = 2*(i-1)+1;
           count = colomn+38*(durationBaseline+durationTask1+durationRest1);
          
            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task2\\Optode"+i+"\\Optode"+i+"_T2_Oxy"+subjectName+".txt");

            for(int p=1;p<=durationTask2;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }

         
         
         // Task2 Data deoxy

         for(int i=1;i<=16;i++){

          
           colomn = 2*i;
           count = colomn+38*(durationBaseline+durationTask1+durationRest1);

            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Task2\\Optode"+i+"\\Optode"+i+"_T2_Deoxy"+subjectName+".txt");

            for(int p=1;p<=durationTask2;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         

         // Rest2 Data oxy
         

         for(int i=1;i<=16;i++){

          
           colomn = 2*(i-1)+1;
           count = colomn+38*(durationBaseline+durationTask1+durationRest1+durationTask2);
           

            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest2\\Optode"+i+"\\Optode"+i+"_R2_Oxy"+subjectName+".txt");

            for(int p=1;p<=durationRest2;p++){
            	
              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         

         // Rest2 Data deoxy

         for(int i=1;i<=16;i++){

          
           colomn = 2*i;
           count = colomn+38*(durationBaseline+durationTask1+durationRest1+durationTask2);


            PrintWriter fileName = new PrintWriter("G:\\PROJECT files\\Refine Yoga People Data\\"+subjectName+"\\Rest2\\Optode"+i+"\\Optode"+i+"_R2_Deoxy"+subjectName+".txt");

            for(int p=1;p<=durationRest2;p++){

              fileName.println(data[count]);
              count = count+38;

            }

            fileName.close();

         }
         
         sc.close();
         System.out.println("Done!!!");
  }
}
