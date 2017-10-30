package com.joytec.src.beans;

/**
 * @author joytec
 *
 */
public class GWork {

	// 社員コード
	private String employeeCd;

	// 勤務年月日
	private String businessDay;

	// 勤務開始時間
	private String workStart;

	// 勤務終了時間
	private String workEnd;

	// コンストラクタ
	public GWork(String employeeCd, String businessDay, String workStart, String workEnd) {
		this.employeeCd = employeeCd;
		this.businessDay = businessDay;
		this.workStart = workStart;
		this.workEnd = workEnd;

	}

	/**
	 * @return employeeCd
	 */
	public String getEmployeeCd() {
		return employeeCd;
	}

	/**
	 * @param employeeCd
	 *            セットする employeeCd
	 */
	public void setEmployeeCd(String employeeCd) {
		this.employeeCd = employeeCd;
	}

	/**
	 * @return businessDay
	 */
	public String getBusinessDay() {
		return businessDay;
	}

	/**
	 * @param businessDay
	 *            セットする businessDay
	 */
	public void setBusinessDay(String businessDay) {
		this.businessDay = businessDay;
	}

	/**
	 * @return workStart
	 */
	public String getWorkStart() {
		return workStart;
	}

	/**
	 * @param workStart
	 *            セットする workStart
	 */
	public void setWorkStart(String workStart) {
		this.workStart = workStart;
	}

	/**
	 * @return workEnd
	 */
	public String getWorkEnd() {
		return workEnd;
	}

	/**
	 * @param workEnd
	 *            セットする workEnd
	 */
	public void setWorkEnd(String workEnd) {
		this.workEnd = workEnd;
	}

}
