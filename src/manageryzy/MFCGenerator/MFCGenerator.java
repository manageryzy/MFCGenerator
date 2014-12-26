package manageryzy.MFCGenerator;

public class MFCGenerator {
	enum ARG{none,data_path,update_source,tasks};
	enum Tasks{init,build,update};
	
	public static MFCGenerator theMFCGenerator;
	
	boolean isGUIEnabled = false;
	String TargetPath = null;
	String DataPath = "./data/";
	String UpdateSource = null;
	Tasks theTask =Tasks.build;
	
	
	
	public void setGUIEnabled(boolean isGUIEnabled) {
		this.isGUIEnabled = isGUIEnabled;
	}
	
	public void setTargetPath(String targetPath) {
		TargetPath = targetPath;
	}
	
	public void setDataPath(String dataPath) {
		DataPath = dataPath;
	}
	
	public void setTheTask(Tasks theTask) {
		this.theTask = theTask;
	}
	
	public void setUpdateSource(String updateSource) {
		UpdateSource = updateSource;
	}
	
	public String getUpdateSource() {
		return UpdateSource;
	}
	
	public Tasks getTheTask() {
		return theTask;
	}
	
	public String getDataPath() {
		return DataPath;
	}
	
	public String getTargetPath() {
		return TargetPath;
	}
	
	public void PrintHelp()
	{
		System.out.print("Welcome to use Minecraft Forge Generator.\nHelp file Will be ready soon");
	}
	
	/**
	 * the main method of the program
	 */
	public void run()
	{
		
	}
	
	public static void main(String[] args) {
		theMFCGenerator = new MFCGenerator();
		
		if(args.length == 0)
		{
			theMFCGenerator.PrintHelp();
			System.exit(0);
		}
		ARG nowArgTask = ARG.none;
		
		for(int i = 0;i<args.length;i++)
		{
			switch(nowArgTask)
			{
			case data_path:
				nowArgTask = ARG.none;
				theMFCGenerator.setDataPath(args[i]);
				break;
			case none:
				if(args[i].startsWith("-"))
				{
					switch(args[i])
					{
					case "-GUI":
					case "-g":
						theMFCGenerator.setGUIEnabled(true);
						break;
					case "-h":
					case "-?":
					case "-Help":
						theMFCGenerator.PrintHelp();
						System.exit(0);
						break;
					case "-t":
					case "-Tasks":
						nowArgTask = ARG.tasks;
						break;
					case "-s":
					case "Source":
						nowArgTask = ARG.update_source;
						break;
					case "-d":
					case "-DataSource":
						nowArgTask = ARG.data_path;
					}
				}
				else
				{
					if(theMFCGenerator.getTargetPath() != null)
					{
						theMFCGenerator.PrintHelp();
						System.exit(-1);
					}
					theMFCGenerator.setTargetPath(args[i]);
				}
				break;
			case tasks:
				nowArgTask = ARG.none;
				switch(args[i])
				{
				case "init":
					theMFCGenerator.setTheTask(Tasks.init);
					break;
				case "build":
					theMFCGenerator.setTheTask(Tasks.build);
					break;
				case "update":
					theMFCGenerator.setTheTask(Tasks.update);
					break;
				}
				break;
			case update_source:
				nowArgTask = ARG.none;
				
				break;
			default:
				System.err.println("A impossable state got when dealing input args!");
				System.exit(-1);
			}
			
		}
		
		theMFCGenerator.run();
	}
}
