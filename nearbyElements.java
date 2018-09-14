import java.util.Arrays;

public class nearbyElements {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nearby(0, 2, 2)));
    System.out.println(Arrays.toString(nearby(1, 0, 1)));
    System.out.println(Arrays.toString(nearby(1, 3, 5)));
    System.out.println(Arrays.toString(nearby(0, 8, 10)));
  };

  private static int[][] multi = new int[][]{
    { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
    { 1, 3, 5, 7 },
    { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
  };

  public static int[] nearby(int x, int y, int range) {
    // elements of the original array before the chosen element
    int[] temp1 = Arrays.copyOfRange(multi[x], 0, y);
    // elements in the chosen range
    int[] temp2 = null;
    if (temp1.length >= range){
      temp2 = Arrays.copyOfRange(temp1, temp1.length - range, temp1.length);
    } else {
      temp2 = Arrays.copyOfRange(temp1, 0, temp1.length);
    };

    // elements of the original array after the chosen element
    int[] temp3 = Arrays.copyOfRange(multi[x], y + 1, multi[x].length);
    // elements in the chosen range
    int[] temp4 = null;
    if (temp3.length >= range){
      temp4 = Arrays.copyOfRange(temp3, 0, range);
    } else {
      temp4 = Arrays.copyOfRange(temp3, 0, temp3.length);
    };

    // concatenation of the two arrays
    int[] result = new int[temp2.length + temp4.length];
    System.arraycopy(temp2, 0, result, 0, temp2.length);
    System.arraycopy(temp4, 0, result, temp2.length, temp4.length);

    return result;
  };

}
