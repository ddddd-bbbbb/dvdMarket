package model;

public class BasketVO {
	private int b_no;
	private int b_quantity;
	private int b_totalprice;
	private int c_no;
	private int d_no;

	public BasketVO() {
		super();
	}

	public BasketVO(int b_no, int b_quantity, int b_totalprice, int c_no, int d_no) {
		super();
		this.b_no = b_no;
		this.b_quantity = b_quantity;
		this.b_totalprice = b_totalprice;
		this.c_no = c_no;
		this.d_no = d_no;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getB_quantity() {
		return b_quantity;
	}

	public void setB_quantity(int b_quantity) {
		this.b_quantity = b_quantity;
	}

	public int getB_totalprice() {
		return b_totalprice;
	}

	public void setB_totalprice(int b_totalprice) {
		this.b_totalprice = b_totalprice;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	@Override
	public String toString() {
		return "BasketVO [b_no=" + b_no + ", b_quantity=" + b_quantity + ", b_totalprice=" + b_totalprice + ", c_no="
				+ c_no + ", d_no=" + d_no + "]";
	}

}
