package Bulletin_Board_2;

import java.util.*;

public class Administrator_Menu extends New_Member {
	
	public void Administrator() {
//		New_Member nod1 = new New_Member();
		
		Member head = Super_head;
		
		System.out.println(" ");
		System.out.println("====================");
		System.out.println("관리자로 로그인 되었습니다.");
		System.out.println("====================");
		
		int k = 0;
		Scanner Sc7 = new Scanner(System.in);
		
		while (k == 0) {
			System.out.println(" ");
			System.out.println("================");
			System.out.println("1. 회원정보조회");
			System.out.println("2. 회원정보삭제");
			System.out.println("exit. 관리자 로그아웃");
			System.out.println("================");
			
			System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			String Order_Admin = Sc7.next();
			
			
			switch(Order_Admin) {
			
			case "1":
				System.out.println(" ");
				System.out.println("=============================");
				System.out.println("Deer_World 카페의 회원리스트입니다.");
				System.out.println("=============================");
				System.out.println(" ");
				
				head = Super_head;
				for (int i = 0; i < Nod_NUM; i++) {
					head.output_Members(head);
					head = head.Next_Add;
				}
				System.out.println("===================================================");
				head = Super_head;
				break;
				
			case "2":
				if (NM_Num > 0) {
					Admin_delete_Member ADM = new Admin_delete_Member();
					ADM.Delete_Member();
					break;
				}
				else {
					System.out.println(" ");
					System.out.println("====================");
					System.out.println("현재 회원이 아무도 없습니다.");
					System.out.println("====================");
					System.out.println(" ");
					break;
				}
			
			case "exit":
				System.out.println(" ");
				System.out.println("===============");
				System.out.println("메인메뉴로 돌아갑니다.");
				System.out.println("===============");
				System.out.println(" ");
				head = Super_head;
				k = 1;
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