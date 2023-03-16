package codoc.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import codoc.commons.core.Messages;
import codoc.model.Model;
import codoc.model.person.Person;

/**
 * Finds and lists all persons in CoDoc whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) split by prefixes and displays them as a list with index "
            + "numbers.\n"
            + "Parameters: PREFIX/KEYWORD [MORE_KEYWORDS]... [PREFIX/KEYWORD [MORE_KEYWORDS]...]...\n"
            + "Example: " + COMMAND_WORD + " n/alice bob charlie y/2 3 c/cs bza";

    private final Predicate<Person> predicate;

    public FindCommand(Predicate<Person> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && predicate.equals(((FindCommand) other).predicate)); // state check
    }
}
