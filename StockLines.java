/* You are given a 2D integer array stockPrices where stockPrices[i] = [dayi, pricei] indicates the price of the 
stock on day dayi is pricei. A line chart is created from the array by plotting the points on an XY plane with the 
X-axis representing the day and the Y-axis representing the price and connecting adjacent points.
* Eg 1 : points = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]                   Output = 3
* Eg 2 : points = [[3,4],[1,2],[7,8],[2,3]]                                           Output = 1
*/
import java.util.*;
public class StockLines
{
      public int MinimumLines(int[][] Stockprices)
      {
            Arrays.sort(Stockprices, (a, b) -> Integer.compare(a[0], b[0]));    //! Sorting -> O(N log N)
            int slope[] = new int[Stockprices.length - 1];       //*  Greedy Array -> O(N)
            for(int i = 1; i < Stockprices.length; i++)     //! Storing -> O(N)
            {     // Finding slope of adjacent points...
                  int Slope = (Stockprices[i][1] - Stockprices[i - 1][1])/(Stockprices[i][0] - Stockprices[i - 1][0]);
                  slope[i - 1] = Slope;
            }
            int lines = 1;    // Atleast one line required...
            for(int i = 0; i < slope.length - 1; i++)     //! Comparison -> O(N)
            {
                  if(slope[i] != slope[i + 1])   // If slopes are different...
                        lines++;
            }
            return lines;     // Returning the minimum number of lines required...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter numebr of days of Stocks : ");
            x = sc.nextInt();
            int stcks[][] = new int[x][2];
            for(int i = 0; i < stcks.length; i++)
            {
                  System.out.print("Enter x coordinate : ");
                  stcks[i][0] = sc.nextInt();
                  System.out.print("Enter y coordinate : ");
                  stcks[i][1] = sc.nextInt();
            }
            StockLines stocklines = new StockLines();       // Object creation...
            System.out.println("The Minimum Lines required to plot : "+stocklines.MinimumLines(stcks));
            sc.close();
      }
}



//! Time Complexity -> O(N log N)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? Find slope of adjacent points.
 */