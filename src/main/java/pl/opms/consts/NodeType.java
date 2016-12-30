package pl.opms.consts;

/**
 * Created by Piotr Borczyk on 22.11.2016.
 */
public enum NodeType {
    STRING("nodetype.string"),
    INT("nodetype.int"),
    DOUBLE("nodetype.double"),
    BOOL_CHECK_BOX("nodetype.bool");

    private String displayName;

    NodeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
