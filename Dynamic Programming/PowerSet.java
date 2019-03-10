import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet{

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if(set.size() == index){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>()); //Empty Subset
        }else{
            allSubsets = getSubsets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> arr : allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(arr);
                newSubset.add(item);
                moreSubset.add(newSubset);
            }
            allSubsets.addAll(moreSubset);
        }
        return allSubsets;
    }

    public static void main(String[] args){
        ArrayList<Integer> aList = new ArrayList<Integer>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        ArrayList<ArrayList<Integer>> result = getSubsets(aList, 0);
        
        for(ArrayList<Integer> subResult : result){
            for(int value : subResult){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}