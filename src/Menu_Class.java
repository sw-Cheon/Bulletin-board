package Bulletin_Board_2;

import java.util.Scanner;

public class Menu_Class extends New_Member {
	
	public void Menu_func() {
		int Bool = 0;
		
		Scanner Sc1 = new Scanner(System.in);
		
		while(Bool == 0) {
			
			System.out.println("===========================");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("exit. myus_wju59ī�� �̿� ����.");
			System.out.println("===========================");
			
			System.out.println("�̿��� ���Ͻô� �޴��� ��ȣ�� �Է����ּ���.");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			String Order = Sc1.next();
			
			switch(Order) {
			
				case "1":
					New_Member();
					break;
					
				case "2":
					if (NM_Num == 0) {
						System.out.println("���� ȸ���� �ƹ��� �����ϴ�.");
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
					System.out.println("�Խ����� �����մϴ�. �̿����ּż� �����մϴ�.");
					System.out.println(" ");
					System.out.println("==================================");
					System.out.println(" ");
					break;
					
				default :
					System.out.println(" ");
					System.out.println("===============");
					System.out.println("�߸��� ��ɾ��Դϴ�.");
					System.out.println("===============");
					System.out.println(" ");
					break;
			}
		}
	}
}