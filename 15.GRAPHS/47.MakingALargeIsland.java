class DisjointSetUnion {
    ArrayList<Integer> parent = new ArrayList<Integer>();
    ArrayList<Integer> size = new ArrayList<Integer>();

    DisjointSetUnion(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUltimateParent(int x) {
        if (x == parent.get(x))
            return x;

        int sa = findUltimateParent(parent.get(x));
        parent.set(x, sa);
        return sa;
    }

    public void union(int x, int y) {
        int ulpx = findUltimateParent(x);
        int ulpy = findUltimateParent(y);

        if (ulpx != ulpy) {
            int sizex = size.get(ulpx);
            int sizey = size.get(ulpy);

            if (sizex > sizey) {
                parent.set(ulpy, ulpx);
                size.set(ulpx, sizex + sizey);
            } else {
                parent.set(ulpx, ulpy);
                size.set(ulpy, sizex + sizey);
            }
        }

    }

}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        boolean allones = true;
        boolean allzeroes = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                if (x == 1)
                    allzeroes = false;
                if (x == 0)
                    allones = false;
            }
        }
       if(allzeroes)return 1;
       if(allones)return n*n;

        DisjointSetUnion dsu = new DisjointSetUnion(n * n);

        int deltax[] = { 0, 0, +1, -1 };
        int deltay[] = { +1, -1, 0, 0 };
        for (int i = 0; i < n; i++) {
            int multiplier = i;
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                int value = n * multiplier + j;
                if (x == 1) {
                    for (int k = 0; k < deltax.length; k++) {
                        int newx = i + deltax[k];
                        int newy = j + deltay[k];
                        if (newx >= 0 && newx < n && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                            int newval = newx * n + newy;
                            dsu.union(value, newval);
                        }
                    }
                }

            }

        }
        // ab dsu bnchuka hai , sab components connect hochuke hai
        int max = 0;

        for (int i = 0; i < n; i++) {
            int multiplier = i;
            for (int j = 0; j < n; j++) {

                int x = grid[i][j];
                int size = 0;
                if (x == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < deltax.length; k++) {
                        int newx = i + deltax[k];
                        int newy = j + deltay[k];
                        if (newx >= 0 && newx < n && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                            int newval = newx * n + newy;
                            int ulp = dsu.findUltimateParent(newval);
                            set.add(ulp);
                        }
                    }
                    for (int val : set) {
                        size += dsu.size.get(val);
                    }
                    max = Math.max(max, size);
                }

            }
        }

        return max + 1;

    }

}

// agar koi 1 hai , to uske charo side check karo ki kya koi 1 present hai aur
// agar nhi h to kuch nahi karna lekin agar 1 hai to hume unka union krna hai

// 11011 01234 x*n+y
// 01111 56789 5*1+0
// 11101

// 2+5
