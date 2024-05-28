package controller;

import java.util.Scanner;

import model.BasketVO;
import model.DvdInfoVO;

public class BasketManager {
//	// 장바구니 목록
//	public void basketList() throws Exception {
//		BasketDAO bd = new BasketDAO();
//		BasketVO bvo = new BasketVO();
//		System.out.println("내 장바구니 리스트");
//		bd.getBasketTotalList();
//		System.out.println();
//	}

	// dvd를 장바구니에 등록 관리 --dvd구매하
	public void basketRegistr() throws Exception {

		Scanner input = new Scanner(System.in);
		DvdInfoManager dm = new DvdInfoManager();
		DvdInfoVO dvo = new DvdInfoVO();
		BasketDAO bd = new BasketDAO();
		BasketVO bvo = new BasketVO();
		CustomerDAO cd = new CustomerDAO();

		int b_quantity; // 장바구니 수량
		int b_totalprice; // 장바구니 전체 가격
		int d_no; // dvd 일련번호
		String d_name; // 제목
		String d_director; // 과목
		String d_category; // 카테고리
		int d_year; // 년도
		String d_description; // 설명
		int d_price; // 가격
		String c_name; // 고객 이름
		int c_phone; // 고객번호
		String c_address; // 고객 주소
		String c_id; // 고객 id
		String c_passwd; // 고객 passwd
		int c_no;
		System.out.print("비밀번호를 입력 :");
		c_passwd = input.nextLine();
		dm.dvdList();
		System.out.println("등록할 dvd 일련번호 입력");
		d_no = input.nextInt();
		input.nextLine();
		System.out.println();
		System.out.print("dvd 수량 : ");
		b_quantity = input.nextInt();
		input.nextLine();
		c_no = cd.getCustomerNo(c_passwd);
		bvo.setC_no(c_no);
		bvo.setD_no(d_no);
		bvo.setB_quantity(b_quantity);
		bd.setBasketRegiste(bvo);
		System.out.println();
		System.out.println("장바구니 리스트");
		bd.getBasketTotalList(c_passwd);
		System.out.println();
	}

	// 장바구니 수정 관리
//	public void basketUpdate() throws Exception {
//		Scanner input = new Scanner(System.in);
//		Scanner input1 = new Scanner(System.in);
//		BasketDAO bd = new BasketDAO();
//		BasketVO bvo = new BasketVO();
//
//		int b_no; // 장바구니 일련번호
//		int b_quantity; // 장바구니 수량
//		int b_totalprice; // 장바구니 전체 가격
//		int d_no; // dvd 일련번호
//		String d_name; // 제목
//		String d_director; // 과목
//		String d_category; // 카테고리
//		int d_year; // 년도
//		String d_description; // 설명
//		int d_price; // 가격
//		String pw;
//		System.out.println("비밀번호 입력");
//		pw = input.nextLine();
//		
//		System.out.println("장바구니 전체 리스트");
//		bd.getBasketTotalList(pw);
//		System.out.println();
//		System.out.println("수정할 장바구니 dvd 일련번호 입력");
//		System.out.print("일련번호 : ");
//		d_no = input1.nextInt();
//		System.out.println();
//		System.out.print("dvd 수량 변경 : ");
//		b_quantity = input.nextInt();
//		input.nextLine();
//		bvo.setB_quantity(b_quantity);
//		bd.setBasketUpdate(bvo);
//		System.out.println();
//		System.out.println("장바구니 전체 리스트");
//		bd.getBasketTotalList(pw);
//		System.out.println();
//	}

	// 장바구니 삭제 관리
	public void basketDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		BasketDAO bd = new BasketDAO();
		BasketVO bvo = new BasketVO();
		int b_no; // 삭제할 장바구니 dvd 번호
		String pw;
		System.out.println("비밀번호 입력");
		pw = input.nextLine();
		System.out.println("장바구니 dvd 전체 리스트");
		bd.getBasketTotalList(pw);
		System.out.println();
		System.out.println("삭제할 장바구니 번호 입력");
		System.out.print("장바구니 번호 : ");
		b_no = input.nextInt();
		input.nextLine();
		bd.setBasketDelete(b_no);
		System.out.println();
		System.out.println("장바구니 전체 리스트");
		bd.getBasketTotalList(pw);
		System.out.println();
	}
	
	//개인 장바구니 확인
}
