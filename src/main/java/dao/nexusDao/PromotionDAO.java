package dao.nexusDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Promotion;
import util.DatabaseConnection;

public class PromotionDAO {
	public void savePromotion(Promotion P)
	{
		try
		{
			Connection conn=DatabaseConnection.getConnection();
			String q="insert into Promotion(designation_from,designation_to,"
					+ "promotion_date,user_id) values"
					+ "('"+P.getDesignation_from()+"',"
					+ "'"+P.getDesignation_to()+"','"+P.getPromotion_date()+"',"
							+ "'"+P.getUser_id()+"')";
			PreparedStatement ps=conn.prepareStatement(q);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Promotion> fetchPromotions()
	{
		List<Promotion> prolist=new ArrayList<Promotion>();	//empty list 
		try
		{
			Connection conn=DatabaseConnection.getConnection();
			String q="select * from Promotion inner join users on Promotion.user_id=users.user_id where status='active'";
			PreparedStatement ps=conn.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			prolist.add(new Promotion(
					rs.getInt("promotion_id"),
					rs.getString("designation_from"),
					rs.getString("designation_to"),
					rs.getString("promotion_date"),
					rs.getInt("user_id"),
					rs.getString("first_name"),
					rs.getString("last_name")
					 ));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return prolist;
	}
	public void delPromotion(int id)
	{
		try
		{
			Connection conn=DatabaseConnection.getConnection();
			String q="delete from Promotion where promotion_id='"+id+"'";
			PreparedStatement ps=conn.prepareStatement(q);
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public Promotion findById(int id)
	{
		Promotion p=null;
		try
		{
			Connection conn=DatabaseConnection.getConnection();
			String q="select * from Promotion where promotion_id='"+id+"'";
			PreparedStatement ps=conn.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p=new Promotion(
						rs.getInt("promotion_id"),
						rs.getString("designation_from"),
						rs.getString("designation_to"),
						rs.getString("promotion_date"),
						rs.getInt("user_id")
						
					);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return p;
	}
	
	public void UpdatePromotion(Promotion p)
	{
	    try {
	        Connection conn = DatabaseConnection.getConnection();
	        String q = "UPDATE Promotion SET designation_from=?, designation_to=?, promotion_date=?, user_id=? WHERE promotion_id=?";
	        PreparedStatement ps = conn.prepareStatement(q);
	        ps.setString(1, p.getDesignation_from());
	        ps.setString(2, p.getDesignation_to());
	        ps.setString(3, p.getPromotion_date());
	        ps.setInt(4, p.getUser_id());
	        ps.setInt(5, p.getPromotion_id());
	        ps.executeUpdate();
	    } catch(Exception e) {
	        System.out.println("Update error: " + e);
	    }
	}

}
