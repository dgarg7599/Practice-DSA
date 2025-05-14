import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        ArrayList<Integer> list=new ArrayList<>();

        if(matrix.length==0){
            return list;
        }

        while(startRow<=endRow && startCol<=endCol){

            //top
            for(int j=startCol;j<=endCol;j++){
                list.add(matrix[startRow][j]);
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                list.add(matrix[i][endCol]);
            }
            //bottom
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow == endRow){
                    break;
                }
                list.add(matrix[endRow][j]);
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                list.add(matrix[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;

        }
        return list;
    }
}