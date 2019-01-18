package enums;

public enum SistemasPath {
	
	WINDOWS_X32("/win-32/bin/"),
	WINDOWS_X64("/win-64/bin/"),
	LINUX_X32("/linux-32/bin/"),
	LINUX_X64("/linux-64/bin/");
	
	private String path;
	
	private SistemasPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	

}
