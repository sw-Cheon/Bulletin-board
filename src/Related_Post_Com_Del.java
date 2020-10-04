package Bulletin_Board_2;

import java.util.Scanner;

public class Related_Post_Com_Del extends New_Comment {
	
	public void Related_Post_Com_del(int delete_Post) {
		
		int Bool_ADM = 0;
		int CD = 0;
		int NC_Num_Aux = 0;
		Board Super_post = New_Post.Super_Post;
		Board head_P = Super_post;
		Comment head_C = Super_Comment;
		
		while (true) {
			if (head_P.Present_P_Num == delete_Post) {
				break;
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		
		NC_Num_Aux = head_P.Comment_Num;
		
		for (int i = 0; i < NC_Num_Aux; i++) {
			head_C = Super_Comment;
			while (true) {
				if (head_C.Post_Board_Num == delete_Post && NC_Num > 2) {
					head_C = head_C.Next_Com_Add;					
					Super_Comment = head_C;
					head_P.Comment_Num--;
					NC_Num--;
					break;
				}
				
				else if(head_C.Post_Board_Num == delete_Post && NC_Num == 1) {
					head_C = null;
					Super_Comment = head_C;
					Bool_ADM = 1;
					head_P.Comment_Num--;
					NC_Num--;
					break;
				}
				
				else if ((head_C.Next_Com_Add).Post_Board_Num == delete_Post && NC_Num > 2) {
					if ((head_C.Next_Com_Add).Next_Com_Add == null) {
						Super_Last_Comment = head_C;
						Super_Last_Aux = 1;
					}
					head_C.Next_Com_Add = (head_C.Next_Com_Add).Next_Com_Add;
					head_C = Super_Comment;
					head_P.Comment_Num--;
					NC_Num--;
					break;
				}
				
				else if (head_C.Next_Com_Add != null && NC_Num > 2) {
					head_C = head_C.Next_Com_Add;
				}
				
				else if (head_C.Post_Board_Num == delete_Post && NC_Num == 2) {
					head_C = head_C.Next_Com_Add;
					Super_Comment = head_C;
					head_P.Comment_Num--;
					NC_Num--;
					break;
				}
				
				else if ((head_C.Next_Com_Add).Post_Board_Num == delete_Post && NC_Num == 2) {
					head_C.Next_Com_Add = null;
					head_P.Comment_Num--;
					NC_Num--;
					break;
				}
			}
			if (CD == 0) {
				if (Bool_ADM == 0)
					head_C = Super_Comment;
				Bool_ADM = 0;
			}
		}
		
		head_C = Super_Comment;
		int dN_Aux = delete_Post + 1;
		if (delete_Post != New_Post.NP_Num) {
			for (int j = delete_Post; j < New_Post.NP_Num; j++) {
				for (int i = 0; i < NC_Num; i++) {
					if (head_C.Post_Board_Num == dN_Aux) {
						head_C.Post_Board_Num--;
						head_C = head_C.Next_Com_Add;
					}
					else {
						head_C = head_C.Next_Com_Add;
					}
				}
			head_C = Super_Comment;
			dN_Aux++;
			}
		}
	}
}