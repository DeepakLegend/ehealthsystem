package nirmalya.aathithya.webmodule.pm.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import nirmalya.aathithya.webmodule.common.utils.EnvironmentVaribles;
import nirmalya.aathithya.webmodule.common.utils.FileUpload;

@Controller
@RequestMapping(value = "pm/")
public class PredictiveDashboardController {
	Logger logger = LoggerFactory.getLogger(PredictiveDashboardController.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	FileUpload fileUpload;
	
	@GetMapping("/predictive-dashboard")
	public String categoryDashboard(Model model, HttpSession session) {

		logger.info("Method : categoryDashboard starts");
	
		logger.info("Method : categoryDashboard ends");
		return "pm/predictiveDashboard";

	}
}
