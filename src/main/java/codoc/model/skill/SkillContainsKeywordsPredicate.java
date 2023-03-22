package codoc.model.skill;

import java.util.List;
import java.util.function.Predicate;

import codoc.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Skill} matches any of the keywords given.
 */
public class SkillContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public SkillContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    private boolean noKeywords() {
        return keywords.get(0).isEmpty();
    }

    private boolean personHaveNoSkills(Person person) {
        return person.getSkills().isEmpty();
    }

    private boolean doesNotContain(String skillUserIsSearchingFor, Person person) {
        return person.getSkills().stream().noneMatch(
                skill -> skill.skillName.equalsIgnoreCase(skillUserIsSearchingFor));
    }

    @Override
    public boolean test(Person person) {

        if (noKeywords()) {
            return personHaveNoSkills(person);
        }

        for (String word : keywords) {
            if (doesNotContain(word, person)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SkillContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((SkillContainsKeywordsPredicate) other).keywords)); // state check
    }
}
