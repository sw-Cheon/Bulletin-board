package Bulletin_Board_2;

import java.util.*;

public class Log_in extends New_Member {
	
	public void Log_in() {
		
		New_Member nod2 = new New_Member();
		
		Member head = nod2.return_head();
		Member first = nod2.return_head();
		
		String ID_Aux = null;
		
		System.out.println(" ");
		System.out.println("====================");
		System.out.println("로그인 메뉴로 이동합니다.");
		System.out.println("====================");
		System.out.println(" ");
		
		int p = 0;
		
		while (p == 0) {
			System.out.println("==============");
			System.out.println("ID를 입력해주세요");
			System.out.println("==============");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner login1 = new Scanner(System.in);
			String ID_Compare = login1.next();
			ID_Aux = ID_Compare;
			
			while (true) {
				if (ID_Compare.equals(head.ID)) {
					p = 1;
					break;
				}
				
				else if (head.Next_Add == null) {
					System.out.println(" ");
					System.out.println("=================================");
					System.out.println("해당 ID가 없습니다. ID를 다시 확인해주세요.");
					System.out.println("=================================");
					System.out.println(" ");
					head = Super_head;
					break;
				}
				
				else {
					head = head.Next_Add;
				}
			}
		}
		
		int k = 0;
		
		while (k == 0) {	
			System.out.println("==============");
			System.out.println("PW를 입력해주세요");
			System.out.println("==============");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner login2 = new Scanner(System.in);
			String PW_Compare = login2.next();
			
			while (true) {
				if ((head.PW).equals(PW_Compare)) {
					System.out.println(" ");
					System.out.println("====================================");
					System.out.println("Login 되었습니다. 반갑습니다. " + head.Name + "님");
					System.out.println("====================================");
					System.out.println(" ");
					Logged_in = head.ID;
					Logged_in_PW = head.PW;
					k = 1;
					head = Super_head;
					break;
				}
				else {
					System.out.println(" ");
					System.out.println("===============================");
					System.out.println("PW가 틀렸습니다. PW를 다시 확인해주세요.");
					System.out.println("===============================");
					System.out.println(" ");
					k = 2;
					break;
				}
			}
		}
		
		if (k == 1) {
			Member_Menu MM = new Member_Menu();
			MM.Member_Menu();
		}
		
		k = 0;
		ID_Aux = null;
		head = first;		
	}
}