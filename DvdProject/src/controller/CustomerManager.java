package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.CustomerVO;

public class CustomerManager {
	// 고객 목록
	public void customerList() throws Exception {
		CustomerDAO cd = new CustomerDAO();
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
	}

	// 내 정보 보기
	public void myinfoRegistr() throws Exception {
		CustomerDAO cd = new CustomerDAO();
		Scanner input = new Scanner(System.in);
		String c_passwd = null;
		System.out.print("비밀번호를 입력해주세요");
		c_passwd = input.nextLine();
		System.out.println("내 정보");
		cd.getmyinfoRegistr(c_passwd);
	}

	// 내 정보 수정
	public void myInfoUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		int c_no; // 수정할 고객 일련번호
		String c_name; // 고객 이름
		int c_phone; // 고객번호
		String c_address; // 고객 주소
		String c_id; // 고객 id
		String c_passwd; // 고객 passwd
		System.out.print("비밀번호 입력 :");
		c_passwd = input.nextLine();
		System.out.println();
		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("고객 이름 : ");
		c_name = input.nextLine();
		System.out.print("고객 번호 : ");
		c_phone = input.nextInt();
		input.nextLine();
		System.out.print("고객 주소 : ");
		c_address = input.nextLine();
		cvo.setC_name(c_name);
		cvo.setC_phone(c_phone);
		cvo.setC_address(c_address);
		cd.setCustomerUpdate(c_passwd,cvo);
		System.out.println();
		// 본인 정보 리스트
		System.out.println("내 정보");
		cd.getmyinfoRegistr(c_passwd);
		System.out.println();
	}

	// 내 정보 삭제 / 회원탈퇴
	public void myInfoDelete() throws Exception {

		Scanner input = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		String c_passwd;
		myinfoRegistr();
		System.out.print("비밀번호 입력 :");
		c_passwd = input.nextLine();
		System.out.println();
		
		System.out.println();
		cd.setMyInfoDelete(c_passwd);
		System.out.println();
	}

	// 고객 등록 관리 (회원 가입) -- 관리자
	public void customerAdminRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		String c_name; // 고객 이름
		int c_phone; // 고객번호
		String c_address; // 고객 주소
		String c_id; // 고객 id
		String c_passwd; // 고객 passwd
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
		System.out.println("고객 정보 입력");
		System.out.print("고객 이름 : ");
		c_name = input.nextLine();
		System.out.print("고객 번호 : ");
		c_phone = input.nextInt();
		input.nextLine();
		System.out.print("고객 주소 : ");
		c_address = input.nextLine();
		System.out.print("고객 id : ");
		c_id = input.nextLine();
		System.out.print("고객 passwd : ");
		c_passwd = input.nextLine();

		cvo.setC_name(c_name);
		cvo.setC_phone(c_phone);
		cvo.setC_address(c_address);
		cvo.setC_id(c_id);
		cvo.setC_passwd(c_passwd);
		cd.setCustomerRegiste(cvo);
		System.out.println();
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
	}
	// 고객 등록 관리 (회원 가입) -- 개인
	public void customerRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		String c_name; // 고객 이름
		int c_phone; // 고객번호
		String c_address; // 고객 주소
		String c_id; // 고객 id
		String c_passwd; // 고객 passwd
		System.out.println();
		System.out.println("고객 정보 입력");
		System.out.print("고객 이름 : ");
		c_name = input.nextLine();
		System.out.print("고객 번호 : ");
		c_phone = input.nextInt();
		input.nextLine();
		System.out.print("고객 주소 : ");
		c_address = input.nextLine();
		System.out.print("고객 id : ");
		c_id = input.nextLine();
		System.out.print("고객 passwd : ");
		c_passwd = input.nextLine();
		
		cvo.setC_name(c_name);
		cvo.setC_phone(c_phone);
		cvo.setC_address(c_address);
		cvo.setC_id(c_id);
		cvo.setC_passwd(c_passwd);
		cd.setCustomerRegiste(cvo);
		System.out.println();
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
	}

	// 고객 수정 관리
	public void customerUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		int c_no; // 수정할 고객 일련번호
		String c_name; // 고객 이름
		int c_phone; // 고객번호
		String c_address; // 고객 주소
		String c_id; // 고객 id
		String c_passwd; // 고객 passwd
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
		System.out.println("수정할 고객 일련번호 입력");
		System.out.print("일련번호 : ");
		c_no = input1.nextInt();
		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("고객 이름 : ");
		c_name = input.nextLine();
		System.out.print("고객 번호 : ");
		c_phone = input.nextInt();
		input.nextLine();
		System.out.print("고객 주소 : ");
		c_address = input.nextLine();
		System.out.print("고객 id : ");
		c_id = input.nextLine();
		System.out.print("고객 passwd : ");
		c_passwd = input.nextLine();
		cvo.setC_no(c_no);
		cvo.setC_name(c_name);
		cvo.setC_phone(c_phone);
		cvo.setC_address(c_address);
		cvo.setC_id(c_id);
		cvo.setC_passwd(c_passwd);
		cd.setCustomerAdminUpdate(cvo);
		System.out.println();
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
	}

	// 고객 삭제 관리
	public void customerDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		int c_no; // 삭제할 고객 번호
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
		System.out.println("삭제할 고객 일련번호 입력");
		System.out.print("일련번호 : ");
		c_no = input.nextInt();
		cd.setCustomerDelete(c_no);
		System.out.println();
		System.out.println("고객 전체 리스트");
		cd.getCustomerTotalList();
		System.out.println();
	}
	
	//
	
}
