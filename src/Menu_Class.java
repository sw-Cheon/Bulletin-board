package Bulletin_Board_2;

import java.util.Scanner;

public class Menu_Class extends New_Member {
	
	public void Menu_func() {
		int Bool = 0;
		
		Scanner Sc1 = new Scanner(System.in);
		
		while(Bool == 0) {
			
			System.out.println("===========================");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("exit. myus_wju59카페 이용 종료.");
			System.out.println("===========================");
			
			System.out.println("이용을 원하시는 메뉴의 번호를 입력해주세요.");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			String Order = Sc1.next();
			
			switch(Order) {
			
				case "1":
					New_Member();
					break;
					
				case "2":
					if (NM_Num == 0) {
						System.out.println("현재 회원이 아무도 없습니다.");
						break;
					}
					else {
						Log_in LI = new Log_in();
						LI.Log_in();
					}
					break;
					
				case "admin_pxql@":
					Administrator_Menu Admin = new Administrator_Menu();
					Admin.Administrator();
					break;
					
				case "exit":
					Bool = 1;
					System.out.println(" ");
					System.out.println("==================================");
					System.out.println(" ");
					System.out.println("게시판을 종료합니다. 이용해주셔서 감사합니다.");
					System.out.println(" ");
					System.out.println("==================================");
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
}