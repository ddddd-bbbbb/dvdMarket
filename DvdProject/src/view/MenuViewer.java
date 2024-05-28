package view;

import java.util.Scanner;

public class MenuViewer {
	public static Scanner choice = new Scanner(System.in);

	// main menu
	public static void mainMenuView() {
		System.out.println();
		System.out.println("DVD MARKET");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 관리자 로그인");
		System.out.println("4. 프로그램 종료");
		System.out.print("번호 선택 : ");
	}

	// customer menu
	public static void customerMenuView() {
		System.out.println();
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. DVD 구매");
		System.out.println("2. 구매 목록/삭제");
		System.out.println("3. 내 정보 관리");
		System.out.println("4. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// purchase menu
	public static void purchaseMenuView() {
		System.out.println();
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 구매 목록 보기");
		System.out.println("2. 구매 목록 삭제");
		System.out.println("3. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// myinfo - 고객용
	public static void myinfoMenuView() {
		System.out.println();
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 내 정보 보기");
		System.out.println("2. 내 정보 수정");
		System.out.println("3. 회원탈퇴 (구매목록 존재시 삭제 불가능)");
		System.out.println("4. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// admin menu
	public static void adminMenuView() {
		System.out.println();
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. DVD 목록/입력/수정/삭제");
		System.out.println("2. 회원 목록/입력/수정/삭제");
		System.out.println("3. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// dvdAdmin menu
	public static void dvdAdminMenuView() {
		System.out.println();
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. DVD 목록");
		System.out.println("2. DVD 입력");
		System.out.println("3. DVD 수정");
		System.out.println("4. DVD 삭제");
		System.out.println("5. 메인메뉴");
		System.out.print("번호 선택 : ");
	}

	// customerAdmin menu
	public static void customerAdminMenuView() {
		System.out.println();
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 회원 목록");
		System.out.println("2. 회원 입력");
		System.out.println("3. 회원 수정");
		System.out.println("4. 회원 삭제 (구매목록 존재시 삭제 불가능)");
		System.out.println("5. 메인메뉴");
		System.out.print("번호 선택 : ");
	}

}
