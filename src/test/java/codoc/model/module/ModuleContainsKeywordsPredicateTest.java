package codoc.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import codoc.model.person.NameContainsKeywordsPredicate;
import codoc.testutil.PersonBuilder;

public class ModuleContainsKeywordsPredicateTest {

    @Test
    public void test_keywords_returnsTrue() {
        // Single input
        ModuleContainsKeywordsPredicate predicate = new ModuleContainsKeywordsPredicate(List.of("AY2019S2", "CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // Empty input
        predicate = new ModuleContainsKeywordsPredicate(List.of(""));
        assertTrue(predicate.test(new PersonBuilder().withModules().build()));

        // Only academic year
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2019S2"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No academic year, matching module
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No academic year, matching module is last
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2019S2 CS3230", "AY2020S1 CS2103T", "AY2619S1 CS2106").build()));

        // Multi-input
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "AY2020S1", "CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withModules("AY2020S1 CS2103T", "AY2020S1 CS3230", "AY2619S1 CS2106").build()));

    }

    @Test
    public void test_keywords_returnsFalse() {
        // No academic year, no module
        ModuleContainsKeywordsPredicate predicate = new ModuleContainsKeywordsPredicate(List.of(""));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No academic year, no matching module
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2103X"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No matching academic year, no module
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2222S2"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No matching academic year
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2222S2", "CS2103T"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No matching module
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2019S2", "CS2103X"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // No matching academic year,  No matching module
        predicate = new ModuleContainsKeywordsPredicate(List.of("AY2222S2", "CS2103X"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // Multi-input
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "AY2222S2", "CS2103T"));
        assertFalse(predicate.test(new PersonBuilder().withModules("AY2019S2 CS2103T", "AY2020S1 CS2103T").build()));

        // Empty Module
        predicate = new ModuleContainsKeywordsPredicate(List.of("CS2106", "CS3230", "AY2020S1", "CS2103T"));
        assertFalse(predicate.test(new PersonBuilder().withModules().build()));
    }
}
