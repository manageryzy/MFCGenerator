package manageryzy.MFCGenerator.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONObject;

public class Project {
	
	File projectFile;
	File projectDir;
	JSONObject theJson;
	
	String ProjectName;
	
	public Project(String path) throws Exception {
		projectDir = new File(path);
		
		if(!projectDir.exists())
		{
			if(!projectDir.mkdirs())
			{
				throw new Exception("Can't create project dir!");
			}
		}
		
		if(!projectDir.isDirectory())
		{
			throw new Exception("target is not a dir!");
		}
		
		projectFile = new File(projectDir, ".project");
		
		if(projectFile.exists())
		{
			
		}
	}
	
	public boolean load()
	{
		try {

	        FileInputStream in=new FileInputStream(projectFile);

	        // size  为字串的长度 ，这里一次性读完

	        int size=in.available();

	        byte[] buffer=new byte[size];

	        in.read(buffer);

	        in.close();

	        theJson = new JSONObject(new String(buffer));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
		
		ProjectName = theJson.getString("ProjectName");
		
		
		return true;
	}
	
}
