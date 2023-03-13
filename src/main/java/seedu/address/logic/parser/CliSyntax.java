package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_SKILL_ADD = new Prefix("s+/");
    public static final Prefix PREFIX_SKILL_DELETE = new Prefix("s-/");
    public static final Prefix PREFIX_SKILL_OLD = new Prefix("so/");
    public static final Prefix PREFIX_SKILL_NEW = new Prefix("sn/");
    public static final Prefix PREFIX_MOD_ADD = new Prefix("m+/");
    public static final Prefix PREFIX_MOD_DELETE = new Prefix("m-/");
    public static final Prefix PREFIX_MOD_OLD = new Prefix("mo/");
    public static final Prefix PREFIX_MOD_NEW = new Prefix("mn/");

}
