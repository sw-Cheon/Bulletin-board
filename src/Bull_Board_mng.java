package Bulletin_Board_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bull_Board_mng extends New_Member {

	static int q = 0;
	static int Output_Aux = 0;
	static int Output_Aux_D = 0;
	int Order_2 = 0;
	int Output_while_Aux = 0;
	int Page_Num = 0;
	Board head_P = null;
	Board head_P_Aux = null;
	Page_Num_Count PNC = new Page_Num_Count();
	ArrayList<Board> ALB_Mine = null;
	int Aux_3 = 0;
	int page_Aux = 0;
	
	public void Bull_Board_mng() {
		
		int Bool = 0;
		Board_Class BC = new Board_Class();
		New_Post NP = new New_Post();
		Post_Delete PD = new Post_Delete();
		Searching_Menu SM = new Searching_Menu();
		Search_with_Contains SwC = new Search_with_Contains();
		int Case_2_Aux = 0;
		
		while(Bool == 0) {
			System.out.println(" ");
			System.out.println("====================");
			System.out.println("게시판메뉴로 이동하였습니다.");
			System.out.println("====================");
			System.out.println(" ");
			System.out.println("================");
			System.out.println("1. 새 게시물 작성");
			System.out.println("2. 내가 쓴 게시물 확인");
			System.out.println("3. 전체 게시물 보기");
			System.out.println("4. 게시물 삭제");
			System.out.println("5. 게시물 검색");
			System.out.println("exit. 게시판 종료");
			System.out.println("================");
			
			System.out.println("이용을 원하시는 메뉴의 번호를 입력해주세요.");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner Sc22 = new Scanner(System.in);
			String Order_Bull = Sc22.next();
			
			switch(Order_Bull) {
			
				case "1":
					NP.New_Post();
					break;
					
				case "2":
					ALB_Mine = Search_in_Mine(Logged_in);
					if (ALB_Mine == null) {
						break;
					}
					Aux_3 = 0;
					Output_Aux = 0;
					while (true) {
						Show_All_Mine(Output_Aux, ALB_Mine, PNC.Page_num_count_ID(ALB_Mine));
						if (Output_Aux == -1) {
							break;
						}
					}
					break;
					
				case "3":
					Aux_3 = 0;
					Output_Aux = 0;
					while (true) {
						Show_All(Output_Aux);
						if (Output_Aux == -1) {
							break;
						}
					}
					head_P = New_Post.Super_Post;
					break;
					
				case "4":
					System.out.println(" ");
					PD.Post_delete();
					break;
					
				case "5":
					System.out.println(" ");
					SM.Searching_Menu();
					break;
					
				case "exit":
					Bool = 1;
					System.out.println(" ");
					System.out.println("=================");
					System.out.println("게시판메뉴를 종료합니다.");
					System.out.println("=================");
					System.out.println(" ");
					break;
					
				default :
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("잘못된 명령어입니다.");
					System.out.println("===============");
					System.out.println(" ");
					break;
			}
		}
	}
	
	public Board Output_Post(int Order_2) {
		Board head_P = New_Post.Super_Post;
		Board head_P_Aux = null;
		Comment head_C = New_Comment.Super_Comment;
		
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if (head_P.Present_P_Num == Order_2) {
				head_P.output_Post(head_P);
				head_P_Aux = head_P;
				System.out.println("댓글(" + head_P.Comment_Num + ")");
				if (head_P.Comment_Num > 0) {
					if (head_P.Comment_Num == 1) {
						for(int k2 = 0; k2 < New_Comment.NC_Num; k2++) {
							if (head_C.Post_Board_Num == Order_2) {
								head_C.Output_Comment(head_C);
								break;
							}
							else {
								head_C = head_C.Next_Com_Add;
							}
						}
					}
					else {
						for (int k = 0; k < New_Comment.NC_Num; k++) {
							if (head_C.Post_Board_Num == Order_2) {
								head_C.Output_Comment(head_C);
								head_C = head_C.Next_Com_Add;
							}
							else {
								head_C = head_C.Next_Com_Add;
							}
						}
						head_C = New_Comment.Super_Comment;
					}
					break;
				}
				head_P = head_P.Next_Post_Add;
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		System.out.println("=============================================");
		return head_P_Aux;
	}
	
	public Board Output_Post_in_ID(String SC_V) {
		Board head_P = New_Post.Super_Post;
		Board head_P_Aux = null;
		Comment head_C = New_Comment.Super_Comment;
		Member head = New_Member.Super_head;
		int DCP_Num = 0;

		for (int i = 0; i < New_Member.NM_Num; i++) {
			if ((head.ID).equals(SC_V)) {
				DCP_Num = head.D_Num_M;
			}
			else {
				head = head.Next_Add;
			}
		}
		head = New_Member.Super_head;
		
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if ((head_P.Writer).equals(SC_V)) {
				if (head_P.D_Num_P == DCP_Num) {
					head_P.output_Post(head_P);
					head_P_Aux = head_P;
					System.out.println("댓글(" + head_P.Comment_Num + ")");
					if (head_P.Comment_Num > 0) {
						if (head_P.Comment_Num == 1) {
							for(int k2 = 0; k2 < New_Comment.NC_Num; k2++) {
								if (head_C.Post_Board_Num == head_P.Present_P_Num) {
									head_C.Output_Comment(head_C);
									break;
								}
								else {
									head_C = head_C.Next_Com_Add;
								}
							}
						}
						else {
							for (int k = 0; k < New_Comment.NC_Num; k++) {
								if (head_C.Post_Board_Num == head_P.Present_P_Num) {
									head_C.Output_Comment(head_C);
									head_C = head_C.Next_Com_Add;
								}
								else {
									head_C = head_C.Next_Com_Add;
								}
							}
							head_C = New_Comment.Super_Comment;
						}
						break;
					}
					head_P = head_P.Next_Post_Add;
				}
				else {
					head_P = head_P.Next_Post_Add;
				}
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		System.out.println("=============================================");
		return head_P_Aux;
	}
	
	public void Comment_Function(Board head_P_Aux) {
		New_Comment New_comment = new New_Comment();
		Comment_Delete Com_D = new Comment_Delete();
		int q2 = 0;
		while (q2 == 0) {
			System.out.println("댓글쓰기 : c, 댓글삭제 : d, 메인화면으로 이동 : x");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner sc27 = new Scanner(System.in);
			String Order_3 = sc27.next();
			
			switch(Order_3) {
				case "c" :
					System.out.println("댓글을 입력해주세요.");
					System.out.printf("%c", '>');
					System.out.printf("%c", ' ');
					
					Scanner sc28 = new Scanner(System.in);
					String Order_4 = sc28.nextLine();
					New_comment.New_Comment(Logged_in, Order_4, head_P_Aux.Present_P_Num, head_P_Aux);
					q = 1;
					q2 = 1;
					break;
					
				case "d" :
					int CD_Aux = 0;
					CD_Aux = Com_D.Comment_delete();
					if (CD_Aux == 1) {
						q2 = 1;
						q = 1;
					}
					break;
					
				case "x" :
					q2 = 1;
					q = 1;
					break;
					
				default :
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("잘못된 명령어입니다.");
					System.out.println("===============");
					System.out.println(" ");
					break;
			}
		}
	}
	
	public void Comment_Function_Mine(Board head_P_Aux) {
		New_Comment New_comment = new New_Comment();
		Comment_Delete Com_D = new Comment_Delete();
		int q2 = 0;
		while (q2 == 0) {
			System.out.println("댓글쓰기 : c, 댓글삭제 : d, 메인화면으로 이동 : x");
			System.out.println("게시물 수정 : r");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner sc27 = new Scanner(System.in);
			String Order_3 = sc27.next();
			
			switch(Order_3) {
				case "c" :
					System.out.println("댓글을 입력해주세요.");
					System.out.printf("%c", '>');
					System.out.printf("%c", ' ');
					
					Scanner sc28 = new Scanner(System.in);
					String Order_4 = sc28.nextLine();
					New_comment.New_Comment(Logged_in, Order_4, head_P_Aux.Present_P_Num, head_P_Aux);
					q = 1;
					q2 = 1;
					break;
					
				case "d" :
					int CD_Aux = 0;
					CD_Aux = Com_D.Comment_delete();
					if (CD_Aux == 1) {
						q2 = 1;
						q = 1;
					}
					break;
					
				case "r" :
					int q3 = 0;
					while (q3 == 0) {
						System.out.println("제목수정 : t, 내용수정 : p");
						System.out.printf("%c", '>');
						System.out.printf("%c", ' ');
						Scanner sc40 = new Scanner(System.in);
						String Order_5 = sc40.next();
						
						switch(Order_5) {
							case "t" :
								System.out.println("변경할 제목을 입력해주세요.");
								System.out.printf("%c", '>');
								System.out.printf("%c", ' ');
								
								Scanner sc41 = new Scanner(System.in);
								String Order_6 = sc41.nextLine();
								head_P_Aux.Modify_Post_T(Order_6);
								
								System.out.println(" ");
								System.out.println("===============================================");
								System.out.println("제목이 수정되었습니다. : " + head_P_Aux.title);
								System.out.println("===============================================");
								System.out.println(" ");
								
								q = 1;
								q2 = 1;
								q3 = 1;
								break;
								
							case "p" :
								System.out.println("변경할 내용을 입력해주세요.");
								System.out.printf("%c", '>');
								System.out.printf("%c", ' ');
								
								Scanner sc42 = new Scanner(System.in);
								String Order_7 = sc42.nextLine();
								head_P_Aux.Modify_Post_P(Order_7);
								
								System.out.println(" ");
								System.out.println("===============================================");
								System.out.println("내용이 수정되었습니다. : " + head_P_Aux.Post_Contents);
								System.out.println("===============================================");
								System.out.println(" ");
								
								q = 1;
								q2 = 1;
								q3 = 1;
								break;
								
							default :
								System.out.println(" ");
								System.out.println("===============");
								System.out.println("잘못된 명령어입니다.");
								System.out.println("===============");
								System.out.println(" ");
						}
					}
					break;
					
				case "x" :
					q2 = 1;
					q = 1;
					break;
					
				default :
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("잘못된 명령어입니다.");
					System.out.println("===============");
					System.out.println(" ");
					break;
			}
		}
	}
	
	public void Show_All(int Num) {
		Num = Output_Aux * 4;
		head_P = New_Post.Super_Post;
		if (Output_Aux != 0) {
			for (int i = 0; i < Num; i++) {
				head_P = head_P.Next_Post_Add;
			}
		}
		System.out.println("\n\n");
		for (int i = Num; i < Num + 4; i++) {
			if (head_P.Next_Post_Add == null) {
				head_P.output_Post(head_P);
				System.out.println("댓글(" + head_P.Comment_Num + ")");
				System.out.println("=============================================");
				break;
			}
			head_P.output_Post(head_P);
			System.out.println("댓글(" + head_P.Comment_Num + ")");
			System.out.println("=============================================");
			head_P = head_P.Next_Post_Add;
		}
		head_P = New_Post.Super_Post;
		
		q = 0;
		if(New_Post.NP_Num == 0) {
			System.out.println(" ");
			System.out.println("==================");
			System.out.println("게시된 게시물이 없습니다.");
			System.out.println("==================");
			System.out.println(" ");
			q = 1;
		}		
		Output_onePost();
	}
	
	public void Output_onePost() {
		
		if (q != 1) {
			q = 0;
		}
		while (q == 0) {
			
			int eP = 0;
			System.out.println("게시물 보기 : v, 메인화면으로 이동 : x");
			System.out.println("다음페이지 : >, 이전페이지 : <, 다음메뉴 : >>, 이전메뉴 : <<");
			System.out.println("페이지 숫자로 입력 : n");
			System.out.printf("%s", "============= 페이지 번호 : ");

			if (Aux_3 % 3 == 0) {
				page_Aux = Aux_3 / 3;
			}
			else {
				page_Aux = Aux_3 / 3;
			}
			int page = (page_Aux) * 3;
			Page_Num = PNC.Page_num_count();
			if (page_Aux != 0) {
				System.out.printf("%s", "<< ");
			}
			
			for (int i = page; i < page + 3; i++) {
				if (i + 1 == Page_Num) {
					if (Output_Aux == i) {
						System.out.printf("%c", '*');
					}
					System.out.printf("%d ", i + 1);
					eP = 1;
					break;
				}
				else {
					if (Output_Aux == i) {
						System.out.printf("%c", '*');
					}
					System.out.printf("%d ", i + 1);
				}
			}
			if (eP == 0) {
				System.out.printf("%s", ">>");
			}
			System.out.printf("%s", " =============");
			System.out.println(" ");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			
			Scanner sc25 = new Scanner(System.in);
			String Order = sc25.next();
			switch(Order) {
				case "v" :
					int try_catch_Aux_2 = 0;
					while (try_catch_Aux_2 == 0) {
						try {
							System.out.println("열람을 원하시는 게시물의 번호를 입력해주세요.");
							System.out.printf("%c", '>');
							System.out.printf("%c", ' ');
							
							Scanner sc26 = new Scanner(System.in);
							int Order_2_Aux = sc26.nextInt();
							System.out.println(" ");
							if (New_Post.NP_Num >= Order_2_Aux) {
								Order_2 = Order_2_Aux;
								try_catch_Aux_2 = 1;
							}
							else {
								System.out.println("=========================");
								System.out.println("올바른 게시물 번호를 입력해주세요.");
								System.out.println("=========================");
								System.out.println(" ");
							}
						} catch (Exception e) {
							System.out.println(" ");
							System.out.println("==============");
							System.out.println("잘못된 명령어입니다.");
							System.out.println("==============");
							System.out.println(" ");
						}
					}
					
					head_P_Aux = Output_Post(Order_2);
					Comment_Function(head_P_Aux);
					Output_Aux = -1;
					Aux_3 = 0;
					page_Aux = 0;
					break;
					
				case ">" :
					int Last_Page = PNC.Page_num_count();
					if (Last_Page - 1 == Output_Aux) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("마지막 페이지 입니다.");
						System.out.println("===============");
						System.out.println(" ");
					}
					else {
						Output_Aux++;
						Aux_3++;
					}
					q = 1;
					break;
					
				case ">>" :
					int Last_Page_2 = PNC.Page_num_count();
					if (Last_Page_2 - 1 == Output_Aux) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("마지막 페이지 입니다.");
						System.out.println("===============");
						System.out.println(" ");
					}
					else if (Output_Aux + 1 == Last_Page_2 - 1) {
						Output_Aux = Output_Aux + 1;
						Aux_3 = Aux_3 + 1;
						page_Aux = Aux_3 / 3;
					}
					else if (Output_Aux + 2 == Last_Page_2 - 1) {
						Output_Aux = Output_Aux + 2;
						Aux_3 = Aux_3 + 2;
						page_Aux = Aux_3 / 3;
					}
					else {
						Output_Aux = Output_Aux + 3;
						Aux_3 = Aux_3 + 3;
						page_Aux = Aux_3 / 3;
					}
					q = 1;
					break;
					
				case "<" :
					if (Output_Aux == 0) {
						System.out.println(" ");
						System.out.println("=============");
						System.out.println("첫 페이지 입니다.");
						System.out.println("=============");
						System.out.println(" ");
					}
					else {
						Output_Aux--;
						if (Aux_3 == 3) {
							page_Aux = 0;
						}
						Aux_3--;
					}
					q = 1;
					break;
					
				case "<<" :
					Output_Aux = Output_Aux - 3;
					if (Aux_3 == 3) {
						page_Aux = 0;
					}
					Aux_3 = Aux_3 - 3;
					if (Output_Aux <= 0) {
						Output_Aux = 0;
						page_Aux = 0;
						Aux_3 = 0;
						System.out.println(" ");
						System.out.println("=============");
						System.out.println("첫 페이지 입니다.");
						System.out.println("=============");
						System.out.println(" ");
					}
					else if (Output_Aux < 3) {
						page_Aux = 0;
					}
					q = 1;
					break;
					
				case "x" :
					Output_Aux = -1;
					Aux_3 = 0;
					page_Aux = 0;
					q = 1;
					break;
					
				case "n" :
					int Aux = 0;
					int try_catch = 0;
					while (Aux == 0) {
						while (try_catch == 0) {
							try {
								System.out.println("이동을 원하시는 페이지의 번호를 입력해주세요.");
								System.out.printf("%c", '>');
								System.out.printf("%c", ' ');
								Scanner sc37 = new Scanner(System.in);
								int Search_Num = sc37.nextInt();
								if (Search_Num < 1 || Search_Num > PNC.Page_num_count()) {
									System.out.println(" ");
									System.out.println("===================");
									System.out.println("게시물 번호를 확인해주세요.");
									System.out.println("===================");
									System.out.println(" ");
								}
								else if (Output_Aux + 1 == Search_Num) {
									System.out.println(" ");
									System.out.println("===============");
									System.out.println("현재 페이지입니다.");
									System.out.println("===============");
									System.out.println(" ");
								}
								else {
									Output_Aux = Search_Num - 1;
									Aux_3 = Search_Num - 1;
									try_catch = 1;
									Aux = 1;
									q = 1;
									break;
								}
							} catch (Exception eA) {
								System.out.println(" ");
								System.out.println("===============");
								System.out.println("잘못된 명령어입니다.");
								System.out.println("===============");
								System.out.println(" ");
							}	
						}
					}
					break;
					
				default :
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("잘못된 명령어입니다.");
					System.out.println("===============");
					System.out.println(" ");
					break;
			}
		}
		head_P = New_Post.Super_Post;
		q = 0;
	}
	
	public ArrayList<Board> Search_in_Mine(String Search_in_ID) {
		
		ArrayList<Board> ALB_Mine_2 = new ArrayList<Board>();
		Member head = New_Member.Super_head;
		int DCP_Num = 0;
		
		for (int i = 0; i < New_Member.NM_Num; i++) {
			if ((head.ID).equals(Log_in.Logged_in)) {
				DCP_Num = head.D_Num_M;
			}
			else {
				head = head.Next_Add;
			}
		}
		head = New_Member.Super_head;
		
		head_P = New_Post.Super_Post;
		int SiID = 0;
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if ((head_P.Writer).equals(Search_in_ID)) {
				if (head_P.D_Num_P == DCP_Num) {
					ALB_Mine_2.add(head_P);
					head_P = head_P.Next_Post_Add;
					SiID++;
				}
				else {
					head_P = head_P.Next_Post_Add;
				}
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		ALB_Mine_2.add(null);
		head_P = New_Post.Super_Post;
		if (SiID != 0) {
			return ALB_Mine_2;
		}
		else if (SiID == 0) {
			System.out.println(" ");
			System.out.println("=========================");
			System.out.println("회원님이 작성한 게시물이 없습니다.");
			System.out.println("=========================");
			System.out.println(" ");
		}
		return null;
	}
	
	public void Show_All_Mine (int Num, ArrayList<Board> ALB_ID, int page_Num_ID) {
		
		int kT = 0;
		Num = Output_Aux * 4;
		if (Output_Aux != 0) {
			for (int i = 0; i < Num; i++) {
				kT = i + 1;
			}
		}
		Num = kT;
		int SiID_4 = 0;
		System.out.println("\n\n");
		for(int i = Num; i < Num + 4; i++) {
			if (ALB_ID.get(i) == null) {
				SiID_4++;
				break;
			}
			else {
				(ALB_ID.get(i)).output_Post((ALB_ID.get(i)));
				System.out.println("댓글(" + (ALB_ID.get(i)).Comment_Num + ")");
				System.out.println("=============================================");
				SiID_4++;
			}
		}
		if (SiID_4 != 0) {
			Mine_Output_onePost(page_Num_ID);
		}
		if (SiID_4 == 0) {
			System.out.println(" ");
			System.out.println("=================");
			System.out.println("현재 게시물이 없습니다.");
			System.out.println("=================");
			System.out.println(" ");
			Output_Aux = -1;
		}
	}
	
	public void Mine_Output_onePost(int page_Num_Aux) {
		
		int page_Num_ID = page_Num_Aux;
		
		if (q != 1) {
			q = 0;
		}
		while (q == 0) {
			
			System.out.println("게시물 보기 : v, 메인화면으로 이동 : x");
			System.out.println("다음페이지 : >, 이전페이지 : <, 다음메뉴 : >>, 이전메뉴 : <<");
			System.out.println("페이지 숫자로 입력 : n");
			System.out.printf("%s", "============= 페이지 번호 : ");
			if (Aux_3 % 3 == 0) {
				page_Aux = Aux_3 / 3;
			}
			else {
				page_Aux = Aux_3 / 3;
			}
			int page = (page_Aux) * 3;
			int Page_Num = page_Num_ID;
			for (int i = page; i < page + 3; i++) {
				if (i + 1 == Page_Num) {
					if (Output_Aux == i) {
						System.out.printf("%c", '*');
					}
					System.out.printf("%d ", i + 1);
					break;
				}
				else {
					if (Output_Aux == i) {
						System.out.printf("%c", '*');
					}
					System.out.printf("%d ", i + 1);
				}
			}
			
			System.out.printf("%s", " =============");
			System.out.println(" ");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			
			Scanner sc25 = new Scanner(System.in);
			String Order = sc25.next();
			switch(Order) {
				case "v" :
					int try_catch_Aux_2 = 0;
					while (try_catch_Aux_2 == 0) {
						try {
							System.out.println("열람을 원하시는 게시물의 번호를 입력해주세요.");
							System.out.printf("%c", '>');
							System.out.printf("%c", ' ');
							
							Scanner sc26 = new Scanner(System.in);
							int Order_2_Aux = sc26.nextInt();
							System.out.println(" ");
							if (New_Post.NP_Num >= Order_2_Aux) {
								Order_2 = Order_2_Aux;
								try_catch_Aux_2 = 1;
							}
							else {
								System.out.println("=========================");
								System.out.println("올바른 게시물 번호를 입력해주세요.");
								System.out.println("=========================");
								System.out.println(" ");
							}
						} catch (Exception e) {
							System.out.println(" ");
							System.out.println("==============");
							System.out.println("잘못된 명령어입니다.");
							System.out.println("==============");
							System.out.println(" ");
						}
					}
					
					head_P_Aux = Output_Post(Order_2);
					Comment_Function_Mine(head_P_Aux);
					Output_Aux = -1;
					break;
					
				case ">" :
					int Last_Page = page_Num_ID;
					if (Last_Page - 1 == Output_Aux) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("마지막 페이지 입니다.");
						System.out.println("===============");
						System.out.println(" ");
					}
					else {
						Output_Aux++;
						Aux_3++;
					}
					q = 1;
					break;
					
				case ">>" :
					int Last_Page_2 = page_Num_ID;
					if (Last_Page_2 - 1 == Output_Aux) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("마지막 페이지 입니다.");
						System.out.println("===============");
						System.out.println(" ");
					}
					else if (Output_Aux + 1 == Last_Page_2 - 1) {
						Output_Aux = Output_Aux + 1;
						Aux_3 = Aux_3 + 1;
						page_Aux = Aux_3 / 3;
					}
					else if (Output_Aux + 2 == Last_Page_2 - 1) {
						Output_Aux = Output_Aux + 2;
						Aux_3 = Aux_3 + 2;
						page_Aux = Aux_3 / 3;
					}
					else {
						Output_Aux = Output_Aux + 3;
						Aux_3 = Aux_3 + 3;
						page_Aux = Aux_3 / 3;
					}
					q = 1;
					break;
					
				case "<" :
					if (Output_Aux == 0) {
						System.out.println(" ");
						System.out.println("=============");
						System.out.println("첫 페이지 입니다.");
						System.out.println("=============");
						System.out.println(" ");
					}
					else {
						Output_Aux--;
						if (Aux_3 == 3) {
							page_Aux = 0;
						}
						Aux_3--;
					}
					q = 1;
					break;
					
				case "<<" :
					Output_Aux = Output_Aux - 3;
					if (Aux_3 == 3) {
						page_Aux = 0;
					}
					Aux_3 = Aux_3 - 3;
					if (Output_Aux <= 0) {
						Output_Aux = 0;
						page_Aux = 0;
						Aux_3 = 0;
						System.out.println(" ");
						System.out.println("=============");
						System.out.println("첫 페이지 입니다.");
						System.out.println("=============");
						System.out.println(" ");
					}
					else if (Output_Aux < 3) {
						page_Aux = 0;
					}
					q = 1;
					break;
					
				case "x" :
					Output_Aux = -1;
					q = 1;
					break;
					
				case "n" :
					int Aux = 0;
					int try_catch = 0;
					while (Aux == 0) {
						while (try_catch == 0) {
							try {
								System.out.println("이동을 원하시는 페이지의 번호를 입력해주세요.");
								System.out.printf("%c", '>');
								System.out.printf("%c", ' ');
								Scanner sc37 = new Scanner(System.in);
								int Search_Num = sc37.nextInt();
								if (Search_Num < 1 || Search_Num > page_Num_ID) {
									System.out.println(" ");
									System.out.println("===================");
									System.out.println("페이지 번호를 확인해주세요.");
									System.out.println("===================");
									System.out.println(" ");
								}
								else if (Output_Aux + 1 == Search_Num) {
									System.out.println(" ");
									System.out.println("===============");
									System.out.println("현재 페이지입니다.");
									System.out.println("===============");
									System.out.println(" ");
								}
								else {
									Output_Aux = Search_Num - 1;
									Aux_3 = Search_Num - 1;
									try_catch = 1;
									Aux = 1;
									q = 1;
									break;
								}
							} catch (Exception eA) {
								System.out.println(" ");
								System.out.println("===============");
								System.out.println("잘못된 명령어입니다.");
								System.out.println("===============");
								System.out.println(" ");
							}	
						}
					}
					break;
					
				default :
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("잘못된 명령어입니다.");
					System.out.println("===============");
					System.out.println(" ");
					break;
			}
		}
		head_P = New_Post.Super_Post;
		q = 0;
	}
}