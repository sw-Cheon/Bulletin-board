package Bulletin_Board_2;

import java.util.Scanner;

public class New_Post extends Board_Class {
	
	static Board Super_Post = null;
	static Board Super_Last_Post = null;
	static int Super_Last_Post_Aux = 0;
	static int Super_Last_Post_Aux_2 = 0;
	static int NP_Num = 0;
	
	Board first_P = null;
	Board head_P = null;
	Board last_P = null;
	
	public void New_Post() {
		
		String title;
		String Post_Contents;
		Member head = New_Member.Super_head;
		int DP_Num = 0;
		
		head_P = Super_Post;
		last_P = Super_Last_Post;

		for (int i = 0; i < New_Member.NM_Num; i++) {
			if ((head.ID).equals(Log_in.Logged_in)) {
				DP_Num = head.D_Num_M;
			}
			else {
				head = head.Next_Add;
			}
		}
		head = New_Member.Super_head;
		
		System.out.println(" ");
		System.out.println("========================");
		System.out.println("새 게시물 작성 메뉴로 이동합니다.");
		System.out.println("========================");
		System.out.println(" ");
		System.out.println("게시물의 제목을 입력해주세요.");
		System.out.printf("%c", '>');
		System.out.printf("%c", ' ');
		
		Scanner sc23 = new Scanner(System.in);
		title = sc23.nextLine();
		System.out.println(" ");
		System.out.println("내용을 입력해주세요.");
		System.out.printf("%c", '>');
		System.out.printf("%c", ' ');
		Scanner sc24 = new Scanner(System.in);
		Post_Contents = sc24.nextLine();
		
		Board NP = new Board();
		NP_Num++;

		if (NP_Num == 1) {
			first_P = NP;
			head_P = NP;
			Super_Post = NP;
			NP.Present_P_Num = NP_Num;
			NP.D_Num_P = DP_Num;
			last_P = NP;
			Super_Last_Post = NP;
			last_P.Next_Post_Add = null;
			first_P.AddPost(title, Post_Contents, New_Member.Logged_in);
			System.out.println(" ");
			System.out.println("=================");
			System.out.println("게시물이 작성되었습니다!");
			System.out.println("=================");
			System.out.println(" ");
			NP.output_Post(NP);
		}
		
		else {
			if (Super_Last_Post_Aux == 1) {
				last_P = Super_Last_Post;
			}
			if (Super_Last_Post_Aux_2 == 1) {
				last_P = Super_Last_Post;
			}
			Super_Last_Post_Aux = 0;
			Super_Last_Post_Aux_2 = 0;
			if (Board_Class.Abs_Member == 1) {  // Test_Data
				last_P = Super_Last_Post;       // Test_Data
			}									// Test_Data
			last_P.Next_Post_Add = NP;
			last_P = NP;
			Super_Last_Post = NP;
			NP.Present_P_Num = NP_Num;
			NP.D_Num_P = DP_Num;
			last_P.AddPost(title, Post_Contents, New_Member.Logged_in);
			last_P.Next_Post_Add = null;
			System.out.println(" ");
			System.out.println("=================");
			System.out.println("게시물이 작성되었습니다!");
			System.out.println("=================");
			System.out.println(" ");
			NP.output_Post(NP);
		}
	}
}