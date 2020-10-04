package Bulletin_Board_2;

import java.util.ArrayList;

public class Board_Class {
	
	static int Login = 0;
	static int Abs_Member = 0; // Test_Data
	
	public static void main(String[] args) {
		
		// 테스트 데이터
		// ================================================================================================== //
		
		Abs_Member = 1;
		
		// New_Member
		
		Member NM1 = new Member();
		New_Member.NM_Num++;
		New_Member.Nod_NUM++;
		New_Member.DN++;
		NM1.D_Num_M = New_Member.DN;
		NM1.Name = "홍길동";
		NM1.ID = "wpdk2";
		NM1.PW = "23452345";
		NM1.age = 23;
		New_Member.Super_head = NM1;
		
		Member NM2 = new Member();
		New_Member.NM_Num++;
		New_Member.Nod_NUM++;
		New_Member.DN++;
		NM2.D_Num_M = New_Member.DN;
		NM2.Name = "최영희";
		NM2.ID = "wpdk1";
		NM2.PW = "12341234";
		NM2.age = 26;
		NM1.Next_Add = NM2;
		
		Member NM3 = new Member();
		New_Member.NM_Num++;
		New_Member.Nod_NUM++;
		New_Member.DN++;
		NM3.D_Num_M = New_Member.DN;
		NM3.Name = "강개리";
		NM3.ID = "wpdk4";
		NM3.PW = "45674567";
		NM3.age = 31;
		NM2.Next_Add = NM3;
		
		Member NM4 = new Member();
		New_Member.NM_Num++;
		New_Member.Nod_NUM++;
		New_Member.DN++;
		NM4.D_Num_M = New_Member.DN;
		NM4.Name = "김철수";
		NM4.ID = "wpdk3";
		NM4.PW = "34563456";
		NM4.age = 21;
		NM4.Next_Add = null;
		NM3.Next_Add = NM4;
		New_Member.Super_last = NM4;
		
		// New_Post
		
		Board NP1 = new Board();
		New_Post.NP_Num++;
		NP1.title = "카페는 처음입니다!";
		NP1.Post_Contents = "잘부탁드려요~~";
		NP1.Writer = "wpdk1"; // Logged_in(ID)
		NP1.D_Num_P = 2;
		NP1.Present_P_Num = 1;
		NP1.Present_P_head = NP1;
		NP1.Next_Post_Add= null;
		NP1.Comment_Num = 2;
		New_Post.Super_Post = NP1;
		
		Board NP2 = new Board();
		New_Post.NP_Num++;
		NP2.title = "뉴비님들은 공지사항 꼭 읽고 오세요!!";
		NP2.Post_Contents = "선택이 아니라 필수입니다ㅎㅎ";
		NP2.Writer = "wpdk4"; // Logged_in(ID)
		NP2.D_Num_P = 3;
		NP2.Present_P_Num = 2;
		NP2.Present_P_head = NP2;
		NP1.Next_Post_Add= NP2;
		NP2.Comment_Num = 1;
		
		Board NP3 = new Board();
		New_Post.NP_Num++;
		NP3.title = "이거 회원 탈퇴도 가능한가요?";
		NP3.Post_Contents = "ㅈㄱㄴ";
		NP3.Writer = "wpdk2"; // Logged_in(ID)
		NP3.D_Num_P = 1;
		NP3.Present_P_Num = 3;
		NP3.Present_P_head = NP3;
		NP2.Next_Post_Add= NP3;
		NP3.Comment_Num = 3;
		
		Board NP4 = new Board();
		New_Post.NP_Num++;
		NP4.title = "내가 바로 홍길동이다!!";
		NP4.Post_Contents = "카페 회원 중에 꼭 홍길동 한 명은 있을 것 같아서..ㅎㅎ";
		NP4.Writer = "wpdk3"; // Logged_in(ID)
		NP4.D_Num_P = 4;
		NP4.Present_P_Num = 4;
		NP4.Present_P_head = NP4;
		NP3.Next_Post_Add= NP4;
		NP4.Comment_Num = 3;
		
		Board NP5 = new Board();
		New_Post.NP_Num++;
		NP5.title = "아 카페 탈퇴할라그랬는데";
		NP5.Post_Contents = "뭐.. 생각보다 사람들이 괜찮네요ㅎㅎ";
		NP5.Writer = "wpdk1"; // Logged_in(ID)
		NP5.D_Num_P = 2;
		NP5.Present_P_Num = 5;
		NP5.Present_P_head = NP5;
		NP4.Next_Post_Add= NP5;
		NP5.Comment_Num = 0;
		
		Board NP6 = new Board();
		New_Post.NP_Num++;
		NP6.title = "게시글";
		NP6.Post_Contents = "쓸게없당ㅎㅎ";
		NP6.Writer = "wpdk3"; // Logged_in(ID)
		NP6.D_Num_P = 4;
		NP6.Present_P_Num = 6;
		NP6.Present_P_head = NP6;
		NP5.Next_Post_Add= NP6;
		NP6.Comment_Num = 0;
		
		Board NP7 = new Board();
		New_Post.NP_Num++;
		NP7.title = "님들";
		NP7.Post_Contents = "그냥 불러봤어욯ㅎㅎㅎ";
		NP7.Writer = "wpdk4"; // Logged_in(ID)
		NP7.D_Num_P = 3;
		NP7.Present_P_Num = 7;
		NP7.Present_P_head = NP7;
		NP6.Next_Post_Add= NP7;
		NP7.Comment_Num = 0;
		
		Board NP8 = new Board();
		New_Post.NP_Num++;
		NP8.title = "이것이 바로";
		NP8.Post_Contents = "마지막 테스트데이터 전의 것~~!은 아님ㅋ";
		NP8.Writer = "wpdk4"; // Logged_in(ID)
		NP8.D_Num_P = 3;
		NP8.Present_P_Num = 8;
		NP8.Present_P_head = NP8;
		NP7.Next_Post_Add= NP8;
		NP8.Comment_Num = 0;
		
		Board NP9 = new Board();
		New_Post.NP_Num++;
		NP9.title = "안냐~~";
		NP9.Post_Contents = "방가방가~~";
		NP9.Writer = "wpdk3"; // Logged_in(ID)
		NP9.D_Num_P = 4;
		NP9.Present_P_Num = 9;
		NP9.Present_P_head = NP9;
		NP8.Next_Post_Add= NP9;
		NP9.Comment_Num = 0;
		
		Board NP10 = new Board();
		New_Post.NP_Num++;
		NP10.title = "웃으니 행복합니다!!!";
		NP10.Post_Contents = "헤헤헤헤헤헤헤헤헿ㅎ";
		NP10.Writer = "wpdk2"; // Logged_in(ID)
		NP10.Present_P_Num = 10;
		NP10.D_Num_P = 1;
		NP10.Present_P_head = NP10;
		NP9.Next_Post_Add= NP10;
		NP10.Comment_Num = 0;
		
		Board NP11 = new Board();
		New_Post.NP_Num++;
		NP11.title = "할 말도 없다 어야냐";
		NP11.Post_Contents = "테스트 데이터 있다는 사실에 감사해라";
		NP11.Writer = "wpdk1"; // Logged_in(ID)
		NP11.D_Num_P = 2;
		NP11.Present_P_Num = 11;
		NP11.Present_P_head = NP11;
		NP10.Next_Post_Add= NP11;
		NP11.Comment_Num = 0;
		
		Board NP12 = new Board();
		New_Post.NP_Num++;
		NP12.title = "진짜 테스트 데이터 마지막";
		NP12.Post_Contents = "전의 데이터다!! 갸꿀ㅎㅎㅎ";
		NP12.Writer = "wpdk2"; // Logged_in(ID)
		NP12.D_Num_P = 1;
		NP12.Present_P_Num = 12;
		NP12.Present_P_head = NP12;
		NP11.Next_Post_Add= NP12;
		NP12.Comment_Num = 0;
		
		Board NP13 = new Board();
		New_Post.NP_Num++;
		NP13.title = "다시 시작";
		NP13.Post_Contents = "커피 한 잔";
		NP13.Writer = "wpdk1"; // Logged_in(ID)
		NP13.D_Num_P = 2;
		NP13.Present_P_Num = 13;
		NP13.Present_P_head = NP13;
		NP12.Next_Post_Add= NP13;
		NP13.Comment_Num = 0;
		
		Board NP14 = new Board();
		New_Post.NP_Num++;
		NP14.title = "연애할래 남 몰래";
		NP14.Post_Contents = "만나보지 않을래";
		NP14.Writer = "wpdk1"; // Logged_in(ID)
		NP14.D_Num_P = 2;
		NP14.Present_P_Num = 14;
		NP14.Present_P_head = NP14;
		NP13.Next_Post_Add= NP14;
		NP14.Comment_Num = 0;
		
		Board NP15 = new Board();
		New_Post.NP_Num++;
		NP15.title = "영화는 심야영화";
		NP15.Post_Contents = "푹 눌러쓴 스냅백";
		NP15.Writer = "wpdk1"; // Logged_in(ID)
		NP15.D_Num_P = 2;
		NP15.Present_P_Num = 15;
		NP15.Present_P_head = NP15;
		NP14.Next_Post_Add= NP15;
		NP15.Comment_Num = 0;
		
		Board NP16 = new Board();
		New_Post.NP_Num++;
		NP16.title = "얼마나 떨리는데";
		NP16.Post_Contents = "하나부터 열까지 다 기대해요";
		NP16.Writer = "wpdk1"; // Logged_in(ID)
		NP16.D_Num_P = 2;
		NP16.Present_P_Num = 16;
		NP16.Present_P_head = NP16;
		NP15.Next_Post_Add= NP16;
		NP16.Comment_Num = 0;
		
		Board NP17 = new Board();
		New_Post.NP_Num++;
		NP17.title = "지금부터 연애할래? 만나지 않을래?";
		NP17.Post_Contents = "벌써 모든게 설레이네요";
		NP17.Writer = "wpdk1"; // Logged_in(ID)
		NP17.D_Num_P = 2;
		NP17.Present_P_Num = 17;
		NP17.Present_P_head = NP17;
		NP16.Next_Post_Add= NP17;
		NP17.Comment_Num = 0;
		
		Board NP18 = new Board();
		New_Post.NP_Num++;
		NP18.title = "사실은 나도 잘 모르겠어";
		NP18.Post_Contents = "불안한 마음은 어디에서 태어나";
		NP18.Writer = "wpdk1"; // Logged_in(ID)
		NP18.D_Num_P = 2;
		NP18.Present_P_Num = 18;
		NP18.Present_P_head = NP18;
		NP17.Next_Post_Add= NP18;
		NP18.Comment_Num = 0;
		
		Board NP19 = new Board();
		New_Post.NP_Num++;
		NP19.title = "그러니 우린 손을 잡아야 해";
		NP19.Post_Contents = "바다에 빠지지 않도록";
		NP19.Writer = "wpdk1"; // Logged_in(ID)
		NP19.D_Num_P = 2;
		NP19.Present_P_Num = 19;
		NP19.Present_P_head = NP19;
		NP18.Next_Post_Add= NP19;
		NP19.Comment_Num = 0;
		
		Board NP20 = new Board();
		New_Post.NP_Num++;
		NP20.title = "끊임없이 눈을 맞춰야 해";
		NP20.Post_Contents = "가끔은 너무 익숙해져버린 서로를 잃어버리지 않도록";
		NP20.Writer = "wpdk1"; // Logged_in(ID)
		NP20.D_Num_P = 2;
		NP20.Present_P_Num = 20;
		NP20.Present_P_head = NP20;
		NP19.Next_Post_Add= NP20;
		NP20.Comment_Num = 0;
		
		Board NP21 = new Board();
		New_Post.NP_Num++;
		NP21.title = "테스트 데이터는";
		NP21.Post_Contents = "이걸로 끝입니다.";
		NP21.Writer = "wpdk2"; // Logged_in(ID)
		NP21.D_Num_P = 1;
		NP21.Present_P_Num = 21;
		NP21.Present_P_head = NP21;
		NP20.Next_Post_Add= NP21;
		NP21.Next_Post_Add= null;
		NP21.Comment_Num = 0;
		New_Post.Super_Last_Post = NP21;
		
		// New_Comment
		
		Comment NC1 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC1.Writer_Aux = "wpdk2"; // ID
		NC1.comment = "헐 전뎈ㅋㅋㅋㅋ";
		NC1.D_Num_C = 1;
		NC1.Post_Board_Num = 4;
		NC1.Present_P_head = NP4;
		NC1.Next_Com_Add = null;
		NC1.Present_Com_Num = 1;
		New_Comment.Super_Comment = NC1;
		
		Comment NC2 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC2.Writer_Aux = "wpdk3"; // ID
		NC2.comment = "엌ㅋㅋㅋ 진짜 있을 줄은 몰랐네요.. ㅈㅅ;";
		NC2.D_Num_C = 4;
		NC2.Post_Board_Num = 4;
		NC2.Present_P_head = NP4;
		NC1.Next_Com_Add = NC2;
		NC2.Present_Com_Num = 2;
		
		Comment NC3 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC3.Writer_Aux = "wpdk1"; // ID
		NC3.comment = "뭔뎈ㅋㅋ 우연의 일치치곤 엄청나잖앜ㅋㅋ";
		NC3.D_Num_C = 2;
		NC3.Post_Board_Num = 4;
		NC3.Present_P_head = NP4;
		NC2.Next_Com_Add = NC3;
		NC3.Present_Com_Num = 3;
		
		Comment NC4 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC4.Writer_Aux = "wpdk4"; // ID
		NC4.comment = "네 메뉴에 보시면 탈퇴하기버튼 있어요~";
		NC4.D_Num_C = 3;
		NC4.Post_Board_Num = 3;
		NC4.Present_P_head = NP3;
		NC3.Next_Com_Add = NC4;
		NC4.Present_Com_Num = 4;
		
		Comment NC5 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC5.Writer_Aux = "wpdk1"; // ID
		NC5.comment = "헐 그건 몰랐네; 당장 탈퇴함ㅅㄱ";
		NC5.D_Num_C = 2;
		NC5.Post_Board_Num = 3;
		NC5.Present_P_head = NP3;
		NC4.Next_Com_Add = NC5;
		NC5.Present_Com_Num = 5;
		
		Comment NC6 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC6.Writer_Aux = "wpdk3"; // ID
		NC6.comment = "아 어디가요~~~ 가지마요ㅠㅠ";
		NC6.D_Num_C = 4;
		NC6.Post_Board_Num = 3;
		NC6.Present_P_head = NP3;
		NC5.Next_Com_Add = NC6;
		NC6.Present_Com_Num = 6;
		
		Comment NC7 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC7.Writer_Aux = "wpdk3"; // ID
		NC7.comment = "반가워요~~~! 친하게 지냅시다!!";
		NC7.D_Num_C = 4;
		NC7.Post_Board_Num = 1;
		NC7.Present_P_head = NP1;
		NC6.Next_Com_Add = NC7;
		NC7.Present_Com_Num = 7;
		
		Comment NC8 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC8.Writer_Aux = "wpdk2"; // ID
		NC8.comment = "뉴비님 환영해요~~!";
		NC8.D_Num_C = 1;
		NC8.Post_Board_Num = 1;
		NC8.Present_P_head = NP1;
		NC7.Next_Com_Add = NC8;
		NC8.Present_Com_Num = 8;
		
		Comment NC9 = new Comment();
		New_Comment.NC_Num++;
		New_Comment.NC_Num_Aux++;
		NC9.Writer_Aux = "wpdk1"; // ID
		NC9.D_Num_C = 2;
		NC9.comment = "넹ㅎㅎ";
		NC9.Post_Board_Num = 2;
		NC9.Present_P_head = NP2;
		NC8.Next_Com_Add = NC9;
		NC9.Next_Com_Add = null;
		NC9.Present_Com_Num = 9;
		New_Comment.Super_Last_Comment = NC9;
		
		// ================================================================================================== //
		
		Menu_Class MC = new Menu_Class();
		
		System.out.println(" ");
		System.out.println("==========================================================");
		System.out.println(" ");
		System.out.println("            myus_wju59의 카페에 오신 것을 환영합니다.");
		System.out.println(" ");
		System.out.println("==========================================================");
		System.out.println(" ");
		
		MC.Menu_func();
		
	}
}

