package manageryzy.MFCGenerator.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TemplateObjectManager {
	Map<String,TemplateObject> TemplateMap;
	
	public TemplateObjectManager(String DataPath) throws Exception {
		TemplateMap = new HashMap<String, TemplateObject>();
		
		File DataDir = new File(DataPath);
		
		if(!DataDir.exists())
			throw new Exception("Data dir not exist!");
		
		AddTamplateObject(DataDir);
	}
	
	void AddTamplateObject(File Dir)
	{
		File[] files = Dir.listFiles();
		
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory())
			{
				AddTamplateObject(files[i]);
			}
			else
			{
				TemplateObject newObject = new TemplateObject(files[i]);
				TemplateMap.put(newObject.getNameSpace(), newObject);
			}
			
		}
	}
	
	public Map<String, TemplateObject> getTemplateMap() {
		return TemplateMap;
	}
}
