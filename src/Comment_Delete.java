package Bulletin_Board_2;

import java.util.Scanner;

public class Comment_Delete extends New_Comment {

	public int Comment_delete() {
		
		int Bool_ADM = 0;
		int CD = 0;
		int Case_Aux_3 = 0;
		int pp = 0;
		Board Super_post = New_Post.Super_Post;
		Board head_P = Super_post;
		
		Comment head_C = Super_Comment;
		Comment last_C = Super_Last_Comment;
		
		head_C = Super_Comment;
		for(int i = 0; i < NC_Num; i++) {
			if ((head_C.Writer_Aux).equals(Log_in.Logged_in)) {
				Case_Aux_3++;
			}
			head_C = head_C.Next_Com_Add;
		}
		head_C = Super_Comment;
		if (Case_Aux_3 == 0) {
			System.out.println(" ");
			System.out.println("=================================");
			System.out.println("현재 게시물에 회원님이 작성한 댓글이 없습니다.");
			System.out.println("=================================");
			System.out.println(" ");
			return 1;
		}
		
		int delete_Aux = 0;
		int delete_Aux_2 = 0;
		int try_catch = 0;
		int delete_Comment_Aux = 0;
		
		while(delete_Aux == 0) {
			while (try_catch == 0) {
				try {
					System.out.println(" ");
					System.out.println("삭제를 원하시는 댓글의 번호를 입력해주세요.");
					System.out.printf("%c", '>');
					System.out.printf("%c", ' ');
					Scanner DM_C = new Scanner(System.in);
					int delete_Comment = DM_C.nextInt();
					delete_Comment_Aux = delete_Comment;
					try_catch = 1;

					while(true) {
						if (head_C.Present_Com_Num == delete_Comment_Aux) {
							break;
						}
						else {
							head_C = head_C.Next_Com_Add;
						}
					}
					
					int op = 0;
					while (op == 0) {
						if (head_C.Post_Board_Num == head_P.Present_P_Num) {
							break;
						}
						else {
							head_P = head_P.Next_Post_Add;
						}
					}
				} catch (NullPointerException eN) {
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("해당 댓글은 없습니다.");
					System.out.println("===============");
					System.out.println(" ");
					pp = 1;
					delete_Aux_2 = 1;
					CD = 1;
					return 1;
				} catch (Exception e) {
					System.out.println(" ");
					System.out.println("==============");
					System.out.println("잘못된 명령어입니다.");
					System.out.println("==============");
					System.out.println(" ");
					pp = 1;
					delete_Aux_2 = 1;
					CD = 1;
					return 1;
				}
			}
			
			Member head = New_Member.Super_head;
			int DC_Num = 0;
			for (int i = 0; i < New_Member.NM_Num; i++) {
				if ((head.ID).equals(Log_in.Logged_in)) {
					DC_Num = head.D_Num_M;
				}
				else {
					head = head.Next_Add;
				}
			}
			head = New_Member.Super_head;
			
			while (pp == 0) {
				if ((head_C.Writer_Aux).equals(Log_in.Logged_in)) {
					if (head_C.D_Num_C == DC_Num) {
						delete_Aux_2 = 0;
						delete_Aux = 1;
						break;
					}
					else {
						System.out.println(" ");
						System.out.println("============================");
						System.out.println("본인이 작성한 댓글만 삭제할 수 있습니다.");
						System.out.println("============================");
						System.out.println(" ");
						delete_Aux = 1;
						delete_Aux_2 = 1;
						pp = 1;
						return 1;
					}
				}
				else {
					System.out.println(" ");
					System.out.println("============================");
					System.out.println("본인이 작성한 댓글만 삭제할 수 있습니다.");
					System.out.println("============================");
					System.out.println(" ");
					delete_Aux = 1;
					delete_Aux_2 = 1;
					pp = 1;
					return 1;
				}
			}
		}
		if (delete_Aux_2 == 0) {
			System.out.println("정말 삭제하시겠습니까?");
			System.out.printf("%s", "y/n >");
			System.out.printf("%c", ' ');
			
			Scanner Con = new Scanner(System.in);
			String Confirm_delete = Con.next();
			
			switch (Confirm_delete) {
				case "y":
					CD = 0;
					break;
				case "n":
					CD = 1;
					System.out.println(" ");
					System.out.println("=================");
					System.out.println("메인메뉴로 돌아갑니다.");
					System.out.println("=================");
					System.out.println(" ");
					return 1;
				default :
					CD = 1;
					System.out.println(" ");
					System.out.println("=============================");
					System.out.println("잘못된 명령어입니다. 다시 시도해주세요.");
					System.out.println("=============================");
					System.out.println(" ");
					return 1;
			}
			
			head_C = Super_Comment;
			
			while (CD == 0) {
				if (head_C.Present_Com_Num == delete_Comment_Aux && NC_Num > 2) {
					head_C = head_C.Next_Com_Add;
					Super_Comment = head_C;
					head_P.Comment_Num--;
					NC_Num--;
					System.out.println(" ");
					System.out.println("================");
					System.out.println("댓글이 삭제되었습니다.");
					System.out.println("================");
					System.out.println(" ");
					return 1;
				}
				
				else if(head_C.Present_Com_Num == delete_Comment_Aux && NC_Num == 1) {
					head_C = null;
					Super_Comment = head_C;
					System.out.println(" ");
					System.out.println("================");
					System.out.println("댓글이 삭제되었습니다.");
					System.out.println("================");
					System.out.println(" ");
					Bool_ADM = 1;
					head_P.Comment_Num--;
					NC_Num--;
					return 1;
				}
				
				else if ((head_C.Next_Com_Add).Present_Com_Num == delete_Comment_Aux && NC_Num > 2) {
					if ((head_C.Next_Com_Add).Next_Com_Add == null) {
						Super_Last_Comment = head_C;
						Super_Last_Aux = 1;
					}
					head_C.Next_Com_Add = (head_C.Next_Com_Add).Next_Com_Add;
					head_C = Super_Comment;
					head_P.Comment_Num--;
					NC_Num--;
					System.out.println(" ");
					System.out.println("================");
					System.out.println("댓글이 삭제되었습니다.");
					System.out.println("================");
					System.out.println(" ");
					return 1;
				}
				
				else if (head_C.Next_Com_Add != null && NC_Num > 2) {
					head_C = head_C.Next_Com_Add;
				}
				
				else if (head_C.Present_Com_Num == delete_Comment_Aux && NC_Num == 2) {
					head_C = head_C.Next_Com_Add;
					Super_Comment = head_C;
					head_P.Comment_Num--;
					NC_Num--;
					System.out.println(" ");
					System.out.println("================");
					System.out.println("댓글이 삭제되었습니다.");
					System.out.println("================");
					System.out.println(" ");
					return 1;
				}
				
				else if ((head_C.Next_Com_Add).Present_Com_Num == delete_Comment_Aux && NC_Num == 2) {
					head_C.Next_Com_Add = null;
					Super_Last_Comment = head_C;
					Super_Last_Aux_2 = 1;
					head_P.Comment_Num--;
					NC_Num--;
					System.out.println(" ");
					System.out.println("================");
					System.out.println("댓글이 삭제되었습니다.");
					System.out.println("================");
					System.out.println(" ");
					return 1;
				}
			}
			if (CD == 0) {
				if (Bool_ADM == 0)
					head_C = Super_Comment;
					head_P = Super_post;
				Bool_ADM = 0;
			}
		}
		return 0;
	}
}