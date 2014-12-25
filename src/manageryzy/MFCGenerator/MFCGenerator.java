package manageryzy.MFCGenerator;

public class MFCGenerator {
	public static MFCGenerator theMFCGenerator;
	
	boolean isGUIEnabled = false;
	String TargetPath = null;
	
	public void setGUIEnabled(boolean isGUIEnabled) {
		this.isGUIEnabled = isGUIEnabled;
	}
	
	public void setTargetPath(String targetPath) {
		TargetPath = targetPath;
	}
	
	public String getTargetPath() {
		return TargetPath;
	}
	
	public void PrintHelp()
	{
		System.out.print("");
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
		
		for(int i = 0;i<args.length;i++)
		{
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
		}
		
		theMFCGenerator.run();
	}
}
