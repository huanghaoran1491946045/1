package cn.edu.jsu.hhr.vo;

public class player {
	private String name;
	private String height;
	private String averagescore;
	private String location;
	private String playernumber;
	private String team;
	private String servicestatus;
	public player(){}
	public player(String name,String height,String averagescore,String location,String playernumber,String team,String servicestatus){
		this.name=name;
		this.height=height;
		this.averagescore=averagescore;
		this.location=location;
		this.playernumber=playernumber;
		this.team=team;
		this.servicestatus=servicestatus;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getAveragescore() {
		return averagescore;
	}
	public void setAveragescore(String averagescore) {
		this.averagescore = averagescore;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPlayernumber() {
		return playernumber;
	}
	public void setPlayernumber(String playernumber) {
		this.playernumber = playernumber;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getServicestatus() {
		return servicestatus;
	}
	public void setServicestatus(String servicestatus) {
		this.servicestatus = servicestatus;
	}
	@Override
	public String toString() {
		return "player [name=" + name + ", height=" + height + ", averagescore=" + averagescore + ", location="
				+ location + ", playernumber=" + playernumber + ", team=" + team + ", servicestatus=" + servicestatus
				+ "]";
	}
	
}
