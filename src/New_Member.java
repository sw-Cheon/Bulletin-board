package Bulletin_Board_2;

import java.util.Scanner;

public class New_Member extends Member {
	
	static Member Super_head = null;
	static Member Super_last = null;
	static String Logged_in = null;
	static String Logged_in_PW = null;
	static int M_Super_Last_Aux = 0;
	static int M_Super_Last_Aux_2 = 0;
	static int NM_Num = 0;
	static int Nod_NUM = 0;
	static int DN = 0;
	int Bool = 0;
	int m = 0;
	String PW_1_Aux = null;
	int try_catch_Aux = 0;
	int Info4_Aux = 0;
	
	String Info2 = null;
	String Info3 = null;
	Member first = null;
	Member head = null;
	Member last = null;
	
	public void New_Member() {
		System.out.println(" ");
		System.out.println("====================");
		System.out.println("회원가입 메뉴로 이동합니다.");
		System.out.println("====================");
		System.out.println(" ");
		System.out.println("회원님의 이름을 입력해주세요");
		System.out.printf("%c", '>');
		System.out.printf("%c", ' ');
		Scanner sc2 = new Scanner(System.in);
		String Info1 = sc2.next();
		
		while(m == 0) {
			System.out.println("사용을 원하시는 ID을 입력해주세요");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner sc3 = new Scanner(System.in);
			String ID_ident = sc3.next();
			
			if (NM_Num == 0) {
				Info2 = ID_ident;
				m = 1;
				break;
			}
			else {
				int m_Aux = 0;
				head = Super_head;
				for (int i = 0; i < NM_Num; i++) {
					if (ID_ident.equals(head.ID)) {
						System.out.println(" ");
						System.out.println("======================");
						System.out.println("해당 아이디는 이미 존재합니다.");
						System.out.println("======================");
						System.out.println(" ");
						m_Aux = 1;
						break;
					}
					else {
						head = head.Next_Add;
					}
				}
				if (m_Aux == 0) {
					Info2 = ID_ident;
					head = Super_head;
					m = 1;
					break;
				}
			}
		}
		
		m = 0;
		
		while (m == 0) {
			while(true) {	
				System.out.println("PW를 입력해주세요(PW는 8자리 이상으로 입력해주세요)");
				System.out.printf("%c", '>');
				System.out.printf("%c", ' ');
				Scanner sc4 = new Scanner(System.in);
				String PW_1 = sc4.next();
				PW_1_Aux = PW_1;
				
				if (PW_1.length() >= 8) {
					break;
				}
				
				else {
					System.out.println(" ");
					System.out.println("=======================================");
					System.out.println("PW가 8자리 이하로 입력되었습니다. 다시 입력해주세요.");
					System.out.println("=======================================");
					System.out.println(" ");
				}
			}
			
			System.out.println("PW를 한번 더 입력해주세요");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner sc6 = new Scanner(System.in);
			String PW_2 = sc6.next();
			
			if (PW_1_Aux.equals(PW_2)) {
				Info3 = PW_1_Aux;
				m = 1;
			}
			
			else {
				System.out.println(" ");
				System.out.println("==============================================");
				System.out.println("처음 입력하신 PW와 일치하지 않습니다. PW를 다시 입력해주세요.");
				System.out.println("==============================================");
				System.out.println(" ");
			}
		}
		
		m = 0;
		while(try_catch_Aux == 0) {
			try {
				System.out.println("회원님의 나이를 입력해주세요");
				System.out.printf("%c", '>');
				System.out.printf("%c", ' ');
				Scanner sc5 = new Scanner(System.in);
				int Info4 = sc5.nextInt();
				Info4_Aux = Info4;
				try_catch_Aux = 1;
			} catch (Exception e) {
				System.out.println(" ");
				System.out.println("======================");
				System.out.println("나이에는 숫자만 입력가능합니다.");
				System.out.println("======================");
				System.out.println(" ");
			}
		}
		try_catch_Aux = 0;
		
		Member NM = new Member();
		NM_Num++;
		
		if (NM_Num == 1) {
			DN++;
			NM.D_Num_M = DN;
			first = NM;
			head = NM;
			Super_head = NM;
			last = NM;
			last.Next_Add = null;
			first.AddMember(Info1, Info2, Info3, Info4_Aux);
			System.out.println(" ");
			System.out.println("=====================");
			System.out.println("회원이 되신 것을 축하합니다!");
			System.out.println("=====================");
			System.out.println(" ");
			Nod_NUM++;
		}
		
		else {
			if (M_Super_Last_Aux == 1) {
				last = Super_last;
			}
			if (M_Super_Last_Aux_2 == 1) {
				last = Super_last;
			}
			M_Super_Last_Aux = 0;
			M_Super_Last_Aux_2 = 0;
			if (Board_Class.Abs_Member == 1) {   // Test_Data
				last = Super_last;               // Test_Data
			}									 // Test_Data
			last.Next_Add = NM;
			last = NM;
			Super_last = NM;
			DN++;
			NM.D_Num_M = DN;
			last.AddMember(Info1, Info2, Info3, Info4_Aux);
			last.Next_Add = null;
			System.out.println(" ");
			System.out.println("=====================");
			System.out.println("회원이 되신 것을 축하합니다!");
			System.out.println("=====================");
			System.out.println(" ");
			Nod_NUM++;
		}
	}
	
	public Member return_head() {
		return Super_head;
	}
	
	public String return_head_ID() {
		return Logged_in;
	}
	
	public String return_head_PW() {
		return Logged_in_PW;
	}
}