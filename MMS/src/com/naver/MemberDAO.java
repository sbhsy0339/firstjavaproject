package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    //oracle.jdbc.OracleDrive
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private final String USERNAME = "ca2";
	
	private final String PASSWORD = "ca2";
	
    public MemberDAO() {
		// TODO Auto-generated constructor stub
    	try {
			Class.forName(DRIVERNAME);
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void delete(String id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "update tbl_member where id = ?";
    	
    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
    }
    
    
    public void update(MemberDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "update tbl_member set name = ?, age = ? where id = ?";
    	
    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(3, dto.getId());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(1, dto.getName());
			
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    }
    
    
    public List<MemberDTO> selectAll(){
    	List<MemberDTO> list = new ArrayList<MemberDTO>();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "select * from tbl_member";
    	ResultSet rs = null;
    	
    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			int age = rs.getInt(3);
			
			MemberDTO dto = new MemberDTO(id, name, age);
			
			list.add(dto);
			
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				

				if(conn != null) {
				   conn.close();
					}
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
    }
    
    
    public void insert(MemberDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "insert into tbl_member (id, name, age) values (?,?,?)";
    	
    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
    }
}
