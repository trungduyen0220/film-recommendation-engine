package tool.recommendation.engines.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import tool.recommendation.engines.entity.CSVObject;

public class CSVUtils {
	
	public static CSVObject readCSV(String fileName) {
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			
			List<String> tableColumnsName = new ArrayList<>();
			String[] tableColumns = line.split(csvSplitBy);
			for (int i = 0; i < tableColumns.length; i++) {
				tableColumnsName.add(tableColumns[i]);
			}

			line = br.readLine();
			List<List<String>> tableRecords = new ArrayList<>();
			while (line != null) {
//				String[] records = line.split(csvSplitBy);

				List<String> records = new ArrayList<>();
				
				int pointer = 0;
				int startPointer = 0;
				int nextPointer = line.indexOf(",");
				while( pointer <= line.length()) {
					String itemCheck = "";
					//Check if the next pointer is comma
					if(pointer == nextPointer) {
						//If the pointer before is \", it a String/List of String
						if(line.substring(nextPointer - 1, nextPointer).equals("\"")) {
							//OK
							itemCheck = line.substring(startPointer + 1, nextPointer - 2); 
							startPointer = pointer + 1;
							records.add(itemCheck);

						//If not, check if it is a number
						} else {
							itemCheck =  line.substring(startPointer, nextPointer); 
							if (CommonUtils.isInteger(itemCheck) ) {
								startPointer = pointer + 1;
								records.add(itemCheck);
							}
						}
						//If not a number, go to next comma
						nextPointer = line.indexOf(",", pointer + 1);
					}
					if(pointer == line.length()-1) {
						itemCheck =  line.substring(line.lastIndexOf(",") + 1, pointer); 
						records.add(itemCheck);
					}
					pointer++;
				}
				
				tableRecords.add(records);
				line = br.readLine();
			}
			br.close();
			return new CSVObject(tableColumnsName, tableRecords);
		} catch (Exception e) {
		}
		return null;
	}
}
