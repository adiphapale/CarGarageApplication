package mvc.cgapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mvc.cgapp.model.AdminModel;

@Repository
public class AdminRepoImpl implements AdminRepo{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean checkValidAdmin(String adminName, String pass) {
		String sql="select aname,apass from admindetails_1 where aname=? and apass=?";
		
		AdminModel adminModel=new AdminModel();
		try {
			adminModel=jdbcTemplate.queryForObject(sql, new RowMapper<AdminModel>() {

				@Override
				public AdminModel mapRow(ResultSet rs, int arg1) throws SQLException {
					AdminModel getit=new AdminModel();
					getit.setAdminName(rs.getString(1));
					getit.setAdminPassword(rs.getString(2));
					return getit;
				}
				
			},adminName,pass);
		}catch(Exception ex) {
			adminModel=null;
		}	
		return adminModel==null?false:true;
	}

}
