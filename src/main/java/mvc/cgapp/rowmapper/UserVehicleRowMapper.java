package mvc.cgapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;

public class UserVehicleRowMapper implements RowMapper<VehicleFormModel>{


	public VehicleFormModel mapRow(ResultSet rs, int arg1) throws SQLException {
		VehicleFormModel getit=new VehicleFormModel();
		getit.setVehicleid(rs.getInt(1));
		getit.setVehiclemodel(rs.getString(2));
		getit.setVehiclenplate(rs.getString(3));
		getit.setVisitVrun(rs.getLong(4));
		getit.setVisitVentryDate(rs.getString(5));
		getit.setTname(rs.getString(6));
		return getit;
	}

}
