package tool.recommendation.engines.entity;

import java.util.List;

public class CSVObject {
	List<String> lstName;
	List<List<String>> lstRecords;
	
	public CSVObject(List<String> lstName, List<List<String>> lstRecords) {
		super();
		this.lstName = lstName;
		this.lstRecords = lstRecords;
	}
	
	public List<String> getLstName() {
		return lstName;
	}
	public void setLstName(List<String> lstName) {
		this.lstName = lstName;
	}
	public List<List<String>> getLstRecords() {
		return lstRecords;
	}
	public void setLstRecords(List<List<String>> lstRecords) {
		this.lstRecords = lstRecords;
	}
}
