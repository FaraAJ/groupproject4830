public class Member 
{
	private String uname,password,phone;
	public Member() {
		super();
	}
	public Member(String uname, String password, String phone) {
		super();
		this.uname = uname;
		this.password = password;
		this.phone = phone;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}