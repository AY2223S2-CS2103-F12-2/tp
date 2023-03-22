package codoc.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import codoc.testutil.PersonBuilder;

public class ModuleContainsKeywordsPredicateTest {

    @Test
    public void test_keywords_returnsTrue() {
        // Empty input
        ModuleContainsKeywordsPredicate predicate = new ModuleContainsKeywordsPredicate(List.of(""));
        assertTrue(predicate.test(new PersonBuilder().withModules().build()));

        // Single academic year that match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2020S1"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Multiple academic year, where all match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2020S1", "AY2019S2"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Single module that match
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Multiple module, where all match
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2101", "CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Single academic year and module that match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2019S2 CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Multi-input, where all match
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "AY2022S1", "CS2101", "AY2020S1", "CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2022S1 CS2101", "AY2020S1 CS2103T", "AY2020S1 CS3230", "AY2619S1 CS2106").build()));

    }

    @Test
    public void test_keywords_returnsFalse() {
        // Empty input
        ModuleContainsKeywordsPredicate predicate = new ModuleContainsKeywordsPredicate(List.of(""));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // Single academic year with no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2222S2"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Multiple academic year, where at least one has no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2019S2", "AY2222S2"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Single module with no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS3230"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Multiple module, where at least one has no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2101", "CS3230"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Single academic year and module where module has no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2019S2 CS3230"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Single academic year and module where academic year has no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2018S2 CS2103T"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Single academic year and module where both has no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2018S2 CS3230"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2101").build()));

        // Multi-input, where at least one has no match
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "AY2022S1", "CS4101", "AY2020S1", "CS2103T"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2022S1 CS2101", "AY2020S1 CS2103T", "AY2020S1 CS3230", "AY2619S1 CS2106").build()));

        // Person have no modules
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "AY2020S1", "CS2103T"));
        assertFalse(predicate.test(new PersonBuilder().withModules().build()));
    }
}
