package controller;

import java.util.Scanner;

import model.DvdInfoVO;

public class DvdInfoManager {
	// dvd 목록
	public void dvdList() throws Exception {
		DvdInfoDAO dd = new DvdInfoDAO();
		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
	}

	// dvd 등록 관리
	public void dvdRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		DvdInfoDAO dd = new DvdInfoDAO();
		DvdInfoVO dvo = new DvdInfoVO();
		String d_name; // 제목
		String d_director; // 감독
		String d_category; // 카테고리
		int d_year; // 년도
		String d_description; // 설명
		int d_price; // 가격
		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
		System.out.println("dvd 정보 입력");
		System.out.print("dvd 제목 : ");
		d_name = input.nextLine();
		System.out.print("dvd 감독 : ");
		d_director = input.nextLine();
		System.out.print("dvd 카테고리 : ");
		d_category = input.nextLine();
		System.out.print("dvd 년도 : ");
		d_year = input.nextInt();
		input.nextLine();
		System.out.print("dvd 설명 : ");
		d_description = input.nextLine();
		System.out.print("dvd 가격 : ");
		d_price = input.nextInt();

		dvo.setD_name(d_name);
		dvo.setD_director(d_director);
		dvo.setD_category(d_category);
		dvo.setD_year(d_year);
		dvo.setD_description(d_description);
		dvo.setD_price(d_price);
		dd.setDvdInfoRegiste(dvo);
		System.out.println();
		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
	}

	// dvd 수정 관리
	public void dvdInfoUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in); // buffer생략
		DvdInfoDAO dd = new DvdInfoDAO();
		DvdInfoVO dvo = new DvdInfoVO();
		int d_no; // 수정할 dvd 일련번호
		String d_name; // 제목
		String d_director; // 감독
		String d_category; // 카테고리
		int d_year; // 년도
		String d_description; // 설명
		int d_price; // 가격

		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
		System.out.println("수정할 dvd 일련번호 입력");
		System.out.print("일련번호 : ");
		d_no = input1.nextInt();
		System.out.println();
		System.out.println("새로운 정보 모두 입력");

		System.out.print("dvd 제목 : ");
		d_name = input.nextLine();
		System.out.print("dvd 감독 : ");
		d_director = input.nextLine();
		System.out.print("dvd 카테고리 : ");
		d_category = input.nextLine();
		System.out.print("dvd 년도 : ");
		d_year = input.nextInt();
		input.nextLine();
		System.out.print("dvd 설명 : ");
		d_description = input.nextLine();
		System.out.print("dvd 가격 : ");
		d_price = input.nextInt();

		dvo.setD_no(d_no);
		dvo.setD_name(d_name);
		dvo.setD_director(d_director);
		dvo.setD_category(d_category);
		dvo.setD_year(d_year);
		dvo.setD_description(d_description);
		dvo.setD_price(d_price);
		dd.setDvdInfoUpdate(dvo);
		System.out.println();
		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
	}

	// dvd 삭제 관리
	public void dvdInfoDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		DvdInfoDAO dd = new DvdInfoDAO();
		DvdInfoVO dvo = new DvdInfoVO();
		int d_no; // 삭제할 dvd 번호
		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
		System.out.println("삭제할 dvd 일련번호 입력");
		System.out.print("일련번호 : ");
		d_no = input.nextInt();
		dd.setDvdInfoDelete(d_no);
		System.out.println();
		System.out.println("dvd 전체 리스트");
		dd.getDvdInfoTotalList();
		System.out.println();
	}
}
