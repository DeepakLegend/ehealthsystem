package nirmalya.aatithya.restmodule.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.dashboard.model.DMDashboardGraphicalModel;
import nirmalya.aatithya.restmodule.user.dao.DmDashboardDao;
@Repository
public class RestDmDao {
	Logger logger = LoggerFactory.getLogger(DmDashboardDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> dmDashboardGenderWisePatientno(String district,String date,String type) {
		logger.info("Method : viewdmDashboardCount starts");

		List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
		JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_genderwise_patientno")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
			for (Object[] m : x) {
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(m[0], m[1],null,null,null,null,null,m[2]);
				
				req.add(reqemp);
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : viewdmDashboardCount ends")	;
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> dmDashboardAreaWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardAreaWisePatientno starts");

		
		List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
		JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_areawise_patientno")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
			for (Object[] m : x) {
				String date1 = null;
				
				//date1 = DateFormatter.returnStringDateNew(m[0].toString());
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,m[0],null,null,null,null,m[1]);
				
				req.add(reqemp);
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> dmDashboardAgeWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardAgeWisePatientno starts");

		
		List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
		JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_agewise_healthcheckup")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
			for (Object[] m : x) {
				String date1 = null;
				
				//date1 = DateFormatter.returnStringDateNew(m[0].toString());
				DMDashboardGraphicalModel reqemp =new DMDashboardGraphicalModel(null,null,null,m[0],null,null,null,m[1]);
				
				
				req.add(reqemp);
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);
	
		return response;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> dmDashboardDiseaseMaleFemaleWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardDiseaseMaleFemaleWisePatientno starts");

		
		List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
		JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_genderwise_diseasenm")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
			for (Object[] m : x) {
				String date1 = null;
				
				//date1 = DateFormatter.returnStringDateNew(m[0].toString());
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,m[0],null,null,m[1],null,null,m[2]);
				
				
				req.add(reqemp);
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);
	
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> dmDashboardRiskWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardRiskWisePatientno starts");

		DMDashboardGraphicalModel req = new DMDashboardGraphicalModel();
		JsonResponse<DMDashboardGraphicalModel> resp = new JsonResponse<DMDashboardGraphicalModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_riskwise_patientno")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();

			for (Object[] m : x) {
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,null,null,m[0],m[1]);
				
				req = reqemp;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> response = new ResponseEntity<JsonResponse<DMDashboardGraphicalModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : dmDashboardRiskWisePatientno ends")	;
		return response;
	}
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> dmDashboardPhcWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardPhcWisePatientno starts");

		DMDashboardGraphicalModel req = new DMDashboardGraphicalModel();
		JsonResponse<DMDashboardGraphicalModel> resp = new JsonResponse<DMDashboardGraphicalModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_phcwise_patientno")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();

			for (Object[] m : x) {
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,null,m[0],m[1],m[2]);
				
				req = reqemp;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> response = new ResponseEntity<JsonResponse<DMDashboardGraphicalModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : dmDashboardPhcWisePatientno ends")	;
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> dmDashboardDieaseWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardDieaseWisePatientno starts");

		DMDashboardGraphicalModel req = new DMDashboardGraphicalModel();
		JsonResponse<DMDashboardGraphicalModel> resp = new JsonResponse<DMDashboardGraphicalModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_dieaseswise_patientno")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();

			for (Object[] m : x) {
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,m[0],null,null,m[1]);
				
				req = reqemp;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> response = new ResponseEntity<JsonResponse<DMDashboardGraphicalModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : dmDashboardDieaseWisePatientno ends")	;
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> dmDashboardpercentageDieaseWisePatientno(String district,String date,String type) {
		logger.info("Method : dmDashboardpercentageDieaseWisePatientno starts");

		DMDashboardGraphicalModel req = new DMDashboardGraphicalModel();
		JsonResponse<DMDashboardGraphicalModel> resp = new JsonResponse<DMDashboardGraphicalModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_percentagedieaseswise_patientno")
					.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();

			for (Object[] m : x) {
				DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,m[0],null,null,m[1]);
				
				req = reqemp;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> response = new ResponseEntity<JsonResponse<DMDashboardGraphicalModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : dmDashboardpercentageDieaseWisePatientno ends")	;
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Total Health Checkup Status
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> totalHealthCheckup(String district,String date,String type) {
			logger.info("Method : totalHealthCheckup starts");

			List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
			JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_checkup_status")
						.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
				for (Object[] m : x) {
					String date1 = null;
					
					/* date1 = DateFormatter.returnStringDateNew(m[0].toString()); */
					DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,null,null,m[0],m[1]);
				//	System.out.println("totalHealthCheckup1"+reqemp);
					req.add(reqemp);
				}
				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			} 

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
			//System.out.println("totalHealthCheckup"+response);
			logger.info("Method : totalHealthCheckup ends")	;
			return response;
		}
		
		
		//High Risk Data Location Wise
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> getHighRiskLocationWise(String district,String date,String type) {
				logger.info("Method : totalHealthCheckup starts");

				List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
				JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_areawise_highrisk_dm")
							.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
					for (Object[] m : x) {
						String date1 = null;
						
						/* date1 = DateFormatter.returnStringDateNew(m[0].toString()); */
						DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,null,m[0],m[1],m[2]);
						System.out.println("getHighRiskLocationWise"+reqemp);
						req.add(reqemp);
					}
					resp.setBody(req);
				} catch (Exception e) {
					e.printStackTrace();
				} 

				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");

				ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
						resp, responseHeaders, HttpStatus.CREATED);
				System.out.println("getHighRiskLocationWise22222222222222"+response);
				logger.info("Method : getHighRiskLocationWise ends")	;
				return response;
			}



	// Rest Disese wise total patient no DAo
		@SuppressWarnings("unchecked")
		public JsonResponse<List<DMDashboardGraphicalModel>> dmDashboardDieaseWisePatientnoDao(String district,String date,String type) {
			logger.info("Method : dmDashboardDieaseWisePatientnoDao starts");

			List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
			JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_diseasewise_total")
						.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();

				for (Object[] m : x) {
					DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,m[0],null,null,m[1]);
					
					req.add(reqemp);
				}

				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("cm_dashboard_dieaseswise_patientno "+resp);
			logger.info("Method : dmDashboardDieaseWisePatientnoDao ends")	;
			return resp;
		}





	@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> dmDashboardTreandingDisease(String district,String date,String type) {
			logger.info("Method : dmDashboardTreandingDisease starts");

			
			List<DMDashboardGraphicalModel> req = new ArrayList<DMDashboardGraphicalModel>();
			JsonResponse<List<DMDashboardGraphicalModel>> resp = new JsonResponse<List<DMDashboardGraphicalModel>>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_disease_trand")
						.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
				for (Object[] m : x) {
					//String date1 = null;
					
					//date1 = DateFormatter.returnStringDateNew(m[0].toString());
					DMDashboardGraphicalModel reqemp = new DMDashboardGraphicalModel(null,null,null,null,m[0],null,null,m[1]);
					req.add(reqemp);
					System.out.println("Disease Treand"+reqemp);
				}
				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			} 

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> response = new ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
			
			logger.info("Method : dmDashboardTreandingDisease ends")	;
			System.out.println(response);
			return response;
		}


		//count test details
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> countTestDetailsDao(String district,String date,String type) {
			logger.info("Method : countTestDetailsDao starts");

			DMDashboardGraphicalModel req = new DMDashboardGraphicalModel();
			JsonResponse<DMDashboardGraphicalModel> resp = new JsonResponse<DMDashboardGraphicalModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("dm_dashboard_count_test_details")
						.setParameter("district", district).setParameter("date", date).setParameter("type", type).getResultList();
				for (Object[] m : x) {
					/*
					 * String date1 = null;
					 * 
					 * date1 = DateFormatter.returnStringDateNew(m[0].toString());
					 */
					DMDashboardGraphicalModel countDetails = new DMDashboardGraphicalModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],null);
					
					req=countDetails;
				}
				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			} 

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> response = new ResponseEntity<JsonResponse<DMDashboardGraphicalModel>>(
					resp, responseHeaders, HttpStatus.CREATED);
			logger.info("Method : countTestDetailsDao ends")	;
			return response;
		}
}
