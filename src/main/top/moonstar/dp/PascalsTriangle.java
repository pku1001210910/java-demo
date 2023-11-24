package top.moonstar.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        new PascalsTriangle().generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> lastTime = new ArrayList<>();
        for(int i=0; i< numRows;i++){
            List<Integer> thisTime = new ArrayList<>();
            thisTime.add(1);
            for(int j=0;j<lastTime.size() - 1;j++){
                int sum = lastTime.get(j) + lastTime.get(j+1);
                thisTime.add(sum);
            }
            if(i > 0) {
                thisTime.add(1);
            }
            lastTime = thisTime;
            res.add(thisTime);
        }
        return res;
    }
}
