package Bulletin_Board_2;

import java.util.*;

public class Member_Menu extends New_Member {

	public void Member_Menu() {
		
		Member head = Super_head;		
		int Bool = 0;
		int All = 0;
		int All_Aux = 0;
		String MM_vari_Aux = null;
		
		Bull_Board_mng BBM = new Bull_Board_mng();
		
		while (Bool == 0) {
			All = 0;
			All_Aux = 0;
			System.out.println("===============");
			System.out.println("1. 회원정보수정");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 게시판메뉴");
			System.out.println("exit. 로그아웃");
			System.out.println("===============");
			
			System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
			Scanner sc9 = new Scanner(System.in);
			String MM_vari = sc9.next();
			MM_vari_Aux = MM_vari;
			
			while (All == 0) {
				
				switch (MM_vari) {
				
					case "1" :
						System.out.println(" ");
						System.out.println("==========================");
						System.out.println("회원정보수정 메뉴로 이동합니다.");
						System.out.println("==========================");
						System.out.println(" ");
						
						int k2 = 0;
						
						while (k2 == 0) {
							System.out.println("===============================");
							System.out.println("본인확인을 위해 PW를 한 번더 입력해주세요."); 
							System.out.println("===============================");
							System.out.printf("%c", '>');
							System.out.printf("%c", ' ');
							Scanner pp = new Scanner(System.in);
							String Identify_ID = pp.next();
							
							while(true) {
								if((Logged_in_PW).equals(Identify_ID)) {
									k2 = 1;
									break;
								}
								
								else if(head.Next_Add == null) {
									System.out.println(" ");
									System.out.println("=======================");
									System.out.println("PW가 틀립니다 다시 입력해주세요.");
									System.out.println("=======================");
									System.out.println(" ");
									All_Aux = 1;
									k2 = 1;
									break;
								}
								
								else {
									head = head.Next_Add;
								}
							}
							head = Super_head;
							
						}
						
						if (All_Aux == 1) {
							All = 1;
							break;
						}
						
						int k = 0;
						
						while (k == 0) {
							System.out.println(" ");
							System.out.println("=============================");
							System.out.println("수정을 원하시는 항목의 번호 입력해주세요");
							System.out.println("=============================");
							System.out.println(" ");
							System.out.println("=======");
							System.out.println("1. 이름");
							System.out.println("2. PW");
							System.out.println("3. 나이");
							System.out.println("=======");
							System.out.println(" ");
							
							Scanner sc10 = new Scanner(System.in);
							String Modify_Info_Aux = sc10.next();
							
							switch (Modify_Info_Aux) {
							
								case "1":
									while(true) {
										String Modify_Info_Name = null;
										while(true) {
											System.out.println("====================");
											System.out.println("수정하실 이름을 입력해주세요.");
											System.out.println("====================");
											System.out.printf("%c", '>');
											System.out.printf("%c", ' ');
											Scanner sc11 = new Scanner(System.in);
											String Modify_Info_Name_Aux = sc11.next();
											System.out.println("====================");
											System.out.println("이름을 한번 더 입력해주세요.");
											System.out.println("====================");
											System.out.printf("%c", '>');
											System.out.printf("%c", ' ');
											Scanner sc14 = new Scanner(System.in);
											String Modify_Info_Name_Aux2 = sc14.next();
											if (Modify_Info_Name_Aux.equals(Modify_Info_Name_Aux2)) {
												Modify_Info_Name = Modify_Info_Name_Aux2;
												break;
											}
											else {
												System.out.println(" ");
												System.out.println("============================");
												System.out.println("입력하신 이름이 일치하지 않습니다.");
												System.out.println("============================");
												System.out.println(" ");
											}
										}
										while (true) {
											if ((head.ID).equals(Logged_in))
												break;
											else {
												head = head.Next_Add;
											}
										}
										head.Name = Modify_Info_Name;
										System.out.println(" ");
										head.output_Members(head);
										System.out.println("=============================================");
										System.out.println(" ");
										System.out.println(" ");
										head = Super_head;
										break;
									}
									k = 1;
									break;
									
								case "2":
									while(true) {
										String Modify_Info_PW = null;
										while(true) {
											System.out.println("====================");
											System.out.println("수정하실 PW를 입력해주세요.");
											System.out.println("====================");
											System.out.printf("%c", '>');
											System.out.printf("%c", ' ');
											Scanner sc13 = new Scanner(System.in);
											String Modify_Info_PW_Aux = sc13.next();
											System.out.println("====================");
											System.out.println("PW를 한번 더 입력해주세요.");
											System.out.println("====================");
											System.out.printf("%c", '>');
											System.out.printf("%c", ' ');
											Scanner sc12 = new Scanner(System.in);
											String Modify_Info_PW_Aux2 = sc12.next();
											if (Modify_Info_PW_Aux.equals(Modify_Info_PW_Aux2)) {
												Modify_Info_PW = Modify_Info_PW_Aux2;
												break;
											}
											else {
												System.out.println(" ");
												System.out.println("============================");
												System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
												System.out.println("============================");
												System.out.println(" ");
											}
										}
										while (true) {
											if ((head.ID).equals(Logged_in))
												break;
											else {
												head = head.Next_Add;
											}
										}
										head.PW = Modify_Info_PW;
										System.out.println(" ");
										head.output_Members(head);
										System.out.println("=============================================");
										System.out.println(" ");
										System.out.println(" ");
										head = Super_head;
										break;
									}
									k = 1;
									break;
									
								case "3" :
									while(true) {
										int Modify_Info_age = 0;
										while(true) {
											System.out.println("====================");
											System.out.println("수정하실 나이를 입력해주세요.");
											System.out.println("====================");
											System.out.printf("%c", '>');
											System.out.printf("%c", ' ');
											Scanner sc15 = new Scanner(System.in);
											int Modify_Info_age_Aux = sc15.nextInt();
											System.out.println("====================");
											System.out.println("나이를 한번 더 입력해주세요.");
											System.out.println("====================");
											System.out.printf("%c", '>');
											System.out.printf("%c", ' ');
											Scanner sc16 = new Scanner(System.in);
											int Modify_Info_age_Aux2 = sc16.nextInt();
											if (Modify_Info_age_Aux == Modify_Info_age_Aux2) {
												Modify_Info_age = Modify_Info_age_Aux2;
												break;
											}
											else {
												System.out.println(" ");
												System.out.println("============================");
												System.out.println("입력하신 나이가 일치하지 않습니다.");
												System.out.println("============================");
												System.out.println(" ");
											}
										}
										while (true) {
											if ((head.ID).equals(Logged_in))
												break;
											else {
												head = head.Next_Add;
											}
										}
										head.age = Modify_Info_age;
										System.out.println(" ");
										head.output_Members(head);
										System.out.println("=============================================");
										System.out.println(" ");
										System.out.println(" ");
										head = Super_head;
										break;
									}
									k = 1;
									break;
							}
						}
						break;
						
					case "2" :
						
						int Nod_NUM_Del = 0;
						int Bool_ADM = 0;
						int CD = 0;
						
						System.out.println("탈퇴하시면 서운행 삉.. 정말 탈퇴하시겠습니까?");
						System.out.printf("%s", "y/n >");
						System.out.printf("%c", ' ');
						
						Scanner Con_MM = new Scanner(System.in);
						String Confirm_delete = Con_MM.next();
						
						switch (Confirm_delete) {
							case "y":
								CD = 0;
								break;
								
							case "n":
								CD = 1;
								System.out.println(" ");
								System.out.println("===========================");
								System.out.println("데헷 회원탈퇴 안됐쪙>_< 고마슴니다♥");
								System.out.println("===========================");
								System.out.println(" ");
								break;
								
							default :
								CD = 1;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("잘못된 명령어입니다. 다시 시도해주세요.");
								System.out.println("=============================");
								System.out.println(" ");
								break;
						}
						
						while (CD == 0) {
							if ((head.ID).equals(Logged_in) && Nod_NUM > 2) {
								head = head.Next_Add;
								Super_head = head;
								NM_Num--;
								Nod_NUM--;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("탈퇴되었습니다. 이용해주셔서 감사합니다.");
								System.out.println("=============================");
								System.out.println(" ");
								break;
							}
							
							else if((head.ID).equals(Logged_in) && Nod_NUM == 1) {
								head = null;
								Super_head = head;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("탈퇴되었습니다. 이용해주셔서 감사합니다.");
								System.out.println("=============================");
								System.out.println(" ");
								Bool_ADM = 1;
								NM_Num--;
								Nod_NUM--;
								break;
							}
							
							else if (((head.Next_Add).ID).equals(Logged_in) && Nod_NUM > 2) {
								if ((head.Next_Add).Next_Add == null) {
									Super_last = head;
									M_Super_Last_Aux = 1;
								}
								head.Next_Add = (head.Next_Add).Next_Add;
								head = Super_head;
								NM_Num--;
								Nod_NUM--;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("탈퇴되었습니다. 이용해주셔서 감사합니다.");
								System.out.println("=============================");
								System.out.println(" ");
								break;
							}
							
							else if (head.Next_Add != null && Nod_NUM > 2) {
								head = head.Next_Add;
								Nod_NUM_Del++;
							}
							
							else if ((head.ID).equals(Logged_in) && Nod_NUM == 2) {
								head = head.Next_Add;
								Super_head = head;
								NM_Num--;
								Nod_NUM--;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("탈퇴되었습니다. 이용해주셔서 감사합니다.");
								System.out.println("=============================");
								System.out.println(" ");
								break;
							}
							
							else if (((head.Next_Add).ID).equals(Logged_in) && Nod_NUM == 2) {
								head.Next_Add = null;
								NM_Num--;
								Nod_NUM--;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("탈퇴되었습니다. 이용해주셔서 감사합니다.");
								System.out.println("=============================");
								System.out.println(" ");
								break;
							}
						}
						if (CD == 0) {
							if (Bool_ADM == 0)
								head = Super_head;
							Bool = 1;
							Nod_NUM_Del--;
							Bool_ADM = 0;
						}
						break;
						
					case "3" :
						BBM.Bull_Board_mng();
						break;
					
					case "exit" :
						System.out.println(" ");
						System.out.println("==============");
						System.out.println("로그아웃되었습니다.");
						System.out.println("==============");
						System.out.println(" ");
						Bool = 1;
						Logged_in = null;
						Logged_in_PW = null;
						break;
						
					default :
						System.out.println(" ");
						System.out.println("==============");
						System.out.println("잘못된 명령어입니다.");
						System.out.println("==============");
						System.out.println(" ");
						break;
				}
			break;
			}
		}
	}
}