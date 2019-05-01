private int bfs(int board[][],int startX,int startY,int endX,int endY,int rows,int cols) {
    boolean visited[][] = new boolean[rows][cols];
    visited[startX][startY] = true;
    Queue<String> q = new LinkedList<>();
    q.add(startX + " " + startY);
    boolean found = false;
    int steps = -1;
    while(!q.isEmpty()) {
        int size = q.size();
        steps++;
        while(size --> 0) {
            String str[] = q.poll().split(" ");
            startX = Integer.parseInt(str[0]);
            startY = Integer.parseInt(str[1]);
            if(startX == endX && startY == endY) {
                return steps;
            }
            //Up Direction
            for(int i = (startX-1);(i >= 0 && board[i][startY] == 0);i--) {
                if(visited[i][startY]) {
                    continue;
                }
                else {
                    q.add(i + " " + startY);
                    visited[i][startY] = true;
                }
            }
            //Right Direction
            for(int j = (startY+1);(j < cols && board[startX][j] == 0);j++) {
                if(visited[startX][j]) {
                    continue;
                }
                else {
                    q.add(startX + " " + j);
                    visited[startX][j] = true;
                }
            }
            //Down Direction
            for(int i = (startX+1);(i < rows && board[i][startY] == 0);i++) {
                if(visited[i][startY]) {
                    continue;
                }
                else {
                    q.add(i + " " + startY);
                    visited[i][startY] = true;
                }
            }
            //Left Direction
            for(int j = (startY-1);(j >= 0 && board[startX][j] == 0);j--) {
                if(visited[startX][j]) {
                    continue;
                }
                else {
                    q.add(startX + " " + j);
                    visited[startX][j] = true;
                }
            }
        }
    }
    
    return -1;
}