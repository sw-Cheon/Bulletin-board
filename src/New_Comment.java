package Bulletin_Board_2;

import java.util.Scanner;

public class New_Comment extends Comment {
	
	int C_Num = 0;
	
	String Writer_Aux = null;
	String comment = null;
	int Post_Board_NC = 0;
	
	static Comment Super_Comment = null;
	static Comment Super_Last_Comment = null;
	static int Super_Last_Aux = 0;
	static int Super_Last_Aux_2 = 0;
	static int NC_Num = 0;
	static int NC_Num_Aux = 0;
	
	Comment first_C = null;
	Comment head_C = null;
	Comment last_C = null;
	
	public void New_Comment(String Writer_Aux, String comment, int Post_Board_Num, Board Present_P_head) {
		
		New_Post NM_P = new New_Post();
		Comment NC = new Comment();
		int DC_Num = 0;
		NC_Num++;
		NC_Num_Aux++;

		head_C = Super_Comment;
		last_C = Super_Last_Comment;
		
		Member head = New_Member.Super_head;
		for (int i = 0; i < New_Member.NM_Num; i++) {
			if ((head.ID).equals(Log_in.Logged_in)) {
				DC_Num = head.D_Num_M;
			}
			else {
				head = head.Next_Add;
			}
		}
		head = New_Member.Super_head;
		
		if (NC_Num == 1) {
			head_C = NC;
			Super_Comment = NC;
			Post_Board_NC = Post_Board_Num;
			NC.D_Num_C = DC_Num;
			last_C = NC;
			Super_Last_Comment = NC;
			last_C.Next_Com_Add = null;
			head_C.Add_Comment(Writer_Aux, comment, Post_Board_Num, NC_Num_Aux);
			Present_P_head.Comment_Num++;
			System.out.println(" ");
			System.out.println("=================");
			System.out.println("댓글이 작성되었습니다!");
			System.out.println("=================");
			System.out.println(" ");
			NC.Output_Comment(NC);
		}
		
		else {
			if (Super_Last_Aux == 1) {
				last_C = Super_Last_Comment;
			}
			if (Super_Last_Aux_2 == 1) {
				last_C = Super_Last_Comment;
			}
			if (Board_Class.Abs_Member == 1) {  // Test_Data
				last_C = Super_Last_Comment;    // Test_Data
			}									// Test_Data
			Super_Last_Aux = 0;
			Super_Last_Aux_2 = 0;
			last_C = Super_Last_Comment;
			last_C.Next_Com_Add = NC;
			last_C = NC;
			Super_Last_Comment = NC;
			Post_Board_NC = Post_Board_Num;
			NC.D_Num_C = DC_Num;
			last_C.Add_Comment(Writer_Aux, comment, Post_Board_Num, NC_Num_Aux);
			last_C.Next_Com_Add = null;
			Present_P_head.Comment_Num++;
			System.out.println(" ");
			System.out.println("=================");
			System.out.println("댓글이 작성되었습니다!");
			System.out.println("=================");
			System.out.println(" ");
			NC.Output_Comment(NC);
		}
	}
}