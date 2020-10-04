package Bulletin_Board_2;

import java.util.ArrayList;

public class Page_Num_Count {
	
	Board head_P = New_Post.Super_Post;
	
	public int Page_num_count_ID(ArrayList<Board> ALB_ID) {
		int Size = ((ALB_ID.size() - 1) / 4);
		if (Size == 0) {
			return 1;
		}
		else if ((ALB_ID.size() - 1) % 4 == 0) {
			return Size;
		}
		else {
			return Size + 1;
		}
	}
	
	public int Page_num_count() {
		
		int PN = 0;
		int PN_Aux = 0;
		
		head_P = New_Post.Super_Post;
		
		while (PN_Aux == 0) {
			for (int i = 0; i < 4; i++) {
				if (head_P.Next_Post_Add == null) {
					PN++;
					PN_Aux = 1;
					break;
				}
				else  {
					head_P = head_P.Next_Post_Add;
				}
			}
			if (PN_Aux == 0) {
				PN++;
			}
		}
		return PN;
	}
	
	public int Mine_Page_num_count() { // 조건 추가
		
		int PN_M = 0;
		int PN_M_Aux = 0;
		
		head_P = New_Post.Super_Post;
		
		while (PN_M_Aux == 0) {
			for (int i = 0; i < 4; i++) {
				if (head_P.Next_Post_Add == null) {
					if ((head_P.Writer).equals(Log_in.Logged_in)) {
						PN_M++;
						PN_M_Aux = 1;
					}
					else {
						PN_M_Aux = 1;
					}
					break;
				}
				else  {
					head_P = head_P.Next_Post_Add;
				}
			}
			if ((head_P.Writer).equals(Log_in.Logged_in)) {
				if (PN_M_Aux == 0) {
					PN_M++;
				}
			}
		}
		return PN_M;
	}
	
	public int Whole_Page_num_count() { // Package of Page
		
		int WPN = 0;
		int WPN_Aux = 1;
		int PN_Aux = Page_num_count();
		
		while (WPN_Aux == 0) {
			for (int i = 0; i < PN_Aux; i++) {
				WPN_Aux++;
				if (WPN_Aux == 3) {
					WPN++;
					WPN_Aux = WPN_Aux / 3;
				}
			}
			if (PN_Aux % 3 != 0) {
				WPN++;
			}
		}
		return WPN;
	}
}