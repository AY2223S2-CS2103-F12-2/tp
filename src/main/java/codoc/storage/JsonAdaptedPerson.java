package codoc.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import codoc.commons.exceptions.IllegalValueException;
import codoc.model.person.Email;
import codoc.model.person.Name;
import codoc.model.person.Person;
import codoc.model.skill.Skill;
import codoc.model.module.Module;
import codoc.model.person.Address;
import codoc.model.person.Phone;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final List<JsonAdaptedSkill> skills = new ArrayList<>();
    private final List<JsonAdaptedModule> modules = new ArrayList<>();


    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("address") String address,
            @JsonProperty("skills") List<JsonAdaptedSkill> skills,
            @JsonProperty("modules") List<JsonAdaptedModule> modules) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (skills != null) {
            this.skills.addAll(skills);
        }
        if (modules != null) {
            this.modules.addAll(modules);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        skills.addAll(source.getSkills().stream()
                .map(JsonAdaptedSkill::new)
                .collect(Collectors.toList()));
        modules.addAll(source.getModules().stream()
                .map(JsonAdaptedModule::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Skill> personSkills = new ArrayList<>();
        final List<Module> personModules = new ArrayList<>();
        for (JsonAdaptedSkill skill : skills) {
            personSkills.add(skill.toModelType());
        }
        for (JsonAdaptedModule module : modules) {
            personModules.add(module.toModelType());
        }
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone != null && !Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address != null && !Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        final Set<Skill> modelSkills = new HashSet<>(personSkills);
        final Set<Module> modelModules = new HashSet<>(personModules);
        return new Person(modelName, modelPhone, modelEmail, modelAddress, modelSkills, modelModules);
    }

}
