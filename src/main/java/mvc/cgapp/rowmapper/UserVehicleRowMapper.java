package mvc.cgapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;

public class UserVehicleRowMapper implements RowMapper<UserVehicleModel>{


	@Override
	public UserVehicleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVehicleModel getit = new UserVehicleModel();
		getit.setVehicleid(rs.getInt("vid")); // Ensure column names match
		getit.setVehiclemodel(rs.getString("vmodel"));
		getit.setVehiclenplate(rs.getString("vnplate"));
		getit.setUserid(rs.getLong("uid"));
		return getit;
	}

}
