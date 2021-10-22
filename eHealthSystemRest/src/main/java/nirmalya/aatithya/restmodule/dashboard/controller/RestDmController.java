package nirmalya.aatithya.restmodule.dashboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.dashboard.dao.RestCmDao;
import nirmalya.aatithya.restmodule.dashboard.dao.RestDmDao;
import nirmalya.aatithya.restmodule.dashboard.model.DMDashboardGraphicalModel;
@RestController
@RequestMapping("user/")
public class RestDmController {
	Logger logger = LoggerFactory.getLogger(RestDmController.class);
	
	@Autowired
	
	RestDmDao dmDashboardDao;	
	
	@GetMapping(value = "genderWise-patientnodm")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> cmDashboardGenderWisePatientno(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
		logger.info("Method : viewdmDashboardDailyRegistration starts");

		logger.info("Method :viewdmDashboardDailyRegistration ends");
		return dmDashboardDao.dmDashboardGenderWisePatientno(district,date,type);
	}
	
	@GetMapping(value = "areWise-patientnodm")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> cmDashboardAreaWisePatientno(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
		logger.info("Method : cmDashboardAreaWisePatientno starts");

		logger.info("Method :cmDashboardAreaWisePatientno ends");
		return dmDashboardDao.dmDashboardAreaWisePatientno(district,date,type);
	}
	@GetMapping(value = "ageWise-patientnodm")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> cmDashboardAgeWisePatientno(@RequestParam("state") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
			logger.info("Method : cmDashboardAgeWisePatientno starts");

		logger.info("Method :cmDashboardAgeWisePatientno ends");
		return dmDashboardDao.dmDashboardAgeWisePatientno(district,date,type);
	}
	
	@GetMapping(value = "diseaseWise-patientnodm")
	public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> cmDashboardDiseaseMaleFemaleWisePatientno(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
			logger.info("Method : cmDashboardAgeWisePatientno starts");

		logger.info("Method :cmDashboardAgeWisePatientno ends");
		return dmDashboardDao.dmDashboardDiseaseMaleFemaleWisePatientno(district,date,type);
	}
	
	
	@GetMapping(value = "riskWise-patientno")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> cmDashboardRiskWisePatientno(@RequestParam String district,@RequestParam String date,@RequestParam String type) {
		logger.info("Method : cmDashboardRiskWisePatientno starts");

		logger.info("Method :cmDashboardRiskWisePatientno ends");
		return dmDashboardDao.dmDashboardRiskWisePatientno(district,date,type);
	}
	@GetMapping(value = "phcWise-patientno")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> cmDashboardPhcWisePatientno(@RequestParam String district,@RequestParam String date,@RequestParam String type) {
		logger.info("Method : cmDashboardPhcWisePatientno starts");

		logger.info("Method :cmDashboardRiskWisePatientno ends");
		return dmDashboardDao.dmDashboardPhcWisePatientno(district,date,type);
	}
/*	@GetMapping(value = "dieaseWise-patientno")
	public ResponseEntity<JsonResponse<CMDashboardGraphicalModel>> cmDashboardDieaseWisePatientno(@RequestParam String stateId,@RequestParam String date,@RequestParam String type) {
		logger.info("Method : cmDashboardDieaseWisePatientno starts");

		logger.info("Method :cmDashboardDieaseWisePatientno ends");
		return cmDashboardDao.cmDashboardDieaseWisePatientno(stateId,date,type);
	}*/
	@GetMapping(value = "percentageDieaseWise-patientno")
	public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> cmDashboardpercentageDieaseWisePatientno(@RequestParam String district,@RequestParam String date,@RequestParam String type) {
		logger.info("Method : cmDashboardpercentageDieaseWisePatientno starts");

		logger.info("Method :cmDashboardpercentageDieaseWisePatientno ends");
		return dmDashboardDao.dmDashboardpercentageDieaseWisePatientno(district,date,type);
	}
	
	
	//Total Health Checkup Status
	
			@GetMapping(value = "rest-totalHealthCheckupdm")
			public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> totalHealthCheckup(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
				logger.info("Method : totalHealthCheckup starts");

				logger.info("Method :totalHealthCheckup ends");
				return dmDashboardDao.totalHealthCheckup(district,date,type);
			}
			
	//High Risk Data Location Wise
			
					@GetMapping(value = "rest-getHighRiskLocationWisedm")
					public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> getHighRiskLocationWise(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
						logger.info("Method : getHighRiskLocationWise starts");

						logger.info("Method :totalHealthCheckup ends");
						return dmDashboardDao.getHighRiskLocationWise(district,date,type);
					}



	// Rest Disese wise total patient no
			@GetMapping(value = "dieaseWise-patientnodm")
			public JsonResponse<List<DMDashboardGraphicalModel>> cmDashboardDieaseWisePatientno(@RequestParam String district,@RequestParam String date,@RequestParam String type) {
				logger.info("Method : cmDashboardDieaseWisePatientno starts");

				logger.info("Method :cmDashboardDieaseWisePatientno ends");
				return dmDashboardDao.dmDashboardDieaseWisePatientnoDao(district,date,type);
			}


	//Treanding Disease

	@GetMapping(value = "treanding-diseasedm")
			public ResponseEntity<JsonResponse<List<DMDashboardGraphicalModel>>> cmDashboardTreandingDisease(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
					logger.info("Method : cmDashboardTreandingDisease starts");

				logger.info("Method :cmDashboardTreandingDisease ends");
				return dmDashboardDao.dmDashboardTreandingDisease(district,date,type);
			}

	//count test details
			@GetMapping(value = "rest-count-TestDetailsdm")
			public ResponseEntity<JsonResponse<DMDashboardGraphicalModel>> countTestDetails(@RequestParam("district") String district,@RequestParam("date") String date,@RequestParam("type") String type) {
				logger.info("Method : countTestDetails starts");

				logger.info("Method :countTestDetails ends");
				return dmDashboardDao.countTestDetailsDao(district,date,type);
			}
}
