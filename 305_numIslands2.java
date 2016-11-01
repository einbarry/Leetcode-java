public class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(m<= 0|| n<= 0) return res;
        int count = 0;
        
        int[] roots = new int[m*n];//convert 2D to 1D
        Arrays.fill(roots, -1);
        
        for(int[] p: positions){
            int root = p[0]*n+ p[1];
            roots[root] = root;
            count++;
            
            for(int[] dir: dirs){
                int x = p[0]+dir[0];
                int y = p[1]+dir[1];
                int nb = x*n+y;
                if(x<0 || x>= m || y < 0 || y>= n || roots[nb] == -1) continue; //dont forget roots[nb] == -1!!!
                int rootNb = find(roots, nb); 
                if(root!=rootNb){  // if neighbor is in another island
                    roots[root] = rootNb; // union two islands
                    root = rootNb; // current tree root = joined tree root, dont forget
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    
    public int find(int[] roots, int id){
        while(id!= roots[id]) id = roots[id];
        return id;
    }
}