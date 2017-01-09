package pl.opms.consts;

/**
 * Created by Val on 2016-11-24.
 */
public enum Gender {
    MALE("gender.male"),
    FEMALE("gender.female");

    private String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
