package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import dao.SkillDAO;
import model.Skill;

public class Main
{
	public static List<Skill> listall=new ArrayList<Skill>();
	public static void main(String args[]) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the total number of records");
		int total=Integer.parseInt(br.readLine());
		long id=0; String name=null;
		SkillDAO skilldao=new SkillDAO();
		for(int i=0;i<total;i++)
		{
			System.out.print("Enter the id of "+" "+i+"st:");
			id=Long.parseLong(br.readLine());
			System.out.print("Enter the name of "+" "+i+"st:");
			name=br.readLine();
			Skill s=new Skill(id,name);
			skilldao.setdetails(s);
		}
		listall=skilldao.skills();
		//Comparator<Skill> compareByName=(Skill o1,Skill o2)-> o1.getSkillname().compareTo(o2.getSkillname());
	    //Collections.sort(listall,compareByName);
		for(Skill s:listall)
		{
			System.out.println(s.getSkillid()+" "+s.getSkillname());
		}
		
		/*for(int i=0;i<listall.size();i++)
		{
			 System.out.println(listall.get(i).getSkillid()+" "+listall.get(i).getSkillname());
		}*/
		
		
		
	}
}
