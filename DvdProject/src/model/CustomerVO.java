package model;

public class CustomerVO {
	private int c_no;
	private String c_name;
	private int c_phone;
	private String c_address;
	private String c_id;
	private String c_passwd;

	public CustomerVO() {
		super();
	}

	public CustomerVO(int c_no, String c_name, int c_phone, String c_address, String c_id, String c_passwd) {
		super();
		this.c_no = c_no;
		this.c_name = c_name;
		this.c_phone = c_phone;
		this.c_address = c_address;
		this.c_id = c_id;
		this.c_passwd = c_passwd;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_phone() {
		return c_phone;
	}

	public void setC_phone(int c_phone) {
		this.c_phone = c_phone;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_passwd() {
		return c_passwd;
	}

	public void setC_passwd(String c_passwd) {
		this.c_passwd = c_passwd;
	}

	@Override
	public String toString() {
		return "CustomerVO [c_no=" + c_no + ", c_name=" + c_name + ", c_phone=" + c_phone + ", c_address=" + c_address
				+ ", c_id=" + c_id + ", c_passwd=" + c_passwd + "]";
	}

}
