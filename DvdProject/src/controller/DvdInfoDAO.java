package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import model.DvdInfoVO;

public class DvdInfoDAO {
	// dvd 목록
	public void getDvdInfoTotalList() throws Exception {
		String sql = "select * from dvdInfo order by d_no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DvdInfoVO dVo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t제목\t감독\t카테고리\t년도\t설명\t가격");
			while (rs.next()) {
				dVo = new DvdInfoVO();
				dVo.setD_no(rs.getInt("d_no"));
				dVo.setD_name(rs.getString("d_name"));
				dVo.setD_director(rs.getString("d_director"));
				dVo.setD_category(rs.getString("d_category"));
				dVo.setD_year(rs.getInt("d_year"));
				dVo.setD_description(rs.getString("d_description"));
				dVo.setD_price(rs.getInt("d_price"));
				System.out.println(
						dVo.getD_no() + "\t" + dVo.getD_name() + "\t" + dVo.getD_director() + "\t" + dVo.getD_category()
								+ "\t" + dVo.getD_year() + "\t" + dVo.getD_description() + "\t" + dVo.getD_price());
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

	// dvd 등록
//	public void setDvdInfoRegiste(DvdInfoVO dvo) throws Exception {
//		String sql = "insert into dvdInfo " + "(d_no, d_name, d_director, d_category, d_year, d_description, d_price)"
//				+ " values " + "(dvd_seq.nextval, ?, ?, ?, ?, ?, ?)";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, dvo.getD_name());
//			pstmt.setString(2, dvo.getD_director());
//			pstmt.setString(3, dvo.getD_category());
//			pstmt.setInt(4, dvo.getD_year());
//			pstmt.setString(5, dvo.getD_description());
//			pstmt.setInt(6, dvo.getD_price());
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println(dvo.getD_name() + " dvd 등록 완료.");
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
	// dvd 등록
	public void setDvdInfoRegiste(DvdInfoVO dvo) throws Exception {
		String sql = "{call insert_dvd(dvd_seq.nextval,?,?,?,?,?,?)}";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, dvo.getD_name());
			cstmt.setString(2, dvo.getD_director());
			cstmt.setString(3, dvo.getD_category());
			cstmt.setInt(4, dvo.getD_year());
			cstmt.setString(5, dvo.getD_description());
			cstmt.setInt(6, dvo.getD_price());
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println(dvo.getD_name() + " dvd 등록 완료.");
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

	// dvd 수정
//	public boolean setDvdInfoUpdate(DvdInfoVO dvo) throws Exception {
//		String sql = "update dvdInfo set d_name=?, d_director=?, d_category=?, d_year=?, d_description=?, d_price=? where d_no=?";
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		boolean dvdInfoUpdateSucess = false;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, dvo.getD_name());
//			pstmt.setString(2, dvo.getD_director());
//			pstmt.setString(3, dvo.getD_category());
//			pstmt.setInt(4, dvo.getD_year());
//			pstmt.setString(5, dvo.getD_description());
//			pstmt.setInt(6, dvo.getD_price());
//			pstmt.setInt(7, dvo.getD_no());
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println(dvo.getD_name() + " dvd 수정 완료.");
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
	//dvd수정 프로시져
	public void setDvdInfoUpdate(DvdInfoVO dvo) {
		
		String sql = "{call update_dvdInfo(?,?,?,?,?,?,?,?)} ";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, dvo.getD_name());
			cstmt.setString(2, dvo.getD_director());
			cstmt.setString(3, dvo.getD_category());
			cstmt.setInt(4, dvo.getD_year());
			cstmt.setString(5, dvo.getD_description());
			cstmt.setInt(6, dvo.getD_price());
			cstmt.setInt(7, dvo.getD_no());
			cstmt.registerOutParameter(8, Types.NUMERIC);
			cstmt.executeUpdate();
			if (cstmt.getInt(8) == 1) {
				System.out.println(dvo.getD_name() + " dvd 수정 완료.");
				System.out.println("dvd 수정 성공!!!");
			} else {
				System.out.println("dvd 수정 실패!!!");
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
	

	// dvd 삭제
//	public void setDvdInfoDelete(int d_no) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete from dvdInfo where d_no = ?");
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setInt(1, d_no);
//			int i = pstmt.executeUpdate();
//			if (i == 1) {
//				System.out.println("dvd 삭제 완료.");
//				System.out.println("dvd 삭제 성공!!!");
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
	// dvd 삭제
	public void setDvdInfoDelete(int d_no) {
		//StringBuffer sql = new StringBuffer();
		//sql.append("delete from dvdInfo where d_no = ?");
		String sql = "{call delete_dvd(?)} ";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.getConnection();
			cstmt = con.prepareCall(sql.toString());
			cstmt.setInt(1, d_no);
			int i = cstmt.executeUpdate();
			if (i == 1) {
				System.out.println("dvd 삭제 완료.");
				System.out.println("dvd 삭제 성공!!!");
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
