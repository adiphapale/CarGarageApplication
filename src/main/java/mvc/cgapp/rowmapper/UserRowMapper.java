package mvc.cgapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mvc.cgapp.model.UserDetailsModel;

public class UserRowMapper implements RowMapper<UserDetailsModel>{

	@Override
	public UserDetailsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailsModel getit = new UserDetailsModel();
		getit.setUserid(rs.getInt(1));
		getit.setUsername(rs.getString(2));
		getit.setUsercontact(rs.getString(3));
		getit.setUseremail(rs.getString(4));
		getit.setUseraddress(rs.getString(5));
		return getit;
	}

}
