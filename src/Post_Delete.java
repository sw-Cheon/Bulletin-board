package Bulletin_Board_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Post_Delete extends New_Post {
	
	ArrayList<Board> ALB_Delete = null;
	int Output_Aux = 0;
	int q = 0;
	int Aux_3 = 0;
	int page_Aux = 0;
	
	public void Post_delete() {
		
		Output_Aux = 0;
		q = 0;
		Aux_3 = 0;
		page_Aux = 0;
		Page_Num_Count PNC = new Page_Num_Count();
		int DP_Num_PD = 0;
		
		Member head = New_Member.Super_head;
		for (int i = 0; i < New_Member.NM_Num; i++) {
			if ((head.ID).equals(Log_in.Logged_in)) {
				DP_Num_PD = head.D_Num_M;
			}
			else {
				head = head.Next_Add;
			}
		}
		head = New_Member.Super_head;
		
		ALB_Delete = Search_in_Delete(DP_Num_PD);
		if (ALB_Delete != null) {
			Output_Aux = 0;
			while (true) {
				Show_All_Delete(Output_Aux, ALB_Delete, PNC.Page_num_count_ID(ALB_Delete), DP_Num_PD);
				if (Output_Aux == -1) {
					break;
				}
			}
		}
	}
	
	public ArrayList<Board> Search_in_Delete(int DP_Num_PD) {
		
		ArrayList<Board> ALB_ID = new ArrayList<Board>();
		
		head_P = New_Post.Super_Post;
		int SiID = 0;
		for(int i = 0; i < New_Post.NP_Num; i++) {
			if ((head_P.Writer).equals(Log_in.Logged_in)) {
				if (head_P.D_Num_P == DP_Num_PD) {
					ALB_ID.add(head_P);
					head_P = head_P.Next_Post_Add;
					SiID++;
				}
				else {
					head_P = head_P.Next_Post_Add;
				}
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
			System.out.println("========================");
			System.out.println("ȸ������ �ۼ��� �Խù��� �����ϴ�.");
			System.out.println("========================");
			System.out.println(" ");
		}
		return null;
	}
	
	public void Show_All_Delete (int Num, ArrayList<Board> ALB_ID, int page_Num_ID, int DP_Num_PD) {
		
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
			if (ALB_ID.get(i) == null) {
				SiID_4++;
				break;
			}
			else {
				(ALB_ID.get(i)).output_Post((ALB_ID.get(i)));
				System.out.println("���(" + (ALB_ID.get(i)).Comment_Num + ")");
				System.out.println("=============================================");
				SiID_4++;
			}
		}
		if (SiID_4 != 0) {
			Delete_Output_onePost(page_Num_ID, DP_Num_PD);
		}
		if (SiID_4 == 0) {
			System.out.println(" ");
			System.out.println("=================");
			System.out.println("���� �Խù��� �����ϴ�.");
			System.out.println("=================");
			System.out.println(" ");
			Output_Aux = -1;
		}
	}
	
	public void Delete_Output_onePost(int page_Num_Aux, int DP_Num_PD) {
		
		Related_Post_Com_Del RPCD = new Related_Post_Com_Del();
		int page_Num_ID = page_Num_Aux;
		int Bool_ADM = 0;
		int CD = 0;
//		int Case_Aux_3 = 0;
		int delete_Post = 0;
		int while_Aux = 0;
		
		if (q != 1) {
			q = 0;
		}
		while (q == 0) {
			
			System.out.println("�Խù� ���� : d, ����ȭ������ �̵� : x");
			System.out.println("���������� : >, ���������� : <, �����޴� : >>, �����޴� : <<");
			System.out.println("������ ���ڷ� �Է� : n");
			System.out.printf("%s", "============= ������ ��ȣ : ");
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
				case "d" :
					int delete_Aux = 0;
					int try_catch_7 = 0;
					
					while(delete_Aux == 0) {
						try_catch_7 = 0;
						while_Aux = 0;
						while (try_catch_7 == 0) {
							try {
								System.out.println(" ");
								System.out.println("������ ���Ͻô� �Խ��� ��ȣ�� �Է����ּ���.");
								System.out.printf("%c", '>');
								System.out.printf("%c", ' ');
								Scanner DP = new Scanner(System.in);
								int delete_Post_Aux = DP.nextInt();
								delete_Post = delete_Post_Aux;
								try_catch_7 = 1;
							} catch (Exception e) {
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("�߸��� ��ɾ��Դϴ�. �ٽ� Ȯ�����ּ���.");
								System.out.println("=============================");
								System.out.println(" ");
							}
						}
						
						while (while_Aux == 0) {
							if (head_P.Present_P_Num == delete_Post) {
								if ((head_P.Writer).equals(Log_in.Logged_in)) {
									if (head_P.D_Num_P == DP_Num_PD) {	
										delete_Aux = 1;
										break;
									}
								}
								else {
									System.out.println(" ");
									System.out.println("===============================");
									System.out.println("ȸ������ �ۼ��� �Խù��� ������ �� �ֽ��ϴ�.");
									System.out.println("===============================");
									System.out.println(" ");
									while_Aux = 1;
									try_catch_7 = 0;
									head_P = Super_Post;
									break;
								}
							}
							else if (head_P.Next_Post_Add == null) {
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("�ش� ��ȣ�� �Խù��� �������� �ʽ��ϴ�.");
								System.out.println("=============================");
								System.out.println(" ");
								while_Aux = 1;
								try_catch_7 = 0;
								head_P = Super_Post;
								break;
							}
							else {
								head_P = head_P.Next_Post_Add;
							}
						}
						head_P = Super_Post;
					}
					
					if (true) {
						System.out.println("���� �����Ͻðڽ��ϱ�?");
						System.out.printf("%s", "y/n >");
						System.out.printf("%c", ' ');
						
						Scanner Con = new Scanner(System.in);
						String Confirm_delete = Con.next();
						
						switch (Confirm_delete) {
							case "y":
								CD = 0;
								RPCD.Related_Post_Com_del(delete_Post);
								break;
							case "n":
								CD = 1;
								q = 1;
								Output_Aux = -1;
								System.out.println(" ");
								System.out.println("=================");
								System.out.println("���θ޴��� ���ư��ϴ�.");
								System.out.println("=================");
								System.out.println(" ");
								break;
							default :
								CD = 1;
								q = 1;
								Output_Aux = -1;
								System.out.println(" ");
								System.out.println("=============================");
								System.out.println("�߸��� ��ɾ��Դϴ�. �ٽ� �õ����ּ���.");
								System.out.println("=============================");
								System.out.println(" ");
								break;
						}
						
						while (CD == 0) {
							if (head_P.Present_P_Num == delete_Post && NP_Num > 2) {
								head_P = head_P.Next_Post_Add;
								Super_Post = head_P;
								NP_Num--;
								System.out.println(" ");
								System.out.println("=================");
								System.out.println("�Խù��� �����Ǿ����ϴ�.");
								System.out.println("=================");
								System.out.println(" ");
								break;
							}
							
							else if(head_P.Present_P_Num == delete_Post && NP_Num == 1) {
								head_P = null;
								Super_Post = head_P;
								Super_Last_Post = head_P;
								System.out.println(" ");
								System.out.println("=================");
								System.out.println("�Խù��� �����Ǿ����ϴ�.");
								System.out.println("=================");
								System.out.println(" ");
								Bool_ADM = 1;
								NP_Num--;
								break;
							}
							
							else if ((head_P.Next_Post_Add).Present_P_Num == delete_Post && NP_Num > 2) {
								if ((head_P.Next_Post_Add).Next_Post_Add == null) {
									Super_Last_Post = head_P;
									Super_Last_Post_Aux = 1;
								}
								head_P.Next_Post_Add = (head_P.Next_Post_Add).Next_Post_Add;
								head_P = Super_Post;
								NP_Num--;
								System.out.println(" ");
								System.out.println("=================");
								System.out.println("�Խù��� �����Ǿ����ϴ�.");
								System.out.println("=================");
								System.out.println(" ");
								break;
							}
							
							else if (head_P.Next_Post_Add != null && NP_Num > 2) {
								head_P = head_P.Next_Post_Add;
							}
							
							else if (head_P.Present_P_Num == delete_Post && NP_Num == 2) {
								head_P = head_P.Next_Post_Add;
								Super_Post = head_P;
								NP_Num--;
								System.out.println(" ");
								System.out.println("=================");
								System.out.println("�Խù��� �����Ǿ����ϴ�.");
								System.out.println("=================");
								System.out.println(" ");
								break;
							}
							
							else if ((head_P.Next_Post_Add).Present_P_Num == delete_Post && NP_Num == 2) {
								head_P.Next_Post_Add = null;
								Super_Last_Post = head_P;
								Super_Last_Post_Aux_2 = 1;
								NP_Num--;
								System.out.println(" ");
								System.out.println("=================");
								System.out.println("�Խù��� �����Ǿ����ϴ�.");
								System.out.println("=================");
								System.out.println(" ");
								break;
							}
						}
						if (CD == 0) {
							if (Bool_ADM == 0)
								head_P = Super_Post;
							Bool_ADM = 0;
						}
					}
					head_P = New_Post.Super_Post;
					int k2 = 1;
					while (k2 <= New_Post.NP_Num) {
						head_P.Present_P_Num = k2;
						head_P = head_P.Next_Post_Add;
						k2++;
					}
					Output_Aux = -1;
					q = 1;
					break;
					
				case ">" :
					int Last_Page = page_Num_ID;
					if (Last_Page - 1 == Output_Aux) {
						System.out.println(" ");
						System.out.println("===============");
						System.out.println("������ ������ �Դϴ�.");
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
						System.out.println("������ ������ �Դϴ�.");
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
						System.out.println("ù ������ �Դϴ�.");
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
						System.out.println("ù ������ �Դϴ�.");
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
								System.out.println("�̵��� ���Ͻô� �������� ��ȣ�� �Է����ּ���.");
								System.out.printf("%c", '>');
								System.out.printf("%c", ' ');
								Scanner sc37 = new Scanner(System.in);
								int Search_Num = sc37.nextInt();
								if (Search_Num < 1 || Search_Num > page_Num_ID) {
									System.out.println(" ");
									System.out.println("===================");
									System.out.println("�Խù� ��ȣ�� Ȯ�����ּ���.");
									System.out.println("===================");
									System.out.println(" ");
								}
								else if (Output_Aux + 1 == Search_Num) {
									System.out.println(" ");
									System.out.println("===============");
									System.out.println("���� �������Դϴ�.");
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
								System.out.println("�߸��� ��ɾ��Դϴ�.");
								System.out.println("===============");
								System.out.println(" ");
							}	
						}
					}
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
		head_P = New_Post.Super_Post;
		q = 0;
	}
}