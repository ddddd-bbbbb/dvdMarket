package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BasketVO;
import model.DvdInfoVO;

public class BasketDAO {
	// 장바구니 목록
	public void getBasketTotalList(String pw) throws Exception {
		String sql = "select b.b_no, d.d_name, d.d_price ,b.b_quantity, b.b_totalprice from basket b inner join dvdinfo d on b.d_no = d.d_no where c_no = ? order by b.b_no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BasketVO bVo = null;
		DvdInfoVO dVo = null;
		CustomerDAO cd = new CustomerDAO();
		int c_no = cd.getCustomerNo(pw);
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();
			System.out.println("장바구니번호\t영화제목\t\t수량\t\t가격");
			while (rs.next()) {
				bVo = new BasketVO();
				dVo = new DvdInfoVO();
				dVo.setD_name(rs.getString("d_name"));
				bVo.setB_no(rs.getInt("b_no"));
				bVo.setB_quantity(rs.getInt("b_quantity"));
				bVo.setB_totalprice(rs.getInt("b_totalprice"));
				System.out.println(bVo.getB_no() + "\t\t" + dVo.getD_name() + "\t\t" + bVo.getB_quantity() + "\t\t"
						+ bVo.getB_totalprice());
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	// dvd를 장바구니에 등록 관리
//	public void setBasketRegiste(BasketVO bvo) throws Exception {
//		String sql = "insert into basket " + "(b_no, b_quantity, b_totalprice, d_no, c_no)" + " values "
//				+ "(bas_seq.nextval, ?, ?, ?, ?)";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, bvo.getB_quantity());
//			pstmt.setInt(2, bvo.getB_totalprice());
//			pstmt.setInt(3, bvo.getD_no());
//			pstmt.setInt(4, bvo.getC_no());
//
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("dvd 등록 성공!!!");
//			} else {
//				System.out.println("dvd 등록 실패!!!");
//			}
//		} catch (SQLException e) {
//			System.out.println("e=[" + e + "]");
//		} catch (Exception e) {
//			System.out.println("e=[" + e + "]");
//		} finally {
//			try {
//				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}
//	}
	// dvd를 장바구니에 등록 관리
	public void setBasketRegiste(BasketVO bvo) throws Exception {
		String sql = "{call insert_basket(bas_seq.nextval,?,?,?)}";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, bvo.getB_quantity());
			//cstmt.setInt(2, bvo.getB_totalprice());
			cstmt.setInt(2, bvo.getD_no());
			cstmt.setInt(3, bvo.getC_no());
			
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println("dvd 등록 성공!!!");
			} else {
				System.out.println("dvd 등록 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 장바구니 수정
//	public boolean setBasketUpdate(BasketVO bvo) throws Exception {
//		String sql = "update basket set b_quantity=?, b_totalprice=? where b_no=?";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		boolean dvdInfoUpdateSucess = false;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, bvo.getB_quantity());
//			pstmt.setInt(2, bvo.getB_totalprice());
//			pstmt.setInt(3, bvo.getB_no());
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("dvd 수정 성공!!!");
//			} else {
//				System.out.println("dvd 수정 실패!!!");
//			}
//		} catch (SQLException e) {
//			System.out.println("e=[" + e + "]");
//		} catch (Exception e) {
//			System.out.println("e=[" + e + "]");
//		} finally {
//			try {
//				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}
//		return dvdInfoUpdateSucess;
//	}
//	
	// 장바구니 수정 프로시져
//	public boolean setBasketUpdate(BasketVO bvo) throws Exception {
//		String sql = "{call update_basket(?,?,?)}";
//		Connection con = null;
//		CallableStatement cstmt = null;
//		boolean dvdInfoUpdateSucess = false;
//		try {
//			con = DBUtil.getConnection();
//			cstmt = con.prepareCall(sql);
//			cstmt.setInt(1, bvo.getB_quantity());
//			cstmt.setInt(2, bvo.getB_totalprice());
//			cstmt.setInt(3, bvo.getB_no());
//			int i = cstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("dvd 수정 성공!!!");
//			} else {
//				System.out.println("dvd 수정 실패!!!");
//			}
//		} catch (SQLException e) {
//			System.out.println("e=[" + e + "]");
//		} catch (Exception e) {
//			System.out.println("e=[" + e + "]");
//		} finally {
//			try {
//				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
//				if (cstmt != null)
//					cstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}
//		return dvdInfoUpdateSucess;
//	}

	// 장바구니 dvd 삭제
//	public void setBasketDelete(int b_no) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete from basket where b_no = ?");
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setInt(1, b_no);
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("dvd 삭제 완료.");
//			} else {
//				System.out.println("dvd 삭제 실패!!!");
//			}
//		} catch (SQLException e) {
//			System.out.println("e=[" + e + "]");
//		} catch (Exception e) {
//			System.out.println("e=[" + e + "]");
//		} finally {
//			try {
//				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}
//	}
	// 장바구니 dvd 삭제 프로시져하기시져
	public void setBasketDelete(int b_no) throws Exception {
		String sql = "{call delete_cus_basket(?)}";
		//StringBuffer sql = new StringBuffer();
		//sql.append("delete from basket where b_no = ?");
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql.toString());
			cstmt.setInt(1, b_no);
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println("dvd 삭제 완료.");
			} else {
				System.out.println("dvd 삭제 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

}
