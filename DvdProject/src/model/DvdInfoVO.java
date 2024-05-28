package model;

public class DvdInfoVO {
	private int d_no;
	private String d_name;
	private String d_director;
	private String d_category;
	private int d_year;
	private String d_description;
	private int d_price;

	public DvdInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DvdInfoVO(int d_no, String d_name, String d_director, String d_category, int d_year, String d_description,
			int d_price) {
		super();
		this.d_no = d_no;
		this.d_name = d_name;
		this.d_director = d_director;
		this.d_category = d_category;
		this.d_year = d_year;
		this.d_description = d_description;
		this.d_price = d_price;
	}

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_director() {
		return d_director;
	}

	public void setD_director(String d_director) {
		this.d_director = d_director;
	}

	public String getD_category() {
		return d_category;
	}

	public void setD_category(String d_category) {
		this.d_category = d_category;
	}

	public int getD_year() {
		return d_year;
	}

	public void setD_year(int d_year) {
		this.d_year = d_year;
	}

	public String getD_description() {
		return d_description;
	}

	public void setD_description(String d_description) {
		this.d_description = d_description;
	}

	public int getD_price() {
		return d_price;
	}

	public void setD_price(int d_price) {
		this.d_price = d_price;
	}

	@Override
	public String toString() {
		return "DvdinfoVO [d_no=" + d_no + ", d_name=" + d_name + ", d_director=" + d_director + ", d_category="
				+ d_category + ", d_year=" + d_year + ", d_description=" + d_description + ", d_price=" + d_price + "]";
	}

}
