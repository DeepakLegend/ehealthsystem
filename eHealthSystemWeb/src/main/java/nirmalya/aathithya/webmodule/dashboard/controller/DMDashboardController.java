package nirmalya.aathithya.webmodule.dashboard.controller;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import nirmalya.aathithya.webmodule.common.utils.EnvironmentVaribles;
import nirmalya.aathithya.webmodule.common.utils.JsonResponse;
import nirmalya.aathithya.webmodule.user.controller.AccessController;
import nirmalya.aathithya.webmodule.user.model.CmDashboardModel;
import nirmalya.aathithya.webmodule.user.model.DmDashboardModel;
import nirmalya.aathithya.webmodule.user.model.UserRolesAndModuleIdModel;
/**
 * @author Nirmalya Labs
 *
 */
@Controller
public class DMDashboardController {
	
	Logger logger = LoggerFactory.getLogger(DMDashboardController.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRolesAndModuleIdModel userModel;

	@GetMapping("/dmdashboard")
	public String cmDashboard(Model model, HttpSession session) {
		logger.info("Method : user starts");
		String userId1 = (String) session.getAttribute("USER_ID");
		try {
			DmDashboardModel[] region = restTemplate.getForObject(env.getUserUrl() + "dmDashboardGetIdd?id=" + userId1,
					DmDashboardModel[].class);
			List<DmDashboardModel> dmDashboardGetIdd = Arrays.asList(region);
			model.addAttribute("dmDashboardGetIdd", dmDashboardGetIdd);
		} catch (RestClientException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
				logger.info("Method : user ends");
		return "user/dmDashboard";
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value = { "dmdashboard-genderWise-patientno" })
	public @ResponseBody JsonResponse<Object> getPatientNo(Model model, @RequestParam("district") String encodestate,
			@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

		logger.info("Method : getPatientNo starts");
		byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
		byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
		byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

		String district = (new String(encodeByte1));
		String date = (new String(encodeByte2));
		String type = (new String(encodeByte3));

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		System.out.println(district+" "+date+" "+type);

		try {
			resp = restTemplate.getForObject(
					env.getUserUrl() + "genderWise-patientnodm?district=" + district + "&date=" + date + "&type=" + type,
					JsonResponse.class);

		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resp.getMessage() != null && resp.getMessage() != "") {
			resp.setCode(resp.getMessage());
			resp.setMessage("Unsuccess");
		} else {
			resp.setMessage("success");
		}
		logger.info("Method : getPatientNo ends");
		return resp;
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value = { "dmdashboard-areaWise-patientno" })
	public @ResponseBody JsonResponse<Object> getAreaPatientNo(Model model, @RequestParam("district") String encodestate,
			@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

		logger.info("Method : getAreaPatientNo starts");
		byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
		byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
		byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

		String district = (new String(encodeByte1));
		String date = (new String(encodeByte2));
		String type = (new String(encodeByte3));

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		System.out.println(district+" "+date+" "+type);

		try {
			resp = restTemplate.getForObject(
					env.getUserUrl() + "areWise-patientnodm?district=" + district + "&date=" + date + "&type=" + type,
					JsonResponse.class);

		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resp.getMessage() != null && resp.getMessage() != "") {
			resp.setCode(resp.getMessage());
			resp.setMessage("Unsuccess");
		} else {
			resp.setMessage("success");
		}
		logger.info("Method : getAreaPatientNo ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = { "dmdashboard-ageWise-patientno" })
	public @ResponseBody JsonResponse<Object> getAgePatientNo(Model model, @RequestParam("district") String encodestate,
			@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

		logger.info("Method : getAgePatientNo starts");
		byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
		byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
		byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

		String district = (new String(encodeByte1));
		String date = (new String(encodeByte2));
		String type = (new String(encodeByte3));

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		System.out.println(district+" "+date+" "+type);

		try {
			resp = restTemplate.getForObject(
					env.getUserUrl() + "ageWise-patientnodm?state=" + district + "&date=" + date + "&type=" + type,
					JsonResponse.class);

		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resp.getMessage() != null && resp.getMessage() != "") {
			resp.setCode(resp.getMessage());
			resp.setMessage("Unsuccess");
		} else {
			resp.setMessage("success");
		}
		logger.info("Method : getAgePatientNo ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = { "dmdashboard-diseaseWise-patientno" })
	public @ResponseBody JsonResponse<Object> getDiseaseMaleFemalePatientNo(Model model, @RequestParam("district") String encodestate,
			@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

		logger.info("Method : getAgePatientNo starts");
		byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
		byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
		byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

		String district = (new String(encodeByte1));
		String date = (new String(encodeByte2));
		String type = (new String(encodeByte3));

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		System.out.println(district+" "+date+" "+type);

		try {
			resp = restTemplate.getForObject(
					env.getUserUrl() + "diseaseWise-patientnodm?district=" + district + "&date=" + date + "&type=" + type,
					JsonResponse.class);

		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resp.getMessage() != null && resp.getMessage() != "") {
			resp.setCode(resp.getMessage());
			resp.setMessage("Unsuccess");
		} else {
			resp.setMessage("success");
		}
		logger.info("Method : getDiseasePatientNo ends");
		return resp;
	}
	
	
	
	
	
	//High Risk Data Location Wise
	
			@SuppressWarnings("unchecked")
			@GetMapping(value = { "dmdashboard-high-risk-data-location-wise" })
			public @ResponseBody JsonResponse<Object> getHighRiskLocationWise(Model model, @RequestParam("district") String encodestate,
					@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

				logger.info("Method : getHighRiskLocationWise starts");
				byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
				byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
				byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

				String district = (new String(encodeByte1));
				String date = (new String(encodeByte2));
				String type = (new String(encodeByte3));

				JsonResponse<Object> resp = new JsonResponse<Object>();
				
			//	System.out.println(state+" "+date+" "+type);

				try {
					resp = restTemplate.getForObject(
							env.getUserUrl() + "rest-getHighRiskLocationWisedm?district=" + district + "&date=" + date + "&type=" + type,
							JsonResponse.class);

				} catch (RestClientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (resp.getMessage() != null && resp.getMessage() != "") {
					resp.setCode(resp.getMessage());
					resp.setMessage("Unsuccess");
				} else {
					resp.setMessage("success");
				}
				logger.info("Method : getHighRiskLocationWise ends");
				return resp;
			}
			


		//Total Health Checkup Status
		
		@SuppressWarnings("unchecked")
		@GetMapping(value = { "dmdashboard-total-health-checkup-status" })
		public @ResponseBody JsonResponse<Object> getTotalHealthCheckup(Model model, @RequestParam("district") String encodestate,
				@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

			logger.info("Method : getAreaPatientNo starts");
			byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
			byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
			byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

			String district = (new String(encodeByte1));
			String date = (new String(encodeByte2));
			String type = (new String(encodeByte3));

			JsonResponse<Object> resp = new JsonResponse<Object>();
			
			//System.out.println(state+" "+date+" "+type);

			try {
				resp = restTemplate.getForObject(
						env.getUserUrl() + "rest-totalHealthCheckupdm?district=" + district + "&date=" + date + "&type=" + type,
						JsonResponse.class);

			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (resp.getMessage() != null && resp.getMessage() != "") {
				resp.setCode(resp.getMessage());
				resp.setMessage("Unsuccess");
			} else {
				resp.setMessage("success");
			}
			logger.info("Method : getAreaPatientNo ends");
			return resp;
		}



	//Disese wise total patient no
		@SuppressWarnings("unchecked")
		@GetMapping(value = { "dmdashboard-dieaseWise-patientno" })
		public @ResponseBody JsonResponse<Object> getDiseaseWisePatientNo(Model model, @RequestParam("district") String encodestate,
				@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

			logger.info("Method : getDiseaseWisePatientNo starts");
			byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
			byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
			byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

			String district = (new String(encodeByte1));
			String date = (new String(encodeByte2));
			String type = (new String(encodeByte3));

			JsonResponse<Object> resp = new JsonResponse<Object>();
			
			System.out.println(district+" "+date+" "+type);

			try {
				resp = restTemplate.getForObject(
						env.getUserUrl() + "dieaseWise-patientnodm?district=" + district + "&date=" + date + "&type=" + type,
						JsonResponse.class);

			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (resp.getMessage() != null && resp.getMessage() != "") {
				resp.setCode(resp.getMessage());
				resp.setMessage("Unsuccess");
			} else {
				resp.setMessage("success");
			}
			logger.info("Method : getDiseaseWisePatientNo ends");
			return resp;
		}


	//treanding disease

		@SuppressWarnings("unchecked")
		@GetMapping(value = { "dmdashboard-top-treanding-disease" })
		public @ResponseBody JsonResponse<Object> getreandingDisease(Model model, @RequestParam("district") String encodestate,
				@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

			logger.info("Method : getreandingDisease starts");
			byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
			byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
			byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

			String district = (new String(encodeByte1));
			String date = (new String(encodeByte2));
			String type = (new String(encodeByte3));

			JsonResponse<Object> resp = new JsonResponse<Object>();
			
			System.out.println(district+" "+date+" "+type);

			try {
				resp = restTemplate.getForObject(
						env.getUserUrl() + "treanding-diseasedm?district=" + district + "&date=" + date + "&type=" + type,
						JsonResponse.class);

			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (resp.getMessage() != null && resp.getMessage() != "") {
				resp.setCode(resp.getMessage());
				resp.setMessage("Unsuccess");
			} else {
				resp.setMessage("success");
			}
			logger.info("Method : getreandingDisease ends");
			return resp;
		}



	//Count test details
		@SuppressWarnings("unchecked")
		@GetMapping(value = { "dmdashboard-count-testDetails" })
		public @ResponseBody JsonResponse<Object> getCountTestDetails(Model model, @RequestParam("district") String encodestate,
				@RequestParam("date") String encodedate, @RequestParam("type") String encodetype, HttpSession session) {

			logger.info("Method : getCountTestDetails starts");
			byte[] encodeByte1 = Base64.getDecoder().decode(encodestate.getBytes());
			byte[] encodeByte2 = Base64.getDecoder().decode(encodedate.getBytes());
			byte[] encodeByte3 = Base64.getDecoder().decode(encodetype.getBytes());

			String district = (new String(encodeByte1));
			String date = (new String(encodeByte2));
			String type = (new String(encodeByte3));

			JsonResponse<Object> resp = new JsonResponse<Object>();
			
			try {
				resp = restTemplate.getForObject(
						env.getUserUrl() + "rest-count-TestDetailsdm?district=" + district + "&date=" + date + "&type=" + type,
						JsonResponse.class);

			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (resp.getMessage() != null && resp.getMessage() != "") {
				resp.setCode(resp.getMessage());
				resp.setMessage("Unsuccess");
			} else {
				resp.setMessage("success");
			}
			logger.info("Method : getCountTestDetails ends");
			return resp;
		}

}
