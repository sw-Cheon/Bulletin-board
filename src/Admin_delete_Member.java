package Bulletin_Board_2;

import java.util.*;

public class Admin_delete_Member extends New_Member {
	
	public void Delete_Member() {
		
		int Bool_ADM = 0;
		int CD = 0;
		String delete_Member_Aux = null;
		
		New_Member nod3 = new New_Member();
		Member head = nod3.return_head();
		Member first = head;
		
		System.out.println(" ");
		for (int i = 0; i < Nod_NUM; i++) {
			head.output_Members(head);
			head = head.Next_Add;
		}
		head = Super_head;
		System.out.println("=============================================");
		System.out.println(" ");
		
		int delete_Aux = 0;
		
		while(delete_Aux == 0) {
			System.out.println(" ");
			System.out.println("������ ���Ͻô� ȸ���� �̸��� �Է����ּ���.");
			System.out.printf("%c", '>');
			System.out.printf("%c", ' ');
			Scanner DM = new Scanner(System.in);
			String delete_Member = DM.next();
			while (true) {
				if ((head.Name).equals(delete_Member)) {
					delete_Aux = 1;
					break;
				}
				else if (head.Next_Add == null) {
					System.out.println("�ش� ȸ���� ������ �������� �ʽ��ϴ�.");
					delete_Aux = 1;
					break;
				}
				else {
					head = head.Next_Add;
				}
			}
			delete_Member_Aux = delete_Member;
			head = Super_head;
		}
		
		System.out.println("���� �����Ͻðڽ��ϱ�?");
		System.out.printf("%s", "y/n >");
		System.out.printf("%c", ' ');
		
		Scanner Con = new Scanner(System.in);
		String Confirm_delete = Con.next();
		
		switch (Confirm_delete) {
			case "y":
				CD = 0;
				break;
			case "n":
				CD = 1;
				System.out.println(" ");
				System.out.println("=================");
				System.out.println("�����ڸ޴��� ���ư��ϴ�.");
				System.out.println("=================");
				System.out.println(" ");
				break;
			default :
				CD = 1;
				System.out.println(" ");
				System.out.println("=============================");
				System.out.println("�߸��� ��ɾ��Դϴ�. �ٽ� �õ����ּ���.");
				System.out.println("=============================");
				System.out.println(" ");
				break;
		}
		
		while (CD == 0) {
			if ((head.Name).equals(delete_Member_Aux) && Nod_NUM > 2) {
				head = head.Next_Add;
				Super_head = head;
				NM_Num--;
				System.out.println(" ");
				System.out.println("=======================================");
				System.out.println("Deer_World ī���� ȸ������Ʈ�Դϴ�.");
				System.out.println("=======================================");
				System.out.println(" ");
				for (int i = 0; i < Nod_NUM - 1; i++) {
					head.output_Members(head);
					head = head.Next_Add;
				}
				head = Super_head;
				System.out.println("=============================================");
				break;
			}
			
			else if((head.Name).equals(delete_Member_Aux) && Nod_NUM == 1) {
				head = null;
				Super_head = head;
				System.out.println(" ");
				System.out.println("=====================");
				System.out.println("���� ȸ���� �ƹ��� �����ϴ�.");
				System.out.println("=====================");
				System.out.println(" ");
				Bool_ADM = 1;
				NM_Num--;
				break;
			}
			
			else if (((head.Next_Add).Name).equals(delete_Member_Aux) && Nod_NUM > 2) {
				if ((head.Next_Add).Next_Add == null) {
					Super_last = head;
					M_Super_Last_Aux = 1;
				}
				head.Next_Add = (head.Next_Add).Next_Add;
				head = Super_head;
				NM_Num--;
				System.out.println(" ");
				System.out.println("=======================================");
				System.out.println("Deer_World ī���� ȸ������Ʈ�Դϴ�.");
				System.out.println("=======================================");
				System.out.println(" ");
				for (int i = 0; i < Nod_NUM - 1; i++) {
					head.output_Members(head);
					head = head.Next_Add;
				}
				head = first;
				System.out.println("=============================================");
				break;
			}
			
			else if (head.Next_Add != null && Nod_NUM > 2) {
				head = head.Next_Add;
			}
			
			else if ((head.Name).equals(delete_Member_Aux) && Nod_NUM == 2) {
				head = head.Next_Add;
				Super_head = head;
				NM_Num--;
				System.out.println(" ");
				System.out.println("=======================================");
				System.out.println("Deer_World ī���� ȸ������Ʈ�Դϴ�.");
				System.out.println("=======================================");
				System.out.println(" ");
				head.output_Members(head);
				System.out.println("=============================================");
				break;
			}
			
			else if ((head.Next_Add).Name.equals(delete_Member_Aux) && Nod_NUM == 2) {
				head.Next_Add = null;
				Super_last = head;
				M_Super_Last_Aux_2 = 1;
				NM_Num--;
				System.out.println(" ");
				System.out.println("=======================================");
				System.out.println("Deer_World ī���� ȸ������Ʈ�Դϴ�.");
				System.out.println("=======================================");
				System.out.println(" ");
				head.output_Members(head);
				System.out.println("=============================================");
				break;
			}
		}
		if (CD == 0) {
			if (Bool_ADM == 0)
				head = Super_head;
			Nod_NUM--;
			Bool_ADM = 0;
		}
	}	
}