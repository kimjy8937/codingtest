import java.util.*;

class Solution {
    int[][] parent;
    public String[] solution(String[] commands) {
        String[] answer = {};

        ArrayList<String> resultList = new ArrayList<>();
        
        String[][] matrix = new String[51][51];
        
        parent = new int[51][51];
        
        for(int i=1; i<parent.length; i++) {
            for(int j=1; j<parent[0].length; j++) {
                parent[i][j] = i*100 + j;
            }
        }

        for(int i=0; i<commands.length; i++) {
            String[] commandArr = commands[i].split(" ");
            if("UPDATE".equals(commandArr[0])) {
                if(commandArr.length == 4) {
                    int r = Integer.parseInt(commandArr[1]);
                    int c = Integer.parseInt(commandArr[2]);
                    int parentVal = findParent(r, c);
                    matrix[parentVal/100][parentVal%100] = commandArr[3]; // 부모의 좌표를 업데이트
                } else {
                    for(int j=1; j<matrix.length; j++) {
                        for(int k=1; k<matrix[0].length; k++) {
                            if(commandArr[1].equals(matrix[j][k]) && findParent(j, k) == j*100 + k) // value1이고 자신이 부모이면 업데이트
                                matrix[j][k] = commandArr[2];
                        }
                    }
                }
            } else if("MERGE".equals(commandArr[0])) {
                int r1 = Integer.parseInt(commandArr[1]);
                int c1 = Integer.parseInt(commandArr[2]);
                int r2 = Integer.parseInt(commandArr[3]);
                int c2 = Integer.parseInt(commandArr[4]);

                int parentVal1 = findParent(r1, c1);
                int parentVal2 = findParent(r2, c2);
                
                if(parentVal1 == parentVal2) continue; // 부모가 같으면 이미 MERGE 상태
                
                if(matrix[parentVal1/100][parentVal1%100] == null) {
                    parent[parentVal1/100][parentVal1%100] = parentVal2;
                } else {
                    parent[parentVal2/100][parentVal2%100] = parentVal1;
                }
            } else if("UNMERGE".equals(commandArr[0])) {
                int r = Integer.parseInt(commandArr[1]);
                int c = Integer.parseInt(commandArr[2]);

                int parentVal = findParent(r, c);
                String mergedVal = matrix[parentVal/100][parentVal%100];
                
                ArrayList<Integer> unmergeList = new ArrayList<>();
                for(int j=1; j<parent.length; j++) {
                    for(int k=1; k<parent.length; k++) {
                        if(findParent(j, k) == parentVal) {
                            unmergeList.add(j*100 + k);
                        }
                    }
                }
                
                for(int u : unmergeList) {
                    parent[u/100][u%100] = u;
                    matrix[u/100][u%100] = null;
                }
                matrix[r][c] = mergedVal;
            } else if("PRINT".equals(commandArr[0])) {
                int r = Integer.parseInt(commandArr[1]);
                int c = Integer.parseInt(commandArr[2]);
                int parentVal = findParent(r, c);

                String printStr = matrix[parentVal/100][parentVal%100] == null ? "EMPTY" : matrix[parentVal/100][parentVal%100];
                resultList.add(printStr);
            }
        }
        
        answer = new String[resultList.size()];

        for(int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
    
    public int findParent(int i, int j) {
        if(parent[i][j] == i*100 + j)
            return i*100 + j;

        return findParent(parent[i][j]/100, parent[i][j]%100);
    }
}