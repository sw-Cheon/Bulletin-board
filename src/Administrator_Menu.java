package Bulletin_Board_2;

import java.util.*;

public class Administrator_Menu extends New_Member {
	
	public void Administrator() {
//		New_Member nod1 = new New_Member();
		
		Member head = Super_head;
		
		System.out.println(" ");
		System.out.println("====================");
		System.out.println("�����ڷ� �α��� �Ǿ����ϴ�.");
		System.out.println("====================");
		
		int k = 0;
		Scanner Sc7 = new Scanner(System.in);
		
		while (k == 0) {
			System.out.println(" ");
			System.out.println("================");
			System.out.println("1. ȸ��������ȸ");
			System.out.println("2. ȸ����������");
			System.out.println("exit. ������ �α׾ƿ�");
			System.out.println("================");
			
			System.out.println("���Ͻô� �޴��� ��ȣ�� �Է����ּ���.");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			String Order_Admin = Sc7.next();
			
			
			switch(Order_Admin) {
			
			case "1":
				System.out.println(" ");
				System.out.println("=============================");
				System.out.println("Deer_World ī���� ȸ������Ʈ�Դϴ�.");
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
					System.out.println("���� ȸ���� �ƹ��� �����ϴ�.");
					System.out.println("====================");
					System.out.println(" ");
					break;
				}
			
			case "exit":
				System.out.println(" ");
				System.out.println("===============");
				System.out.println("���θ޴��� ���ư��ϴ�.");
				System.out.println("===============");
				System.out.println(" ");
				head = Super_head;
				k = 1;
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