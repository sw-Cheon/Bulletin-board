package Bulletin_Board_2;

import java.util.*;

public class Searching_Menu extends Bull_Board_mng {
	
	int page_Aux = 0;
	int Aux_3 = 0;
	int page_Aux_D = 0;
	int Aux_3_D = 0;
	int wT = New_Post.NP_Num;
	
	public void Searching_Menu() {

		Board head_P_Aux = null;
		Board head_P = New_Post.Super_Post;
		Search_with_Contains SwC = new Search_with_Contains();
		Page_Num_Count PNC_2 = new Page_Num_Count();
		ArrayList<Board> ALB_ID = null;
		ArrayList<Board> ALB_title = null;
		ArrayList<Board> ALB_content = null;
		int Order_2 = 0;
		
		int Bool = 0;
		
		while (Bool == 0) {
			
			System.out.println(" ");
			System.out.println("===============================");
			System.out.println("1. ID로 게시물 검색");
			System.out.println("2. 제목으로 게시물 검색");
			System.out.println("3. 내용으로 게시물 검색");
			System.out.println("4. 작성자ID기준 오름차순으로 게시물 보기");
			System.out.println("5. 작성자ID기준 내림차순으로 게시물 보기");
			System.out.println("exit. 검색메뉴 종료");
			System.out.println("===============================");
			System.out.println("이용하실 메뉴의 번호를 입력해주세요.");
			System.out.printf("%s", "> ");
			
			Scanner sc30 = new Scanner(System.in);
			String Order_SM = sc30.next();
			
			switch (Order_SM) {
			
				case "1" :
					System.out.println(" ");
					System.out.println("검색을 원하시는 ID를 입력해주세요.");
					System.out.printf("%s", "> ");
					Scanner sc31 = new Scanner(System.in);
					String Search_in_ID = sc31.next();
					
					ALB_ID = SwC.Search_in_ID(Search_in_ID);
					if (ALB_ID == null) {
						break;
					}
					Aux_3 = 0;
					Output_Aux = 0;
					while (true) {
						SwC.Show_All_ID(Output_Aux, ALB_ID, PNC_2.Page_num_count_ID(ALB_ID));
						if (Output_Aux == -1) {
							break;
						}
					}
					break;
				
				case "2" :
					System.out.println(" ");
					System.out.println("검색을 원하시는 제목을 입력해주세요.");
					System.out.printf("%s", "> ");
					Scanner sc32 = new Scanner(System.in);
					String Search_in_title = sc32.nextLine();
					
					ALB_title = SwC.Search_in_title(Search_in_title);
					if (ALB_title == null) {
						break;
					}
					Aux_3 = 0;
					Output_Aux = 0;
					while (true) {
						SwC.Show_All_ID(Output_Aux, ALB_title, PNC_2.Page_num_count_ID(ALB_title));
						if (Output_Aux == -1) {
							break;
						}
					}
					break;
					
				case "3" :
					System.out.println(" ");
					System.out.println("검색을 원하시는 내용을 입력해주세요.");
					System.out.printf("%s", "> ");
					Scanner sc33 = new Scanner(System.in);
					String Search_in_content = sc33.nextLine();
					
					ALB_content = SwC.Search_in_Content(Search_in_content);
					if (ALB_content == null) {
						break;
					}
					Aux_3 = 0;
					Output_Aux = 0;
					while (true) {
						SwC.Show_All_ID(Output_Aux, ALB_content, PNC_2.Page_num_count_ID(ALB_content));
						if (Output_Aux == -1) {
							break;
						}
					}
					break;
					
				case "4" :
					Aux_3 = 0;
					Output_Aux = 0;
					while (true) {
						S_Show_All(Output_Aux);
						if (Output_Aux == -1) {
							break;
						}
					}
					break;
					
				case "5" :
					Aux_3_D = 0;
					Output_Aux_D = 0;
					while (true) {
						SD_Show_All(New_Post.NP_Num);
						if (Output_Aux_D == -1) {
							break;
						}
					}
					break;
					
				case "exit" :
					System.out.println(" ");
					System.out.println("=================");
					System.out.println("게시판메뉴로 돌아갑니다.");
					System.out.println("=================");
					System.out.println(" ");
					Bool = 1;
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
	
	public int HashSet_return_Num() {
		
		Board head_P = New_Post.Super_Post;
		
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < New_Post.NP_Num; i++) {
			hs.add(head_P.Writer);
			head_P = head_P.Next_Post_Add;
		}
		
		int k = 0;
		Iterator<String> hs_i = hs.iterator();
		while (hs_i.hasNext()) {
			hs_i.next();
			k++;
		}
		return k;
	}
	
	public void S_Show_All(int Num) {
		
		Asc_Desc_ArrayList ADA = new Asc_Desc_ArrayList();
		ArrayList<Board> Sorted_Board = ADA.Sort_Board_return();
		
		int kT = 0;
		Num = Output_Aux * 4;
		if (Output_Aux != 0) {
			for (int i = 0; i < Num; i++) {
				kT = i + 1;
			}
		}
		Num = kT;
		int SiID_4 = 0;
		System.out.println("\n");
		for(int i = Num; i < Num + 4; i++) {
			if (i == New_Post.NP_Num - 1) { 
				(Sorted_Board.get(i)).output_Post((Sorted_Board.get(i)));
				System.out.println("댓글(" + (Sorted_Board.get(i)).Comment_Num + ")");
				System.out.println("=============================================");
				SiID_4++;
				break;
			}
			else {
				(Sorted_Board.get(i)).output_Post((Sorted_Board.get(i)));
				System.out.println("댓글(" + (Sorted_Board.get(i)).Comment_Num + ")");
				System.out.println("=============================================");
				SiID_4++;
			}
		}
		if (SiID_4 != 0) {
			S_Output_onePost();
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
	
	public void S_Output_onePost() {
		
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
			int Page_Num = PNC.Page_num_count();
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
	
	public void SD_Show_All(int Num) {
		
		int kT = Num;
		
		Asc_Desc_ArrayList ADA = new Asc_Desc_ArrayList();
		ArrayList<Board> Sorted_Board = ADA.Sort_Board_return();
		
		int SiID_4 = 0;
		int kT_Aux = Output_Aux_D * 4;
		if (Output_Aux_D != 0) {
			for (int i = Num - 1; i >= Num - kT_Aux; i--) {
				kT = i + 1;
			}
			Num = kT - 1;
		}
		System.out.println("\n");
		for(int i = Num - 1; i >= Num - 4; i--) {
			if (i == 0) {
				(Sorted_Board.get(i)).output_Post((Sorted_Board.get(i)));
				SiID_4++;
				break;
			}
			else {
				(Sorted_Board.get(i)).output_Post((Sorted_Board.get(i)));
				System.out.println("댓글(" + (Sorted_Board.get(i)).Comment_Num + ")");
				System.out.println("=============================================");
				SiID_4++;
			}
		}
		if (SiID_4 != 0) {
			SD_Output_onePost();
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

	public void SD_Output_onePost() {
		
		if (q != 1) {
			q = 0;
		}
		while (q == 0) {
			
			System.out.println("게시물 보기 : v, 메인화면으로 이동 : x");
			System.out.println("다음페이지 : >, 이전페이지 : <, 다음메뉴 : >>, 이전메뉴 : <<");
			System.out.println("페이지 숫자로 입력 : n");
			System.out.printf("%s", "============= 페이지 번호 : ");
			
			if (Aux_3_D % 3 == 0) {
				page_Aux_D = Aux_3_D / 3;
			}
			else {
				page_Aux_D = Aux_3_D / 3;
			}
			int page = (page_Aux_D) * 3;
			int Page_Num = PNC.Page_num_count();
			for (int i = page; i < page + 3; i++) {    // 중요조건
				if (i + 1 == Page_Num) {
					if (Output_Aux_D == i) {
						System.out.printf("%c", '*');
					}
					System.out.printf("%d ", i + 1);
					break;
				}
				else {
					if (Output_Aux_D == i) {
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
					Output_Aux_D = -1;
					Aux_3_D = 0;
					page_Aux_D = 0;
					break;
					
				case ">" :
					int Last_Page = PNC.Page_num_count();
					if (Last_Page - 1 == Output_Aux_D) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("마지막 페이지 입니다.");
						System.out.println("===============");
						System.out.println(" ");
					}
					else {
						Output_Aux_D++;
						Aux_3_D++;
					}
					q = 1;
					break;
					
				case ">>" :
					int Last_Page_2 = PNC.Page_num_count();
					if (Last_Page_2 - 1 == Output_Aux_D) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("마지막 페이지 입니다.");
						System.out.println("===============");
						System.out.println(" ");
					}
					else if (Output_Aux_D + 1 == Last_Page_2 - 1) {
						Output_Aux_D = Output_Aux_D + 1;
						Aux_3_D = Aux_3_D + 1;
						page_Aux_D = Aux_3_D / 3;
					}
					else if (Output_Aux_D + 2 == Last_Page_2 - 1) {
						Output_Aux_D = Output_Aux_D + 2;
						Aux_3_D = Aux_3_D + 2;
						page_Aux_D = Aux_3_D / 3;
					}
					else {
						Output_Aux_D = Output_Aux_D + 3;
						Aux_3_D = Aux_3_D + 3;
						page_Aux_D = Aux_3_D / 3;
					}
					q = 1;
					break;
					
				case "<" :
					if (Output_Aux_D == 0) {
						System.out.println(" ");
						System.out.println("=============");
						System.out.println("첫 페이지 입니다.");
						System.out.println("=============");
						System.out.println(" ");
					}
					else {
						Output_Aux_D--;
						if (Aux_3_D == 3) {     // 중요조건
							page_Aux_D = 0;
						}
						Aux_3_D--;
					}
					q = 1;
					break;
					
				case "<<" :
					Output_Aux_D = Output_Aux_D - 3;
					if (Aux_3_D == 3) {
						page_Aux_D = 0;
					}
					Aux_3_D = Aux_3_D - 3;
					if (Output_Aux_D <= 0) {
						Output_Aux_D = 0;
						page_Aux_D = 0;
						Aux_3_D = 0;
						System.out.println(" ");
						System.out.println("=============");
						System.out.println("첫 페이지 입니다.");
						System.out.println("=============");
						System.out.println(" ");
					}
					else if (Output_Aux_D < 3) {
						page_Aux_D = 0;
					}
					q = 1;
					break;
					
				case "x" :
					Output_Aux_D = -1;
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
									Output_Aux_D = Search_Num - 1;
									Aux_3_D = Search_Num - 1;
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