package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	public static List<Skill> listall=new ArrayList<Skill>();
	public  Skill setdetails(Skill s) throws ClassNotFoundException, SQLException
	{
		Connection con=ConnectionManager.getConnection();
		if(con!=null)
		System.out.println("established");
		String sql="insert into player1 values(?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setLong(1,s.getSkillid());
		st.setString(2, s.getSkillname());
		st.executeUpdate();
		st.close();
		return s;
		
	}
	public List<Skill> skills() throws ClassNotFoundException, SQLException
	{
		Connection con=ConnectionManager.getConnection();
		if(con!=null)
		System.out.println("established");
		String sql="select * from player1 order by name asc";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Long id=rs.getLong(1);
			String name=rs.getString(2);
			Skill s=new Skill(id,name);
			listall.add(s);
		}
		return listall;
		
	}
}