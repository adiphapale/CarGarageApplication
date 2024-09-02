package mvc.cgapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;

@Repository
public class MainServicesRepoImpl implements MainServicesRepo{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MainServicesModel> getAllMainServices() {
		String sql="select *from MainservicesDetails_1";
		List<MainServicesModel> gettingAllMainServices=jdbcTemplate.query(sql, new RowMapper<MainServicesModel>() {

			@Override
			public MainServicesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				MainServicesModel getit=new MainServicesModel();
				getit.setMsid(rs.getInt(1));
				getit.setMsname(rs.getString(2));
				return getit;
			}
			
		});
		
		return gettingAllMainServices;
	}

	@Override
	public List<SubServicesModel> getSubServicesByMsId(int msid) {
		String sql="select *from subservicesdetails_1 where msid  != ?";
		List<SubServicesModel> gettingAllMainServices=jdbcTemplate.query(sql, new RowMapper<SubServicesModel>() {

			@Override
			public SubServicesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				SubServicesModel getit=new SubServicesModel();
				getit.setSsid(rs.getInt(1));
				getit.setSsname(rs.getString(2));
				getit.setSsprice(rs.getFloat(3));
				getit.setMsid(rs.getInt(4));
				return getit;
			}
			
		},msid);
		
		return gettingAllMainServices;
	}

}
