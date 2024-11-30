package mvc.cgapp.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mvc.cgapp.model.CustomerLoginModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.rowmapper.UserRowMapper;
@Repository
public class CustomerLoginRepompl implements CustomerLoginRepo{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetailsModel isCustomerLogoin(CustomerLoginModel customerLoginModel) {
		
		String query="select *From userdetails_1 where uname=? and ucontact=?";
		UserDetailsModel rs=new UserDetailsModel();
		try {
			rs=jdbcTemplate.queryForObject(query, new UserRowMapper(),customerLoginModel.getCustName(),customerLoginModel.getCustPass());
		}catch(Exception ex) {
			rs=null;
		}
		
		return rs;
		
	}

}