class Member {
	String Name;
	String ID;
	String PW;
	int age;
	int D_Num_M;
	Member Next_Add;
	
	Member() {
		
	}
	
	public void AddMember(String Name, String ID, String PW, int age) {
		this.Name = Name;
		this.ID = ID;
		this.PW = PW;
		this.age = age;
	}
	
	public void output_Members(Member Member) {
		System.out.println("===================================================");
		System.out.println("이름 : " + Member.Name + ", " + "ID : " +  Member.ID + ", " + "PW : " + Member.PW + ", " + "나이 : " + Member.age);
	}
}

class Board {
	New_Post NP_2 = new New_Post();
	int NP_num = NP_2.NP_Num + 1;
	String title;
	String Post_Contents;
	String Writer; // Logged_in(ID)
	int Present_P_Num;
	Board Present_P_head;
	Board Next_Post_Add;
	int Comment_Num = 0;
	int D_Num_P;
	
	Board() {
		
	}
	
	public void AddPost(String title, String Post_Contents, String Writer) {
		this.title = title;
		this.Post_Contents = Post_Contents;
		this.Writer = Writer;
	}
	
	public void output_Post(Board Board) {
		System.out.println("=============================================");
		System.out.println("게시물 번호 : " + Board.Present_P_Num);
		System.out.println("제목 : " + Board.title);
		System.out.println("내용 : " + Board.Post_Contents);
		System.out.println("작성자 : " + Board.Writer);
		System.out.println("=============================================");
	}
	
	public void Modify_Post_T(String title) {
		this.title = title;
	}
	
	public void Modify_Post_P(String Post_Contents) {
		this.Post_Contents = Post_Contents;
	}
}

class Comment {
	
	int C_Num = 0;
	
	String Writer_Aux = null; // ID
	String comment = null;
	int Post_Board_Num = 0;
	Board Present_P_head = null;
	Comment Next_Com_Add = null;
	int Present_Com_Num = 0;
	int D_Num_C;
	
	Comment() {
		
	}
	
	public void Add_Comment(String Writer_Aux, String comment, int Post_Board_Num, int Present_Com_Num) { // Board Present_P_head
		this.Writer_Aux = Writer_Aux;
		this.comment = comment;
		this.Post_Board_Num = Post_Board_Num;
		this.Present_Com_Num = Present_Com_Num;
	}
	
	public void Output_Comment(Comment comment_Aux) {
		System.out.println(comment_Aux.Writer_Aux + " : " + comment_Aux.comment + " (" + comment_Aux.Present_Com_Num + ")");
	}
	
	public int Output_Comment_Num() {
		return C_Num;
	}
}