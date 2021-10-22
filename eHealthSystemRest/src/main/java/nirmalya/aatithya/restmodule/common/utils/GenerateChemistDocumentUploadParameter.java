package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.chemist.model.RestChemistDocumentUpload;
import nirmalya.aatithya.restmodule.chemist.model.RestChemistProfileModel;

public class GenerateChemistDocumentUploadParameter {
	
public static String getdrDataUpload(RestChemistProfileModel doctor) {
		
		String s = "";
		String document = "";
		
		
		  for (RestChemistDocumentUpload a : doctor.getDocumentList()) {
			  //System.out.println("doctor.getRoleId()"+doctor.getRoleId());
			 
			  document = document +  "(\'"+doctor.getRoleId()+ "\',\'" + doctor.getDoctorId()+ "\',\'" + a.getDocumnentName() + "\',\'" +
			  a.getFileName() + "\'),"; 
			  } 
		  document = document.substring(0, document.length() - 1);

			s = s + "" + document + ",";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

			}

			System.out.println("Generate Parameter"+s);

			return s;
		}


}
