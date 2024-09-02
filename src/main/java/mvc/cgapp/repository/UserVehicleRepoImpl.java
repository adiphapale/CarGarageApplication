package mvc.cgapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.rowmapper.UserRowMapper;
import mvc.cgapp.rowmapper.UserVehicleRowMapper;

@Repository
public class UserVehicleRepoImpl implements UserVehicleRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<UserVehicleModel> getVehiclesByUserID(int userid) {

		String sql = "select v.vid,v.vmodel,v.vnplate,v.vrun,v.ventrydate from vehicleDetails_1 v inner join userDetails_1 u on v.uid=u.uid where u.uid=?";
		List<UserVehicleModel> allUserVehicles = jdbcTemplate.query(sql, new UserVehicleRowMapper(), userid);
		return allUserVehicles;
	}

	@Override
	public List<UserVehicleModel> getAllCars() {
		String sql = "select *from vehicledetails_1";
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql,new UserVehicleRowMapper());
		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByModel(String vmodel) {
		String sql = "select *from vehicledetails_1 where vmodel like ?";

		 String likePattern = "%" +  vmodel + "%";
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByModelNumberPlate(String vmodel, String vnplate) {
		String sql = "select *from vehicledetails_1 where vmodel like ? and vnplate like ?";
		String likePattern = "%" + vmodel + "%";
		String likePattern1 = "%" + vnplate + "%";
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern,likePattern1);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByModelKm(String vmodel, Long vrun) {
		String sql = "select *from vehicledetails_1 where vmodel like ? and vrun<=?";
		String likePattern = "%" + vmodel + "%";
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern,vrun);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByModelEntryDate(String vmodel, String vdate) {
		String sql = "select *from vehicledetails_1 where vmodel like ? and ventrydate=?";
		String likePattern = "%" + vmodel + "%";
	
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern,vdate);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByNumberPlate(String vnplate) {
		String sql = "select *from vehicledetails_1 where vnplate like ?";
		
		String likePattern = "%" + vnplate + "%";
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByNumberPlateKm(String vnplate, Long vrun) {
		String sql = "select *from vehicledetails_1 where vnplate like ? and vrun<=?";
		
		String likePattern = "%" + vnplate + "%";
		
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern,vrun);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByNumberPlateEntryDate(String vnplate, String vdate) {
		String sql = "select *from vehicledetails_1 where vnplate like ? and ventrydate=?";
		
		String likePattern = "%" + vnplate + "%";
		
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),likePattern,vdate);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByKm(Long vrun) {
		String sql = "select *from vehicledetails_1 where vrun<=?";
		
		
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),vrun);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByKmEntryDate(Long vrun, String vdate) {
		String sql = "select *from vehicledetails_1 where vrun<=? and ventrydate=?";
		
		
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),vrun,vdate);

		return allCars;
	}

	@Override
	public List<UserVehicleModel> getSelectedCarsByEntryDate(String vdate) {
		String sql = "select *from vehicledetails_1 where ventrydate=?";
		
		
		List<UserVehicleModel> allCars = jdbcTemplate.query(sql, new UserVehicleRowMapper(),vdate);

		return allCars;
	}

	@Override
	public UserVehicleModel getSelectedCarsByID(int vid) {
		String sql = "select *from vehicledetails_1 where vid=?";

		UserVehicleModel selectedCar = jdbcTemplate.queryForObject(sql, new UserVehicleRowMapper(),vid);

		return selectedCar;
	}

}
