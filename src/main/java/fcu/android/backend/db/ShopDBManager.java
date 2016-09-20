package fcu.android.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fcu.android.backend.data.Shop;

public class ShopDBManager {
	
	private static ShopDBManager DB_MANAGER = new ShopDBManager();
	
	private static final String shopImgURL = "http://140.134.26.71:58080/android-backend/UploadDownloadFileServlet?id=";

	public static ShopDBManager getInstance() {
		return DB_MANAGER;
	}

	private IDatabase database = DatabaseFactory.getDatabase(DatabaseFactory.DatabaseType.MySql);

	private ShopDBManager() {

	}

	public boolean addShop(Shop shop) {
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
		Statement stmt = null;
		String sql = "INSERT INTO SHOP(shopName, password, email, phone, intro)  VALUES(?, ?, ?, ?, ?)";
		String query = "SELECT * FROM SHOP";
		try {
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, shop.getShopName());
			preStmt.setString(2, shop.getPassword());
			preStmt.setString(3, shop.getEmail());
			preStmt.setString(4, shop.getPhone());
			preStmt.setString(5, shop.getIntro());
			preStmt.executeUpdate();
			preStmt.close();

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("List All Shops");
			while (rs.next()) {
				System.out.println("Shop Name: " + rs.getString("shopName") + ", Email: " + rs.getString("email"));
			}
			stmt.close();
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateShop(Shop shop) {
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
		Statement stmt = null;
		String sql = "UPDATE SHOP SET shopName=?, password=?, phone=?, intro=? WHERE email=?";
		String query = "SELECT * FROM SHOP";
		try {
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, shop.getShopName());
			preStmt.setString(2, shop.getPassword());
			preStmt.setString(3, shop.getPhone());
			preStmt.setString(4, shop.getIntro());
			preStmt.setString(5, shop.getEmail());
			preStmt.executeUpdate();
			preStmt.close();

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("List All Shops");
			while (rs.next()) {
				System.out.println("Shop Name: " + rs.getString("shopName") + ", Email: " + rs.getString("email"));
			}
			stmt.close();
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean validateShop(String email, String password) {
		Connection conn = database.getConnection();
		PreparedStatement stmt = null;
		String query = "SELECT * FROM SHOP WHERE email = ? and password = ?";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			boolean valid = rs.first();
			stmt.close();
			conn.commit();
			return valid;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Shop getShop(String email) {
		Connection conn = database.getConnection();
		PreparedStatement stmt = null;
		String query = "select * from SHOP where email = ?";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			Shop shop = new Shop();
			if (rs.next()) {
				shop.setID(rs.getInt("ID"));
				shop.setShopName(rs.getString("shopName"));
				shop.setPassword(rs.getString("password"));
				shop.setEmail(rs.getString("email"));
				shop.setPhone(rs.getString("phone"));
				shop.setIntro(rs.getString("intro"));
				int id = rs.getInt("ID");
				shop.setPhoto(shopImgURL+id);
			}
			stmt.close();
			conn.commit();
			return shop;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new Shop();
	}

	public List<Shop> listAllShops() {
		List<Shop> lsShops = new ArrayList<Shop>();

		Connection conn = database.getConnection();
		String sql = "SELECT * FROM SHOP";
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("shopName");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String intro = rs.getString("intro");
				//String photo = rs.getString("photo");

				Shop shop = new Shop();
				shop.setID(id);
				shop.setShopName(name);
				shop.setPassword(password);
				shop.setEmail(email);
				shop.setPhone(phone);
				shop.setIntro(intro);
				shop.setPhoto(shopImgURL+id);
				lsShops.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsShops;
	}

}
