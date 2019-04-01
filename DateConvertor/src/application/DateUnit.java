package application;

public enum DateUnit {

	SECOND(-1, "secondes"),
	MINUTE(60, "minutes"),
	HOUR(60, "heures"),
	DAY(24, "jours"),
	MONTH(30, "mois");

	private final int timeUnit;
	private final String frenchUnitName;

	private DateUnit(int timeUnit, String frenchUnitName) {
		this.timeUnit = timeUnit;
		this.frenchUnitName = frenchUnitName;
	}

	public static long convertTime(DateUnit baseDateUnit, long amount, DateUnit dateUnit) {
		return baseDateUnit.ordinal() <= dateUnit.ordinal() ? amount : amount * convertTime(
				DateUnit.values()[baseDateUnit.ordinal() - 1],
				baseDateUnit.timeUnit, dateUnit);
	}

	public static DateUnit getDateUnitByName(String frName) {
		for (DateUnit du : DateUnit.values())
			if (du.frenchUnitName.equalsIgnoreCase(frName) || frName.equalsIgnoreCase(du.toString())) return du;

		return null;
	}

}
