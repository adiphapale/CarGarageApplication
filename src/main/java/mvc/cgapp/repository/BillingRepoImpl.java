package mvc.cgapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mvc.cgapp.model.BillingModel;
//import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;
import mvc.cgapp.model.SubSparePartsModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.VehicleFormModel;

@Repository
public class BillingRepoImpl implements BillingRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public BillingModel fetchBill(int vvid) {
		
		BillingModel setBill = new BillingModel();
		String sql3="select u.uname, u.ucontact from visitvehicledetails_1 vs inner join  vehicledetails_1 v on vs.vid=v.vid inner join userdetails_1 u on u.uid=v.uid where vs.vvid=?";
		
		
		try{
			UserDetailsModel setUserDetails=jdbcTemplate.queryForObject(sql3, new RowMapper<UserDetailsModel>() {
		

			@Override
			public UserDetailsModel mapRow(ResultSet rs, int arg1) throws SQLException {
				UserDetailsModel collectUser=new UserDetailsModel();
				collectUser.setUsername(rs.getString(1));
				collectUser.setUsercontact(rs.getString(2));
				return collectUser;
			}
			
		},vvid);
		
		
		setBill.setUserDetailsModel(setUserDetails);
		}catch(Exception ex) {ex.printStackTrace();}
		
		
		String sql = "select v.vmodel, v.vnplate, vs.vvrun, vs.vventryDate, t.tname from visitvehicledetails_1 vs inner join techniciandetails_1 t on t.tid=vs.tid inner join  vehicledetails_1 v on v.vid=vs.vid where vs.vvid=?";

		
		BillingModel setCustomerBill = jdbcTemplate.queryForObject(sql, new RowMapper<BillingModel>() {

			@Override
			public BillingModel mapRow(ResultSet rs, int arg1) throws SQLException {
				VehicleFormModel setVehicle = new VehicleFormModel();
				setVehicle.setVehiclemodel(rs.getString(1));
				setVehicle.setVehiclenplate(rs.getString(2));
				setVehicle.setVisitVrun(rs.getLong(3));
				setVehicle.setVisitVentryDate(rs.getString(4));
				setVehicle.setTname(rs.getString(5));
				setBill.setVehicleFormModel(setVehicle);
				return setBill;
			}

		},vvid);
		

		String sql1 = "select ss.ssname, ss.ssprice from subservicedetails_1 ss inner join servicesjoin_1 sj on ss.ssid=sj.ssid where sj.vvid=?";
		List<SubServicesModel> SubServices = jdbcTemplate.query(sql1, new RowMapper<SubServicesModel>() {

			@Override
			public SubServicesModel mapRow(ResultSet rs, int arg1) throws SQLException {
				SubServicesModel collect = new SubServicesModel();
				collect.setSsname(rs.getString(1));
				collect.setSsprice(rs.getFloat(2));
				;
				return collect;
			}

		},vvid);

		setCustomerBill.setSubService(SubServices);
		
		float totalServiceCost = 0;
		 for (SubServicesModel service : SubServices) {
		        totalServiceCost += service.getSsprice();
		    }

		 setCustomerBill.setSubTotalServices(totalServiceCost);
		 
		 
		 
		String sql2 = "select sp.spname, sp.spprice, spj.spqty from sparepartsdetails_1 sp inner join sparepartsjoin_1 spj on sp.spid=spj.spid where spj.vvid=?";
		Map<SubSparePartsModel, Integer> subSpareParts = new LinkedHashMap<SubSparePartsModel, Integer>();

		jdbcTemplate.query(sql2, new RowMapper<Void>() {

			@Override
			public Void mapRow(ResultSet rs, int arg1) throws SQLException {
				SubSparePartsModel setSpareParts = new SubSparePartsModel();
				setSpareParts.setSpname(rs.getString(1));
				setSpareParts.setSpprice(rs.getFloat(2));

				subSpareParts.put(setSpareParts, rs.getInt(3));

				return null;
			}

		},vvid);

		setCustomerBill.setSubSpareParts(subSpareParts);

		float totalSparePartsCost = 0;
	    for (Map.Entry<SubSparePartsModel, Integer> entry : subSpareParts.entrySet()) {
	        SubSparePartsModel sparePart = entry.getKey();
	        int quantity = entry.getValue();
	        totalSparePartsCost += sparePart.getSpprice() * quantity;
	    }
		setCustomerBill.setSubTotalSpareParts(totalSparePartsCost);
		
		
		//insert billing details in billing table
		
		
		
		return setCustomerBill;
	}
}
