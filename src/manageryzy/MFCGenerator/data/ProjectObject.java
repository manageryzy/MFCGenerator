package manageryzy.MFCGenerator.data;

import org.json.JSONObject;

public class ProjectObject {
	String ObjectName;
	TemplateObject template;
	JSONObject theJsonObject;
	
	public ProjectObject(JSONObject json) {
		
	}
	
	public class ProjectObjectVar
	{
		TemplateObject.TemplateVar VarTemplate;
		String Value;
		
		public ProjectObjectVar(JSONObject json) {
			VarTemplate = template.getVarList();
			Value = json.getString("value");
		}
	}
}
