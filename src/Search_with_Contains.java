package Bulletin_Board_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Search_with_Contains extends Searching_Menu {

	Bull_Board_mng BBm = new Bull_Board_mng();
	Board head_P = null;
	
	public ArrayList<Board> Search_in_ID(String Search_in_ID) {
		
		ArrayList<Board> ALB_ID = new ArrayList<Board>();
		
		head_P = New_Post.Super_Post;
		int SiID = 0;
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if ((head_P.Writer).equals(Search_in_ID)) {
				ALB_ID.add(head_P);
				head_P = head_P.Next_Post_Add;
				SiID++;
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		ALB_ID.add(null);
		head_P = New_Post.Super_Post;
		if (SiID != 0) {
			return ALB_ID;
		}
		else if (SiID == 0) {
			System.out.println(" ");
			System.out.println("===========================");
			System.out.println("해당 회원이 작성한 게시물이 없습니다.");
			System.out.println("===========================");
			System.out.println(" ");
		}
		return null;
	}
	
	public ArrayList<Board> Search_in_title(String Search_in_title) {
		
		ArrayList<Board> ALB_title = new ArrayList<Board>();
		head_P = New_Post.Super_Post;
		int SiID = 0;
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if ((head_P.title).contains(Search_in_title)) {
				ALB_title.add(head_P);
				head_P = head_P.Next_Post_Add;
				SiID++;
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		ALB_title.add(null);
		head_P = New_Post.Super_Post;
		if (SiID != 0) {
			return ALB_title;
		}
		else if (SiID == 0) {
			System.out.println(" ");
			System.out.println("===============================");
			System.out.println("해당 문자가 제목에 포함된 게시물이 없습니다.");
			System.out.println("===============================");
			System.out.println(" ");
		}
		return null;
	}

	public ArrayList<Board> Search_in_Content(String Search_in_content) {

		ArrayList<Board> ALB_content = new ArrayList<Board>();
		int SiID = 0;
		head_P = New_Post.Super_Post;
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if ((head_P.Post_Contents).contains(Search_in_content)) {
				ALB_content.add(head_P);
				head_P = head_P.Next_Post_Add;
				SiID++;
			}
			else {
				head_P = head_P.Next_Post_Add;
			}
		}
		head_P = New_Post.Super_Post;
		ALB_content.add(null);
		head_P = New_Post.Super_Post;
		if (SiID != 0) {
			return ALB_content;
		}
		else if (SiID == 0) {
			System.out.println(" ");
			System.out.println("==========================");
			System.out.println("해당 내용이 포함된 게시물이 없습니다.");
			System.out.println("==========================");
			System.out.println(" ");
		}
		return null;
	}
	
	public void Show_All_ID (int Num, ArrayList<Board> ALB_ID, int page_Num_ID) {
		
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
			if (ALB_ID.get(i + 1) == null) {
				(ALB_ID.get(i)).output_Post((ALB_ID.get(i)));
				System.out.println("댓글(" + (ALB_ID.get(i)).Comment_Num + ")");
				System.out.println("=============================================");
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
			ID_Output_onePost(page_Num_ID);
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
	
	public void ID_Output_onePost(int page_Num_Aux) {
		
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
					Comment_Function(head_P_Aux);
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
}