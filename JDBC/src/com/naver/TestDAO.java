package com.naver;

import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";
	
    public TestDAO() {
		// TODO Auto-generated constructor stub
	   try {
		Class.forName(DRIVERNAME);
		System.out.println("드라이버 로딩 성공");
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 로딩 실패");
		e.printStackTrace();
		// TODO Auto-generated catch block
	
	}
    }
    
    public void delete(int id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "DELETE from tbl_member where id = ?";
    	try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
					
					
					
			} catch (Exception e2) {
				// TODO: handle exception
			e2.printStackTrace();
			}
			}
		}
    
  
    
    public void update(MemberDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "UPDATE tbl member SET name = ?. age = ? WHERE id = ?";
    	try {
    		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    		System.out.println("connect success");
    		
    		pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setString(1,  dto.getName());
    		pstmt.setInt(2,  dto.getAge());
    		pstmt.setString(3,  dto.getId());
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("컨넥션 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					
				}								
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    }
  
    
    public ResultSet seletAll() {
    	
    	
        List<MemberDTO> list = new ArrayList<MemberDTO>();
    	
    	ResultSet rs = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;

    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("컨넥션 연결 성공");
			String sql = "SELECT id,name 이름. age 나이, from";
			pstmt = conn.prepareStatement(URL);
			public list<MemberDTO> seletWhat(String what, String value) {
				List<MemberDTO> list = new ArrayList<MemberDTO>();
				
			return; 
			
			Connection coon = null;
			
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				finally {
					
				}
				try {
					
				} catch (Exception e2) {
					// TODO: handle exception
					
				}
			}
			}
			
			
			public MemberDTO selectById(String id) {
				MemberDTO dto= null;
				
				Connection conn = null;
				PreparedStatement psmt = null;
				String sql = "select * form tbl_member where id = ?";
				ResultSet rs = null;
				
				try {
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs =  pstmt.executeQuery();
					
					if(rs.next()) {
						String name = rs.getString("name");
						int age = rs.getInt(0);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e) {
						// TODO: handle exception
						
					}
				}
				
				
			
								
				
				
			}		
		rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
			String id = rs.getString("id");
			int age = rs.getInt("age");
			String name = rs.getNString("name");
			MemberDTO dto = new MemberDTO(id, name, age);
			list.add(dto);
		}
		} catch (Exception e) {
			System.out.println("컨넥션 연결 실패");
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				
				if(pstmt != null) {
					pstmt.close();
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
    }
	
    
    public void selectByName(String name) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "select from tbl_member (id, name, age) values (?, ?, ?)";
    	
    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("컨넥션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			 pstmt.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			
			if(conn != null) {
			try {
				if(conn != null) {
					
				}
			}
				
			 catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
    	
		}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void insert(MemberDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "INSERT INTO tbl member (id, name, age) values (?, ?, ?)";
    	
    	try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("컨넥션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			 pstmt.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			
			if(conn != null) {
			try {
				if(conn != null) {
					
				}
			}
				
			 catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
    	
		}
    	
    
    

}

}


