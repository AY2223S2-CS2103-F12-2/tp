package codoc.ui.infopanel;

import java.util.logging.Logger;

import codoc.commons.core.LogsCenter;
import codoc.model.person.Person;
import codoc.ui.UiPart;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * Panel containing detailed information about a person.
 */
public class InfoTab extends UiPart<Region> {

    private static final String FXML = "InfoTab.fxml";
    private final Logger logger = LogsCenter.getLogger(InfoTab.class);

    private DetailedInfo detailedInfo;

    @FXML
    private Label name;

    @FXML
    private Label identity;

    @FXML
    private StackPane detailedInfoPlaceholder;

    /**
     * Creates a {@code InfoTab} with the given {@code protagonist} and {@code tab}.
     */
    public InfoTab(Person protagonist, String tab) {

        super(FXML);
        if (tab != null) {
            if (tab.equals("c")) {
                detailedInfo = new DetailedContact(protagonist);
            } else if (tab.equals("m")) {
                detailedInfo = new DetailedModule(protagonist);
            } else {
                detailedInfo = new DetailedSkill(protagonist);
            }
        }

        if (protagonist != null) {
            name.setText(protagonist.getName().fullName);
            StringBuilder sb = new StringBuilder();
            sb.append("Year ");
            sb.append(protagonist.getYear());
            sb.append(", ");
            sb.append(protagonist.getCourse().toString());
            identity.setText(sb.toString());
            detailedInfoPlaceholder.getChildren().add(detailedInfo.getRoot());
        }
    }

}
