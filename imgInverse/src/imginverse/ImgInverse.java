/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imginverse;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author JERDY
 */
public class ImgInverse {

    /**
     * @param args the command line arguments
     */
    public static String filePath;
    public static void main(String[] args){
        // TODO code application logic here
        
        //1. create new file
        //2. copy header to a new file
        //3. extract width & length
        //4. loop & negate the values
        //5. close the new file
        
        try{
            filePath = "Steve-Jobsl.pgm";
            FileInputStream filein = new FileInputStream(filePath);
            DataInputStream datain = new DataInputStream(filein);
            FileOutputStream fileout = new FileOutputStream("output.pgm");
       
            int height = 590;
            int width = 590;
            int[][] data2D = new int [width] [height];
            
            for(int x = 0; x < 37; x++){
                fileout.write(datain.readUnsignedByte());
            }
            
            for(int row=0; row<height; row++){
                for(int col = 0; col<width; col++){
                    data2D[row][col] = (datain.readUnsignedByte() - 255) * -1;
                    fileout.write(data2D[row][col]);
                
                    System.out.println(data2D[row][col] + " ");
                }
                System.out.println();
            }
            fileout.close();
            filein.close();
            datain.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImgInverse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImgInverse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
