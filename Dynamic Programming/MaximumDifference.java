import java.util.List;

public class MaximumDifference  
{ 
    int maxDiffrnc(List<Integer> a)  
    { 

        int length = a.get(0);
        a.remove(0);

        int min = a.get(0);
        int max = a.get(0);
        int maxDifference = 0;
        for(int i = 1; i < length; i++){
            if(a.get(i) > max){
                max = a.get(i);
                maxDifference = Math.max(maxDifference, (max - min)); 
            }else if(a.get(i) < min){
                min = a.get(i);
            }
        }
        return maxDifference;
    } 
  
    public static void main(String[] args)  
    { 
        MaximumDifference maxdiff = new MaximumDifference(); 
        List<Integer> a = new ArrayList<Integer>();

        a.add(7);
        a.add(2);
        a.add(3);
        a.add(10);
        a.add(2);
        a.add(4);
        a.add(8);
        a.add(1);
        
        System.out.println(maxdiff.maxDiffrnc(a)); 
    } 
}