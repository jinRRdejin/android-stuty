package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;



/*DriverManager���������û�����������֮�䣬�������ݿ�������֮�䴴������
 * Connection�ӿ� ���ڴ���Statement����
 * Statement�ӿڣ�
 *   execute ִ�о�̬��select��䣬����䷵�ض���������
 *   executeQuery ִ�и�����SQL��䣬���ص�������
 *   executeUpdate ִ�и�����SQL��䣬���Ϊ insert update delete
 *PrepareStatement �̳���Statement
 *  execute ��PrepareStatement������ ִ���κ����͵�SQL���
 *  executeQuery ��PrepareStatement������ ִ�У����ؽ��Ϊ��ѯ�����Result����
 *  executeUpdate ��PrepareStatement������ ִ�У�������inset update delete û�з���ֵ��DDL���
 *  
 */ 
public class JDBCtest {

	//�������ݿ�����
	public static void main(String[] args) {
		JDBCtest jdbc = new JDBCtest();
		jdbc.test();
	}
	public void test(){
		//�������ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("���ݿ��������سɹ�"); 
			 
			 //�������ݿ������
			 String url = "jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			//? ��Ҫ����useSSL=false
			 String user = "root";
			 String password = "mysql";
		
			 try {
				Connection conn = DriverManager.getConnection(url,user,password);
				
				
				String sql = "INSERT INTO person.student (id, name, age, scoer) " +
						"VALUES (4, 'tt', 12, 92); ";
				String sql2 = "insert into person.student values(5,'tt',14,89)";
				String sql3 = "insert into person.student values(?,?,?,?)";
				String sql4 = "select * from person.student";
				String sql5 = "update person.student set age = 33 where id=5";
				String sql6 = "update person.student set name =?,age=?,scoer=? where id =?";
				String sql7 = "delete from person.student where id = 5";
				/*
				 * ��
				 */
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
				
					
					java.sql.PreparedStatement ps =conn.prepareStatement(sql3);
					ps.setInt(1, 6);
					ps.setString(2, "kk");
					ps.setInt(3, 12);
					ps.setInt(4, 78);
					ps.execute();
					
				/*
				 * ��
				 */
				Statement stmt1 = conn.createStatement();
				ResultSet rs = stmt1.executeQuery(sql4);
				int id,age,score;
				String name;
				System.out.println("id\tname\tage\tscore");
				while(rs.next()){
					id = rs.getInt(1);
					name = rs.getString(2);
					age = rs.getInt("age");
					score = rs.getInt("scoer");
					System.out.println(id + "\t"+name+"\t"+ age+"\t" + score);
				}
				 /*
				  * ��
				  */
				Statement stmt2 = conn.createStatement();
				stmt2.executeUpdate(sql5);
				System.out.println("���ݿ��޸ĳɹ�");
				PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(sql6);
				ps1.setString(1, "lili");
				ps1.setInt(2, 27);
				ps1.setInt(3,54);
				ps1.setInt(4,3);
				 int result = ps1.executeUpdate();  
				System.out.println("PreparedStatement �ɹ��޸������ݿ⣺" + result + "��");
				/*
				 * ɾ��
				 */
				stmt.executeUpdate(sql7);
				System.out.println("�ɹ�ɾ��id = 5");
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
