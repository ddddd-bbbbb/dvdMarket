package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import model.CustomerVO;

public class CustomerDAO {
	// 고객 목록
	public void getCustomerTotalList() throws Exception {
		String sql = "select * from customer_view order by c_no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVO cVo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t이름\t번호\t\t주소\tid\tpasswd\t구매여부");
			while (rs.next()) {
				cVo = new CustomerVO();
				cVo.setC_no(rs.getInt("c_no"));
				cVo.setC_name(rs.getString("c_name"));
				cVo.setC_phone(rs.getInt("c_phone"));
				cVo.setC_address(rs.getString("c_address"));
				cVo.setC_id(rs.getString("c_id"));
				cVo.setC_passwd(rs.getString("c_passwd"));
				System.out.println(cVo.getC_no() + "\t" + cVo.getC_name() + "\t" + cVo.getC_phone() + "\t\t"
						+ cVo.getC_address() + "\t" + cVo.getC_id() + "\t" + cVo.getC_passwd()+"\t"+rs.getString("bh"));
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

	// 내 정보 보기
	public void getmyinfoRegistr(String pwd) throws Exception {
		String sql = "select * from customer where c_passwd = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		CustomerVO cVo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			rs = pstmt.executeQuery();
			System.out.println("이름\t번호\t주소");
			while (rs.next()) {
				cVo = new CustomerVO();
				cVo.setC_name(rs.getString("c_name"));
				cVo.setC_phone(rs.getInt("c_phone"));
				cVo.setC_address(rs.getString("c_address"));
				System.out.println(cVo.getC_name() + "\t" + cVo.getC_phone() + "\t" + cVo.getC_address() + "\t");
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
	// 내 정보 수정

	// 고객 정보 등록
//	public void setCustomerRegiste(CustomerVO cvo) throws Exception {
//		String sql = "insert into customer " + "(c_no, c_name, c_phone, c_address, c_id, c_passwd)" + " values "
//				+ "(cus_seq.nextval, ?, ?, ?, ?, ?)";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, cvo.getC_name());
//			pstmt.setInt(2, cvo.getC_phone());
//			pstmt.setString(3, cvo.getC_address());
//			pstmt.setString(4, cvo.getC_id());
//			pstmt.setString(5, cvo.getC_passwd());
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println(cvo.getC_name() + " 고객 등록 완료.");
//				System.out.println("고객 등록 성공!!!");
//			} else {
//				System.out.println("고객 등록 실패!!!");
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

	// 회원등록
	public static void setCustomerRegiste(CustomerVO cvo) {
		String sql = "{call insert_customer(cus_seq.nextval,?,?,?,?,?)} ";
		Connection con = null;
		CallableStatement cstmt = null; // CallableStatement
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			// 입력 매개변수 설정
			cstmt.setString(1, cvo.getC_name());
			cstmt.setInt(2, cvo.getC_phone());
			cstmt.setString(3, cvo.getC_address());
			cstmt.setString(4, cvo.getC_id());
			cstmt.setString(5, cvo.getC_passwd());
			// 프로시저 실행
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println(cvo.getC_name() + " 고객 등록 완료.");
				System.out.println("고객 등록 성공!!!");
			} else {
				System.out.println("고객 등록 실패!!!");
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

	// 내 정보 삭제/ 회원 탈퇴
	// 회원 삭제
//	public void setMyInfoDelete(String c_passwd) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete from customer where c_passwd = ?");
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, c_passwd);
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("탈퇴 완료.");
//			} else {
//				System.out.println("탈퇴 실패!!!");
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
	
	// 내 정보 삭제/ 회원 탈퇴
	// 회원 삭제 프로시저
	public void setMyInfoDelete(String c_passwd) throws Exception {
		String sql = "{call delete_customer(?)} ";
		//StringBuffer sql = new StringBuffer();
		//sql.append("delete from customer where c_passwd = ?");
		
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql.toString());
			cstmt.setString(1, c_passwd);
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println("탈퇴 완료.");
			} else {
				System.out.println("탈퇴 실패!!!");
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

	// 고객 정보 수정
//	public boolean setCustomerUpdate(String pw, CustomerVO cvo) throws Exception {
//		String sql = "update customer set c_name=?, c_phone=?, c_address=? where c_no=?";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		boolean customerUpdateSucess = false;
//		CustomerDAO cd = new CustomerDAO();
//		int c_no = Integer.parseInt(cd.getCustomerNo(pw));
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, cvo.getC_name());
//			pstmt.setInt(2, cvo.getC_phone());
//			pstmt.setString(3, cvo.getC_address());
//			pstmt.setInt(4, c_no);
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println(cvo.getC_name() + " 고객 수정 완료.");
//				System.out.println("고객 수정 성공!!!");
//			} else {
//				System.out.println("고객 수정 실패!!!");
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
//		return customerUpdateSucess;
//	}
//	
	// 고객 정보 수정프로시져
	public void setCustomerUpdate(String pw, CustomerVO cvo) throws Exception {
		String sql = "{call update_customer(?,?,?,?,?)} ";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, cvo.getC_name());
			cstmt.setInt(2, cvo.getC_phone());
			cstmt.setString(3, cvo.getC_address());
			cstmt.setString(4, pw);
			cstmt.registerOutParameter(5, Types.NUMERIC);
			cstmt.executeUpdate();
			
			if (cstmt.getInt(5) == 1) {
				System.out.println(cvo.getC_name() + " 고객 수정 완료.");
				System.out.println("고객 수정 성공!!!");
			} else {
				System.out.println("고객 수정 실패!!!");
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

	// 고객 정보 수정 -- 어드민
//	public boolean setCustomerAdminUpdate(CustomerVO cvo) throws Exception {
//		String sql = "update customer set c_name=?, c_phone=?, c_address=?, c_id = ?, c_passwd = ? where c_no=?";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		boolean customerUpdateSucess = false;
//		CustomerDAO cd = new CustomerDAO();
//
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, cvo.getC_name());
//			pstmt.setInt(2, cvo.getC_phone());
//			pstmt.setString(3, cvo.getC_address());
//			pstmt.setString(4, cvo.getC_id());
//			pstmt.setString(5, cvo.getC_passwd());
//			pstmt.setInt(6, cvo.getC_no());
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println(cvo.getC_name() + " 고객 수정 완료.");
//				System.out.println("고객 수정 성공!!!");
//			} else {
//				System.out.println("고객 수정 실패!!!");
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
//		return customerUpdateSucess;
//	}
	// 고객 정보 수정 -- 어드민 프로시져
	public boolean setCustomerAdminUpdate(CustomerVO cvo) {
		String sql = "{call update_customer(?,?,?,?,?,0)} ";
		Connection con = null;
		CallableStatement cstmt = null;
		boolean customerUpdateSucess = false;
		CustomerDAO cd = new CustomerDAO();

		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, cvo.getC_name());
			cstmt.setInt(2, cvo.getC_phone());
			cstmt.setString(3, cvo.getC_address());
			cstmt.setString(4, cvo.getC_id());
			cstmt.setString(5, cvo.getC_passwd());
			cstmt.setInt(6, cvo.getC_no());
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println(cvo.getC_name() + " 고객 수정 완료.");
				System.out.println("고객 수정 성공!!!");
			} else {
				System.out.println("고객 수정 실패!!!");
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
		return customerUpdateSucess;
	}

	// 회원 삭제
//	public void setCustomerDelete(int c_no) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete from customer where c_no = ?");
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setInt(1, c_no);
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("고객 삭제 완료.");
//				System.out.println("고객 삭제 성공!!!");
//			} else {
//				System.out.println("고객 삭제 실패!!!");
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
	// 회원 삭제 프로시져
	public void setCustomerDelete(int c_no) throws Exception {
		String sql = "{call delete_cus_admin(?)}";
		//StringBuffer sql = new StringBuffer();
		//sql.append("delete from customer where c_no = ?");
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql.toString());
			cstmt.setInt(1, c_no);
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println("고객 삭제 완료.");
				System.out.println("고객 삭제 성공!!!");
			} else {
				System.out.println("고객 삭제 실패!!!");
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

	// 로그인
//	public boolean getStudentLogin(String id, String pw) throws Exception {
//		String sql = "select * from customer c_id = ? and c_passwd = ?";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean loginSuccess = false;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				loginSuccess = true; // 로그인 성공
//			}
//		} catch (SQLException e) {
//			System.out.println("e=[" + e + "]");
//		} catch (Exception e) {
//			System.out.println("e=[" + e + "]");
//		} finally {
//			try {
//				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}
//		return loginSuccess;
//	}

	// 로그인 프로시져
	public boolean getStudentLogin(String id, String pw) {
		String sql = "{call select_customer(?,?)} ";
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		boolean loginSuccess = false;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.setString(2, pw);
			rs = cstmt.executeQuery();
			if (rs.next()) {
				loginSuccess = true; // 로그인 성공
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return loginSuccess;
	}

//	// 고객 번호 가져오는
//	public String getCustomerNo(String pw) throws Exception {
//		String sql = "select c_no from customer where c_passwd = ?";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String c_no = "";
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, pw);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				c_no = rs.getString("c_no");
//			}
//		} catch (SQLException e) {
//			System.out.println("e=[" + e + "]");
//		} catch (Exception e) {
//			System.out.println("e=[" + e + "]");
//		} finally {
//			try {
//				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
//		}
//		return c_no;
//	}
	// 고객 번호 가져오는 프로시져
	public int getCustomerNo(String pw) throws Exception {
		String sql = "{call get_cus_no(?,?)}";
		Connection con = null;
		CallableStatement cstmt = null;
		int c_no = 0;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, pw);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			c_no = cstmt.getInt(2);
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
		return c_no;
	}

}
