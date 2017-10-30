import org.apache.commons.cli.*;


public class Main
{
	public static void main(String args[])
	{
		String line_type = "N/A";
		String[] line_list;
		String line_key = "N/A";
		int result = 0;
		Options options = new Options();
		CommandLineParser parser = new DefaultParser();
		
		Option type = Option.builder()
				.longOpt("type")
				.hasArg()
				.desc("s is for strings and i is for integers")
				.build();
		options.addOption(type);
		
		Option key = Option.builder()
				.longOpt("key")
				.hasArg()
				.desc("key to search for")
				.build();
		options.addOption(key);
		
		Option list = Option.builder()
				.longOpt("list")
				.hasArg()
				.desc("list of values")
				.build();
		list.setArgs(Option.UNLIMITED_VALUES);
		
		options.addOption(list);
		
		
		try
		{
			CommandLine cline = parser.parse(options, args);
			
			if(cline.hasOption("type"))
			{
				line_type = cline.getOptionValue("type");
			}
			
			if(cline.hasOption("list"))
			{
				line_list = cline.getOptionValues("list");
				
				if(cline.hasOption("key"))
				{
					line_key = cline.getOptionValue("key");
				}
				
				if(line_type.equals("s"))
				{
					result = binarySearch(line_list,line_key);
				}
				else if(line_type.equals("i"))
				{
					result = binarySearch(line_list,line_key);
				}
				else
				{
					System.out.println("Unrecognized type. Ending program.");
					System.exit(0);
				}
				
				
			}
			
		}
		catch(ParseException e)
		{
			System.out.println("Error: Parsing was unsuccessful. Terminating program");
			System.exit(0);
		}
		
		System.out.println(result);
		
	}
	
	public static int binarySearch(String[] a, String x)
	{
		int low = 0, mid = 0, high = a.length-1;
		
		while(low<= high)
		{
			mid = (low + high)/2;
			
			if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return 1;
            }
			
		}
		
		return 0;
		
	}
	
}