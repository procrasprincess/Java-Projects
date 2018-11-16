import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args){
    Random r = new Random(System.currentTimeMillis());
    
   
    int n = r.nextInt(101) + 50;
    int[] a = new int[n];
    for(int i = 0; i < n; i++)
      a[i] = r.nextInt(100);
    
    n = r.nextInt(101) + 50;
    int[] b = new int[n];
    for(int i = 0; i < n; i++)
     b[i] = r.nextInt(100);
    
  
    SortThread t1 = new SortThread(a);  //It is not a thread yet
   SortThread t2 = new SortThread(b);  //It is not a thread yet
   t1.start();
   t2.start();
    
   MergeThread m = new MergeThread(t1.get(),t2.get());//It is not a thread yet
   m.start();
   
    System.out.println(Arrays.toString(t1.get()));
  }
}

