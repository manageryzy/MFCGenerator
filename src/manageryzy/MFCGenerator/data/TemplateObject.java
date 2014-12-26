package manageryzy.MFCGenerator.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import manageryzy.MFCGenerator.data.Enums.VarTypes;
import manageryzy.MFCGenerator.data.TemplateObject.TemplateVar;

import org.json.JSONArray;
import org.json.JSONObject;

public class TemplateObject {
	
	String NameSpace;
	List<TemplateVar> varList;

	File JsonFile;
	JSONObject theJson;
	
	
	public TemplateObject(File file) 
	{
		JsonFile = file;
		init();
	}
	

	public TemplateObject(String FileName) 
	{
		JsonFile = new File(FileName);
		init();
	}
	
	void init()
	{
		varList = new ArrayList<TemplateVar>();
		
		try {

	        FileInputStream in=new FileInputStream(JsonFile);

	        // size  为字串的长度 ，这里一次性读完

	        int size=in.available();

	        byte[] buffer=new byte[size];

	        in.read(buffer);

	        in.close();

	        theJson = new JSONObject(new String(buffer));

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		NameSpace = theJson.getString("Namespace");
	}
	
	
	public String getNameSpace() {
		return NameSpace;
	}
	
	public List<TemplateVar> getVarList() {
		return varList;
	}
	
	
	public class TemplateVar
	{
		VarTypes type;
		String def;
		boolean necessary;
		String comment;
		
		String Value;
		
		public TemplateVar(JSONObject obj) throws Exception {
			JSONArray commentArray;
			
			switch(obj.getString("type"))
			{
			case "string":
				type = VarTypes.String;
				break;
			case "bool":
				type = VarTypes.Boolean;
				break;
			case "float":
				type = VarTypes.Float;
				break;
			case "double":
				type = VarTypes.Double;
				break;
			case "int":
				type = VarTypes.Integer;
				break;
			default:
				throw new Exception("undefined type");
			}
			
			def = obj.getString("default");
			
			commentArray = obj.getJSONArray("comment");
			if(obj.getString("necessary").equals("true"))
			{
				necessary = true;
			}
			else
			{
				necessary = false;
			}
			
			comment = "";
			for(int i=0;i<commentArray.length();i++)
			{
				comment = comment + commentArray.getString(i);
			}
		}
		
		public String getComment() {
			return comment;
		}
		
		public String getDef() {
			return def;
		}
		
		public VarTypes getType() {
			return type;
		}
		
		public String getValue() {
			return Value;
		}
		
		public void setValue(String value) {
			
			Value = value;
		}
	}
	
	
}
