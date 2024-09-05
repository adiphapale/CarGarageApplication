package mvc.cgapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.model.VisitVehicleModel;

@Repository
public class CarHandleRepoImpl implements CarHandleRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int saveVehicleData(UserVehicleModel userVehicleModel) {
		String vmodel = userVehicleModel.getVehiclemodel();
		String vnplate = userVehicleModel.getVehiclenplate();
		Long userid = userVehicleModel.getUserid();
		System.out.println(vmodel + vnplate + userid);
		String sql = "insert into vehicledetails_1(vmodel,vnplate,uid) values(?,?,?)";
		int res = 0;
		try {
			res = jdbcTemplate.update(sql, vmodel, vnplate, userid);
		} catch (Exception ex) {
			System.out.println("vehicle data not added :(");
		}

		int vid = 0;
		if (res > 0)
			vid = getVehicleId(vnplate);
		else
			System.out.println("something problem is there while adding vehicle data:(");

		return vid;
	}

	@Override
	public boolean addVehicleData(VehicleFormModel vehicleFormModel) {

		return true;
	}

	@Override
	public int getVehicleId(String vnplate) {

		String sql = "select vid from vehicledetails_1 where vnplate=?";

		int vid = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet arg0, int arg1) throws SQLException {

				return arg0.getInt(1);
			}

		}, vnplate);
		return vid;
	}

	@Override
	public int saveVisitVehicleData(VisitVehicleModel visitVehicleModel) {
		long vvrun = visitVehicleModel.getVisitVrun();
		String vvEntryDate = visitVehicleModel.getVisitVentryDate();
		int vid = visitVehicleModel.getVid();
		int tid = visitVehicleModel.getTid();

		String sql = "insert into visitvehicledetails_1(vvrun,vventryDate,vid,tid) values(?,?,?,?)";

		int res = 0;
		try {
			res = jdbcTemplate.update(sql, vvrun, vvEntryDate, vid, tid);
		} catch (Exception ex) {
			System.out.println("visit vehicle data not added :(");
		}

		int vvid = 0;
		if (res > 0)
			vvid = getVisitVehicleId(vvEntryDate);
		else
			System.out.println("something problem is there while adding visit vehicle data:(");

		return vvid;
	}

	@Override
	public int getVisitVehicleId(String vvEntryDate) {
		String sql = "select vvid from visitvehicledetails_1 where vventryDate=? order by vventryDate desc limit 1";

		int vvid = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet arg0, int arg1) throws SQLException {

				return arg0.getInt(1);
			}

		}, vvEntryDate);
		return vvid;
	}

	@Override
	public VehicleFormModel getUpdatedVehicle(VehicleFormModel vehicleFormModel) {
		
		String vmodel=vehicleFormModel.getVehiclemodel();
		String vnplate=vehicleFormModel.getVehiclenplate();
		long vvrun=vehicleFormModel.getVisitVrun();
		String vventryDate=vehicleFormModel.getVisitVentryDate();
		int vvid=vehicleFormModel.getVehicleid();
		
		
		VehicleFormModel bindData=new VehicleFormModel();
		bindData.setVehicleid(vvid);
		bindData.setVehiclemodel(vmodel);
		bindData.setVehiclenplate(vnplate);
		bindData.setVisitVrun(vvrun);
		bindData.setVisitVentryDate(vventryDate);
		
		String sql="update visitvehicledetails_1 vs inner join vehicledetails_1 v on vs.vid=v.vid set v.vmodel=?,v.vnplate=?,vs.vvrun=?,vs.vventrydate=? where vs.vvid=?";
		
		int res=jdbcTemplate.update(sql,vmodel,vnplate,vvrun,vventryDate,vvid);
		
		return res>0?bindData:null;
	}

}
