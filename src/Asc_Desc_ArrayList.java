package Bulletin_Board_2;

import java.util.*;

public class Asc_Desc_ArrayList extends Searching_Menu {

	public ArrayList<String> Sort_return() {
		
		Board head_P = New_Post.Super_Post;
		String Writer = null;
		
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < New_Post.NP_Num; i++) {
			hs.add(head_P.Writer);
			head_P = head_P.Next_Post_Add;
		}
		
		Iterator<String> hs_i = hs.iterator();
		
		ArrayList<String> al = new ArrayList<String>();
		while (hs_i.hasNext()) {
			Writer = (String)hs_i.next();
			al.add(Writer);
		}
		
		Collections.sort(al);
		
		return al;
	}
	
	public ArrayList<Board> Sort_Board_return() {
		
		ArrayList<Board> ArL = new ArrayList<Board>();
		ArrayList<Board> Array_of_Board = new ArrayList<Board>();
		ArrayList<String> al_Aux_desc = null;
		al_Aux_desc = Sort_return();
		int Abs_Num_5 = HashSet_return_Num(); // 4
		
		Board head_P = New_Post.Super_Post;
		for (int i = 0; i < New_Post.NP_Num; i++) {
			ArL.add(head_P);
			head_P = head_P.Next_Post_Add;
		}
		head_P = New_Post.Super_Post;
		
		for (int j = 0; j < Abs_Num_5; j++) {
			head_P = New_Post.Super_Post;
			for(int i = 0; i < New_Post.NP_Num; i++) {
				if (((ArL.get(i).Writer)).equals(al_Aux_desc.get(j))) {
					Array_of_Board.add(head_P);
					head_P = head_P.Next_Post_Add;
				}
				else {
					head_P = head_P.Next_Post_Add;
				}
			}
		}
		head_P = New_Post.Super_Post;
		
		return Array_of_Board;
	}
}