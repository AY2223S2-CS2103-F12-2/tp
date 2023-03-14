package codoc.ui.infopanel;

import codoc.model.person.Person;

/**
 * DetailedContact controller for showing contact details at DetailedInfoPanel.
 */
public class DetailedContact extends DetailedInfo {

    private static final String FXML = "DetailedContact.fxml";

    public DetailedContact(Person protagonist) {
        super(FXML);
    }

}
