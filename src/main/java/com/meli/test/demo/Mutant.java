package com.meli.test.demo;

import org.json.JSONArray;
import org.json.JSONException;

public class Mutant {
	
	public Mutant() { }
	
	/**
	 * 
	 * @param dna
	 * if steps taken are equal/greater than 4
     *	return true or false
	 * else
     *	move to the right and recursively check if this move leads to same base.
     *	if the move chosen above doesn't lead you to a mutant, then try to the diagonal.
     *	if the move chosen above doesn't lead you to a mutant, then move down.
     *	if none of the above solutions work, then unmark and backtrack.
	 * @throws JSONException 
	 */
	public boolean isMutant(JSONArray dna) throws JSONException {

		boolean res = checkDNA(dna);
		
		return res;
	}
	
	public boolean isValid(char curr, char base) {
		if (curr == base) return true;
		
		return false;
	}
	
	public boolean inBounds(JSONArray dna, int row, int col) throws JSONException {
		if (row >= 0 && row < dna.length() - 1 && col >= 0 && col < dna.getString(row).length() - 1) return true;
		
		return false;
	}
	
	public boolean checkDNA(JSONArray dna) throws JSONException {

		char base = dna.getString(0).charAt(0);
		
		for (int row = 0; row < dna.length(); row++) {
			for (int col = 0; col < dna.getString(row).length(); col++) {
				if (moveDown(dna, row, col, 0, base)) return true;
				
				if (moveRight(dna, row, col, 0, base)) return true;
				
				if (moveDiag(dna, row, col, 0, base)) return true;
			}
		}
 
        return false;
	}
	
	public boolean moveDown(JSONArray dna, int row, int col, int count, char base) throws JSONException {
		
		if (dna.getString(row).charAt(col) != base) return false;
		
		count++;
		if (count == 4) return true;
		
		if (inBounds(dna, row, col))
            return moveDown(dna, row + 1, col, count, base);
 
        return false;
	}
	
	public boolean moveRight(JSONArray dna, int row, int col, int count, char base) throws JSONException {
		
		if (dna.getString(row).charAt(col) != base) return false;
		
		count++;
		if (count == 4) return true;
		
		if (inBounds(dna, row, col))
            return moveRight(dna, row, col + 1, count, base);
 
        return false;
	}
	
	public boolean moveDiag(JSONArray dna, int row, int col, int count, char base) throws JSONException {
		
		if (dna.getString(row).charAt(col) != base) return false;
		
		count++;
		if (count == 4) return true;	
		
		if (inBounds(dna, row, col))
            return moveDiag(dna, row + 1, col + 1, count, base); 
 
        return false;
	}
}
