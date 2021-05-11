package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ProjectMode {
    SINGLE_FOR_ALL_CASES(1),
    SINGLE_FOR_WITH_BASELINE(2),
    MULTIPLE(3);

    private final int value;

    public static ProjectMode getEnumByValue(int value) {
        for (var mod : ProjectMode.values()) {
            if (mod.getValue() == value)
                return mod;
        }
        throw new IllegalArgumentException("No enum constant with value" + value);
    }
    public static ProjectMode getEnumByValue(String value){
        return getEnumByValue(Integer.parseInt(value));
    }
}
