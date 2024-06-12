import java.util.*;
public class FallingSand {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
     int[] oldArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int[][] newArray = new int[3][3];
int row = 0; int col = 0;
for (int index = 0; index < oldArray.length; index++)
{
newArray[row][col] = oldArray[index]; row++;
if ((row % 3) == 0)
{
col++;
row = 0;
}
}
System.out.println(newArray[0][2]);
        
        
    }
}