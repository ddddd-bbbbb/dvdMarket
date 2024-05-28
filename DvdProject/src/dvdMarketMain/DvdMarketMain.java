package dvdMarketMain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import controller.BasketDAO;
import controller.BasketManager;
import controller.CustomerManager;
import controller.DBUtil;
import controller.DvdInfoManager;
import view.ADMIN_CHOICE;
import view.CUSADMIN_CHOICE;
import view.CUSTOMER_CHOICE;
import view.DVDADMIN_CHOICE;
import view.MENU_CHOICE;
import view.MYINFO_CHOICE;
import view.MenuViewer;
import view.PURCHASE_CHOICE;

public class DvdMarketMain {

	public static void main(String[] args) {
		mainMenu();

	}

	public static void mainMenu() {
		CustomerManager cm = new CustomerManager();
		int selectNum;

		while (true) {
			try {
				MenuViewer.mainMenuView();
				selectNum = MenuViewer.choice.nextInt();
				MenuViewer.choice.nextLine();
				switch (selectNum) {
				case MENU_CHOICE.REGISTER:
					cm.customerRegistr();
					break;
				case MENU_CHOICE.LOGIN:
					loginMenu();
					break;
				case MENU_CHOICE.ADMIN:
					adminMenu();
					break;

				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");

				return;
			}
		}
	}

	public static void cusAdminMenu() throws Exception {
		CustomerManager cm = new CustomerManager();

		int choice;
		MenuViewer.customerAdminMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case CUSADMIN_CHOICE.CUSLIST:
			System.out.println("");
			cm.customerList();
			break;
		case CUSADMIN_CHOICE.CUSINSERT:
			System.out.println("");
			cm.customerAdminRegistr();
			break;
		case CUSADMIN_CHOICE.CUSUPDATE:
			System.out.println("");
			cm.customerUpdate();
			break;
		case CUSADMIN_CHOICE.CUSREMOVE:
			System.out.println("");
			cm.customerDelete();
			break;
		case CUSADMIN_CHOICE.MENU:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	public static void dvdAdminMenu() throws Exception {
		DvdInfoManager dm = new DvdInfoManager();
		int choice;
		MenuViewer.dvdAdminMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case DVDADMIN_CHOICE.DVDLIST:
			System.out.println("");
			dm.dvdList();
			break;
		case DVDADMIN_CHOICE.DVDINSERT:
			System.out.println("");
			dm.dvdRegistr();
			break;
		case DVDADMIN_CHOICE.DVDUPDATE:
			System.out.println("");
			dm.dvdInfoUpdate();
			break;
		case DVDADMIN_CHOICE.DVDREMOVE:
			System.out.println("");
			dm.dvdInfoDelete();
			break;
		case DVDADMIN_CHOICE.MENU:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	// customer menu
	public static void customerMenuView() throws Exception {
		BasketManager bm = new BasketManager();
		int choice;
		MenuViewer.customerMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case CUSTOMER_CHOICE.PURCHASE:
			System.out.println("");
			bm.basketRegistr();
			break;
		case CUSTOMER_CHOICE.BASKET:
			System.out.println("");
			purchaseMenu();
			break;
		case CUSTOMER_CHOICE.MYINFO:
			System.out.println("");
			myInfoMenu();
			break;
		case CUSTOMER_CHOICE.MENU:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	// myinfo menu
	public static void myInfoMenu() throws Exception {
		int choice;
		CustomerManager cm = new CustomerManager();
		MenuViewer.myinfoMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case MYINFO_CHOICE.INFO:
			System.out.println("");
			cm.myinfoRegistr();
			break;
		case MYINFO_CHOICE.UPDATE:
			System.out.println("");
			cm.myInfoUpdate();
			break;
		case MYINFO_CHOICE.DROP:
			System.out.println("");
			cm.myInfoDelete();
			break;
		case MYINFO_CHOICE.MENU:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	// purchase menu
	private static void purchaseMenu() throws Exception {
		BasketManager bm = new BasketManager();

		int choice;
		MenuViewer.purchaseMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case PURCHASE_CHOICE.PURCHASELIST:
			System.out.println("");
			purchaseList();
			break;
		case PURCHASE_CHOICE.PURCHASEREMOVE:
			System.out.println("");
			bm.basketDelete();
			break;
		case PURCHASE_CHOICE.MENU:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	public static void purchaseList() throws Exception {
		BasketDAO bd = new BasketDAO();
		String pw = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호를 입력해주세요");
		pw = sc.nextLine();
		bd.getBasketTotalList(pw);
	}

	// 로그인
	public static void loginMenu() {
		System.out.println("아이디와 비밀번호를 입력하세요");
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");
		String c_id = sc.nextLine();

		System.out.print("패스워드 : ");
		String c_pd = sc.nextLine();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			BasketManager bm = new BasketManager();
			int choice = 0;
			con = DBUtil.getConnection();
			String sql = "select c_name from customer where c_id = ? and c_passwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_id);
			pstmt.setString(2, c_pd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("c_name");
				System.out.println(name + "님 환영합니다.");
				while (true) {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, c_id);
					pstmt.setString(2, c_pd);
					rs = pstmt.executeQuery();
					if (!rs.next())
						return;
					try {
						MenuViewer.customerMenuView();
						choice = MenuViewer.choice.nextInt();
						MenuViewer.choice.nextLine();
						switch (choice) {
						case CUSTOMER_CHOICE.PURCHASE:
							System.out.println("");
							bm.basketRegistr();
							break;
						case CUSTOMER_CHOICE.BASKET:
							System.out.println("");
							purchaseMenu();
							break;
						case CUSTOMER_CHOICE.MYINFO:
							System.out.println("");
							myInfoMenu();
							break;
						case CUSTOMER_CHOICE.MENU:
							return;
						default:
							System.out.println("해당 메뉴 번호만 입력하세요.");
						}
					} catch (Exception e) {
						System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");

						return;
					}

				} // end of while
			} else {
				System.out.println("로그인에 실패했습니다.");
				System.out.println("종료합니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("rs, pstmt, con close error");
				e.printStackTrace();
			}
		}
	}

	// 관리자 로그인 가져오기
	public static void adminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("관리자 정보를 입력하세요");
		System.out.print("아이디 : ");
		String adminId = sc.nextLine();

		System.out.print("패스워드 : ");
		String adminPW = sc.nextLine();

		// 어드민정보 파일불러오기

		String filePath = "/Users/riakim/Desktop/java_labs3/DvdProject/src/controller/admin.properties";
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(filePath));
			String _adminid = properties.getProperty("id");
			String _adminpw = properties.getProperty("pw");

			if (adminId.equals(_adminid) && adminPW.equals(_adminpw)) {
				System.out.println("로그인 성공");
				while (true) {
					try {
						int choice;
						MenuViewer.adminMenuView();
						choice = MenuViewer.choice.nextInt();
						MenuViewer.choice.nextLine();
						switch (choice) {
						case ADMIN_CHOICE.DVDLIST:
							System.out.println("");
							dvdAdminMenu();
							break;
						case ADMIN_CHOICE.CUSLIST:
							System.out.println("");
							cusAdminMenu();
							break;
						case ADMIN_CHOICE.MENU:
							return;
						default:
							System.out.println("해당 메뉴 번호만 입력하세요.");
						}
					} catch (Exception e) {
						System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");

						return;
					}

				} // end of while
			} else {
				System.out.println("관리자 로그인 실패");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
