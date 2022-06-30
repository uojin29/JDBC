package NewJDBC;
import java.sql.*;
import java.util.*;

import javax.swing.JLabel;

public class ConnectMySql {
	static String user_id;
	private static Connection conn; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "12345678";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost/LoginDB";//DBMS접속할 db명
    static ArrayList<String> arr = new ArrayList<String>();
    
	public ConnectMySql() {
		try {
            System.out.println("생성자");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버 로딩 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
	
	public static String name(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select username from userInfo where userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	           	s = rs.getString(1);
	            System.out.println(s + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static void insert(String name, String id, String pw, String n_name, String pnum, int gender) {
		String sql = "INSERT into userInfo values (?,?,?,?,?,?);";
        PreparedStatement pstmt = null;
		
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, id);
            pstmt.setString(3, pw);
            pstmt.setString(4, n_name);
            pstmt.setString(5, pnum);
            pstmt.setInt(6, gender);
            
            System.out.println(name + " " + id + " " + pw + " " + n_name + " " + pnum + " " + gender);
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("Board데이터 삽입 성공!");
            }
            
        } 
        catch (Exception e) {
            System.out.println("Board데이터 삽입 실패!");
        }    
        finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
	}
	
	public static void select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select * from userInfo;";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	            String username = rs.getString(1);
	           	String userid =  rs.getString(2);
	           	String userpw = rs.getString(3);
	        	String nickname = rs.getString(4);
	        	String userpnum = rs.getString(5);
	        	int gender = rs.getInt(6);
	        	arr.add(username + "    " + userid + "    " + userpw + "    " + nickname + "    " + userpnum + "   " + gender);
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
	}
	public static int duplicate(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select count(*) from userInfo WHERE userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        if(rs.next()){
	           	count =  rs.getInt(1);
	        	
	            System.out.println(count + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return count;
	}
	
	public static String login(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select userpw from userInfo where userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        while(rs.next()){
	           	s = rs.getString(1);
	            System.out.println(rs + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static String p_num(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select userpnum from userInfo where userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	           	s = rs.getString(1);
	            System.out.println(s + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static int gender(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int s = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select gender from userInfo where userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	           	s = rs.getInt(1);
	            System.out.println(s + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static void update(String s1, String s2, String s3, String s4) {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "update userInfo Set username = '" + s1 + "', userpw = '" + s2 + "', userpnum = '" + s3 + "'  Where userid = '" + s4 + "';";
		//	update userInfo Set username = 'Yujin', userpw = '1234', userpnum = '010-5660-4525' Where userid = 'abc';
	        stmt = conn.createStatement();
	        stmt.executeUpdate(sql);
	
//	        while(rs.next()){
//	            String username = rs.getString(1);
//	           	String userpw = rs.getString(2);
//	        	String userpnum = rs.getString(3);
//	            System.out.println(username + " " + userpw + " " + userpnum );
//	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
//	            if( rs != null && !rs.isClosed()){
//	                rs.close();
//	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
	}
	public static String id(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select userid from userInfo where userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        while(rs.next()){
	           	s = rs.getString(1);
	            System.out.println(rs + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static String n_name(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select nickname from userInfo where userid='"+ id + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        while(rs.next()){
	           	s = rs.getString(1);
	            System.out.println(rs + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static void delete(String id) {
		String sql = "delete from userInfo where userid = ?;";
        PreparedStatement pstmt = null;
		
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            
            System.out.println(id + " ");
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("Board데이터 삽입 성공!");
            }
            arr.clear();
            
        } 
		catch (Exception e) {
            System.out.println("Board데이터 삽입 실패!");
        }    
        finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
            	
            }
        }
	}
	static void deleteAll() {
		String sql = "delete from userInfo;";
        PreparedStatement pstmt = null;
		
        try {
            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1, id);
            
            //System.out.println(id + " ");
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("Board데이터 삽입 성공!");
            }
            arr.clear();
        } 
		catch (Exception e) {
            System.out.println("Board데이터 삽입 실패!");
        }    
        finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
            	
            }
        }
	}
	public static String searchid(String s1, String s2) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select userid from userInfo where username = '" + s1 + "' && nickname = '" + s2 + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	           	String userid =  rs.getString(1);
	         //  	String userpw = rs.getString(2);
	            System.out.println(userid + " ");
	            s = userid;
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static String searchpw(String s1, String s2) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select userpw from userInfo where username = '" + s1 + "' && nickname = '" + s2 + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	           	String userpw =  rs.getString(1);
	         //  	String userpw = rs.getString(2);
	            System.out.println(userpw + " ");
	            s = userpw;
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return s;
	}
	public static int existAccount(String s1, String s2) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select count(*) from userInfo WHERE username = '"+ s1 + "'&& nickname = '" + s2 +  "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        if(rs.next()){
	           	count =  rs.getInt(1);
	        	
	            System.out.println(count + " ");
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		return count;
	}
}
