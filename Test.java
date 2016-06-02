/*
Sri Mounika Puvvada
Advanced Programming Languages
Test.java
project 4
*/
import java.io.*;
import java.lang.*;
import javax.swing.JFileChooser;
import java.io.File; 
import javax.swing.JFrame;

class Test{
    public static void main(String args[]){
      String fileName = "";
      String line = null;
        try {
               JFileChooser chooser = new JFileChooser();
               int returnVal = chooser.showOpenDialog(new JFrame());
               if(returnVal == JFileChooser.APPROVE_OPTION) {
                 fileName = chooser.getSelectedFile().getName();
               }
               FileReader fileReader =new FileReader(fileName);
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               while(!(line = bufferedReader.readLine()).contains("~")) {
               }   
               int index=0;
               int noOfOperands = Integer.parseInt(bufferedReader.readLine());
               int operand[]= new int[noOfOperands];
               while(noOfOperands !=0)
               {
                     operand[index++] = Integer.parseInt(bufferedReader.readLine());
                     noOfOperands--;               
               }
               int noOfFunctions = Integer.parseInt(bufferedReader.readLine());
               FuncMetaData[] func_metadata=new FuncMetaData[noOfFunctions];
               index=0;
                while(noOfFunctions> 0){
                  func_metadata[index] = new FuncMetaData(bufferedReader.readLine(),Integer.parseInt(bufferedReader.readLine()),Integer.parseInt(bufferedReader.readLine()),Integer.parseInt(bufferedReader.readLine()));
                  noOfFunctions--;
                  index++;
               }
               int noOfLiterals = Integer.parseInt(bufferedReader.readLine());
               index=0;
               String[] Literals = new String[noOfLiterals];
               while(noOfLiterals > 0){
                  Literals[index] = bufferedReader.readLine();
                  index++;
                  noOfLiterals--;
               }
               VM vm=new VM(operand,0,func_metadata,Literals);
               vm.trace = false;
               vm.exec(func_metadata[0].address);
               System.out.println("Completed gcd");
               bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
   }
}
