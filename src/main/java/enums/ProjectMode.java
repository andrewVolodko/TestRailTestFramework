package enums;

public enum ProjectMode {
    SINGLE_FOR_ALL_CASES("1"),
    SINGLE_FOR_WITH_BASELINE("2"),
    MULTIPLE("3");

    private final String value;

    ProjectMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ProjectMode getEnumByValue(String value) {
        for (var mod : ProjectMode.values()) {
            if (mod.getValue().equals(value))
                return mod;
        }
        throw new IllegalArgumentException("No enum constant with value" + value);
    }
}
