/**
 * Jeremiah Dixon
 * Nov 11th, 2018
 * This is a basic I/O App I wrote that just simply reads in a file and
 * then outputs a copy of the file
 */
import java.io.*;
import java.lang.management.*;
public class IOApp
{
   //Method for reading from a file and writting to a new file
   public static void readAndWritefile() throws IOException {
    //this is the file you are reading in to copy, the file path needs to be changed to where
    //you have it on your computer
    File file = new File("/Users/jeremiahdixon/Desktop/Jeremiah_Dixon_4715_p2/Test1 - large 100KB.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    File UIFile = new File("/Users/jeremiahdixon/Desktop/Jeremiah_Dixon_4715_p2/TestCopy.txt");
    // if File doesnt exists, then create it
    if (!UIFile.exists()) {
       UIFile.createNewFile();
    }
    FileWriter filewriter = new FileWriter(UIFile.getAbsoluteFile());
    BufferedWriter os = new BufferedWriter(filewriter);
    String count;
    while ((count = br.readLine()) != null) {
        os.write(count);
    }
    //Close the output stream and input stream (buffer reader)
    os.flush();
    os.close();
    br.close();
   }
   
   //ALL OF THE FOLLOWING CODE FOR RECORDING CPU, USER, AND SYSTEM TIME I LEARNED BASED FROM -
   //http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking
   
   /** Get CPU time in nanoseconds. */
   public static long getCpuTime( ) {
     ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
     return bean.isCurrentThreadCpuTimeSupported( ) ?
        bean.getCurrentThreadCpuTime( ) : 0L;
    }
   
   //Learned and based from - 
   //http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking
   /** Get user time in nanoseconds. */
   public static long getUserTime( ) {
     ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
     return bean.isCurrentThreadCpuTimeSupported( ) ?
        bean.getCurrentThreadUserTime( ) : 0L;
    }

   //Learned and based from - 
   //http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking
   /** Get system time in nanoseconds. */
   public static long getSystemTime( ) {
     ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
     return bean.isCurrentThreadCpuTimeSupported( ) ?
        (bean.getCurrentThreadCpuTime( ) - bean.getCurrentThreadUserTime( )) : 0L;
    }
   
   //collects and prints the CPU, system, and user time
   public static void printTimes(){
       System.out.print("CPU Time: " + getCpuTime() + " Nanoseconds\nUser Time: " 
       + getUserTime() + " Nanoseconds\nSystem Time: " + getSystemTime() + " Nanoseconds\n");
    }
        
}
