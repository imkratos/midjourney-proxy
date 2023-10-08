package com.github.novicezk.midjourney.enums;

public enum SettingsEnum {
    TURBO("TurboMode"),
    FAST("FastMode"),
    RELAX("RelaxMode"),
    RESET("ResetSettings"),
    RAW("Style::raw"),
    STYLIZE("Stylization::50"),
    MED("Stylization::100"),
    HIGH("Stylization::250"),
    VERY_HIGH("Stylization::750"),
    PUBLIC_MODE("PrivateMode::off"),
    REMIX("RemixMode"),
    HIGH_VARIATION("HighVariabilityMode::1"),
    LOW_VARIATION("HighVariabilityMode::0"),


    ;


    private String value;

    private SettingsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
