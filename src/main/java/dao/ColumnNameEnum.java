package dao;

public enum ColumnNameEnum {

	CUSTOMER_NAME("Customer Name"), DESTINATION("DESTINATION"), LOCATION("LOCATION TYPE"), REGION("REGION"),
	LR("LR Nos.");

	final String columnName;

	ColumnNameEnum(String value) {
		this.columnName = value;
	}

	public String getColumnName() {
		return columnName;
	}

}
