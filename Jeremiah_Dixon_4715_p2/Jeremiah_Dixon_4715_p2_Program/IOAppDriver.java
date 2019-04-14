/**
 * Jeremiah Dixon
 * Nov 11th, 2018
 * This is a basic I/O App I wrote that just simply reads in a file and
 * then outputs a copy of the file
 */

import java.io.*;
public class IOAppDriver
{
    public static void main(String[] args)throws IOException{
      IOApp ioapp = new IOApp();
      IOApp.readAndWritefile();
      IOApp.printTimes();
    }
}
