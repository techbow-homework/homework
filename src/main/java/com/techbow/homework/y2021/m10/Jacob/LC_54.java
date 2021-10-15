public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length -1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            //step 1: from left to right, row 不变，col变大
            for(int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]); // 1, 2, 3
            }
            rowBegin++;

            //step 2: from top to bottom, col不变,row变大

            for(int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            //step 3: from right to left, row不变，col变小
            if (rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            //step 4: from bottom to top, col不变，row变小
            if (colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }