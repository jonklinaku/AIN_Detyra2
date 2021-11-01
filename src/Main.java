import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args)  throws Exception{
        System.out.println(Arrays.toString(crossOver(new int[]{1,2,3,4,5,6},new int[]{6,3,2,5,4,1})));
    }
    private static int[] crossOver(int[] parent1,int[] parent2) throws Exception{
        if (parent1.length != parent2.length)
            throw new Exception("array length mismatch");
        int[] ans = new int[parent1.length];
        int pos1 =((int) (Math.random()*(parent1.length-2))) + 1;
        int pos2 =((int) (Math.random()*(parent1.length-2))) + 1;
        if (pos2 < pos1){
            int temp = pos2;
            pos2 = pos1;
            pos1 = temp;
        }
        System.out.println("Positions are: "+pos1 + " and " + pos2);
        List<Integer> availablePool = new ArrayList<>();
        for (int i = 0; i < parent1.length; i++) {
            if (i>=pos1 && i<=pos2)
                ans[i] = parent1[i];
            else
                availablePool.add(parent1[i]);
        }
        System.out.println("crossover before fill: "+Arrays.toString(ans));
        System.out.println("numbers left to fill: "+availablePool.toString());
        int ansIndex = 0;
        for (int i = 0; i < parent2.length; i++) {
            if (availablePool.contains(parent2[i])){
                System.out.println("found number "+parent2[i]+" in pool "+availablePool.toString()+" on position: "+ i);
                ans[ansIndex] = parent2[i];
                availablePool.remove(new Integer(parent2[i]));
                if (ansIndex == (pos1 - 1))
                    ansIndex += pos2 - pos1 + 1;
                    ansIndex++;
                System.out.println("Solution after insert: "+Arrays.toString(ans));
            }

        }
        return ans;
    }

}
