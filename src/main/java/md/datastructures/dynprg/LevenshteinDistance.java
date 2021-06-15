package md.datastructures.dynprg;

import java.util.Arrays;

public class LevenshteinDistance {

	/**
	 *  "abc" "ab"--> insertar c
	 *  "ab" "abc" --> delete c
	 *  "abc" "axc" --> replace b * x
	 *   
	 * @param x
	 * @param y
	 * @return
	 */
	public int recursive(String x,String y) {
        if (x.isEmpty()) {
            return y.length();
        }

        if (y.isEmpty()) {
            return x.length();
        } 
        
        int substitution = recursive(x.substring(1), y.substring(1)) 
                + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = recursive(x, y.substring(1)) + 1;
        int deletion = recursive(x.substring(1), y) + 1;

        return Math.min(substitution, Math.min(deletion, insertion));
	}
	
    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
    
    public int dynamicProgramming(String x,String y) {
    	/**       a b c 
    	 *      0 1 2 3
    	 *    a 1 0 1 2 
    	 *    x 2 1 2
    	 *    c 3 2 2
    	 */
    	int[][] distance = new int[x.length()+1][y.length()+1];
    	for(int i=0;i<=x.length();i++) {
    		for(int j=0;j<=y.length();j++) {
    			if(i==0) {
    				distance[i][j] = i;
    			} else {
    				if(j==0) { 
        				distance[i][j] = j;
    				} else {
    					distance[i][j] = min(
    						distance[i - 1][j - 1] + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
    						distance[i - 1][j] + 1, 
    						distance[i][j - 1] + 1
    					);
    				}
    			}
    		}
    	}
    
    	return distance[x.length()][y.length()];
    }
    
    private int min(int... vals) {
    	return Arrays.stream(vals)
        .min().orElse(Integer.MAX_VALUE);
    }
    
}
