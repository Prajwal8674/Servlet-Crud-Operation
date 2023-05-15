package project_1;

public class pojoOne {

	private String uname;
	private String uemail;
	private String upass;
	private String uid;

	/*public pojoOne(String uname, String uemail, String upass, String uid) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upass = upass;
		this.uid = uid;
	}
*/
	public pojoOne() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public pojoOne(String uname, String uemail, String upass) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upass = upass;
	}
	public pojoOne (String uemail , String upass){
		super();
		this.uemail = uemail;
		this.upass = upass;
	}
	
	

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}
	

}
