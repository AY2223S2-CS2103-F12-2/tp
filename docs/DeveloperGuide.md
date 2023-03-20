---
layout: page
title: Developer Guide
---
## Table of Contents
- [CoDoc Developer Guide](#codoc-developer-guide)
- [Navigating the Developer Guide](#navigating-the-developer-guide)
- [Glossary](#glossary)
- [Acknowledgements](#acknowledgements)
- [Setting up](#setting-up-getting-started)
- [Design](#design)
  - [Architecture](#architecture)
  - [UI Component](#ui-component)
  - [Logic Component](#logic-component)
  - [Model Component](#model-component)
  - [Storage Component](#storage-component)
  - [Common Classes](#common-classes)
- [Implementation](#implementation)
  - [Find Contacts](#find-feature)
- [Documentation, logging, testing, configuration, dev-ops](#documentation-logging-testing-configuration-dev-ops)
- [Appendix: Requirements](#appendix-requirements)
  - [Product Scope](#product-scope-%EF%B8%8F)
  - [User Stories](#user-stories-)
  - [Use Cases](#use-cases)
  - [Non-functional Requirements](#non-functional-requirements)
- [Appendix: Instructions for Manual Testing](#appendix-instructions-for-manual-testing)

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## **CoDoc Developer Guide**

CoDoc is **designed for NUS School of Computing students** by providing a centralised platform for them to keep track
of their friends' contact information, modules and skills. CoDoc is **optimised for use via a Command Line Interface** (CLI)
while still having the benefits of a **Graphical User Interface** (GUI).

For students who are fast typers, CoDoc is an excellent platform for you to find and identify your friends with certain capabilities and experience, 
so you can spend less time searching through chats, and spend more time making
meaningful connections and engaging in productive work.

The goal of this Developer Guide is to document and illustrate the underlying architecture of CoDoc, and provide
insights on how our product is designed, implemented and tested as well as the design considerations that were involved
in the deciding the implementation of various features offered by ConnectNUS.

You are recommended to read the [Navigating the Developer Guide](#navigating-the-developer-guide) and [Glossary](#glossary)
sections, which will provide the necessary information to allow you to familiarise yourself with the structure of this
Developer Guide and help you navigate it with ease.

--------------------------------------------------------------------------------------------------------------------

## **Navigating the Developer Guide**

The Developer Guide is divided into the following sections :
- [Design](#design)
- [Implementation](#implementation)
- [Documentation, logging, testing, configuration, dev-ops](#documentation-logging-testing-configuration-dev-ops)
- [Appendix: Requirements](#appendix-requirements)
- [Appendix: Instructions for Manual Testing](#appendix-instructions-for-manual-testing)

The [Design](#design) section gives an overview of the architecture of ConnectNUS.
In this section, you will be provided with:

1. The API (Application Programming Interface) of the major components of CoDoc.
2. A Class Diagram to illustrate the internals of each component.
3. An explanation of how each component works.
4. A Sequence Diagram to give an example of the flow of events within the component where applicable.

The [Implementation](#implementation) section outlines how the features offered by CoDoc are
implemented. In this section, you will be provided with:

1. A description of the feature.
2. Some example commands to execute to use the feature.
3. A Class Diagram or screenshot to illustrate and explain the implementation of each feature where applicable.
4. A Sequence Diagram to give an example of the implementation flow of the feature where applicable.
5. An Activity Diagram to show all possible behaviours of the feature where applicable.
6. An Object Diagram to model relationships between objects of the same components where applicable.
7. Design considerations and alternatives taken into consideration that justifies our implementation of the feature.

The [Documentation, logging, testing, configuration, dev-ops](#documentation-logging-testing-configuration-dev-ops) section
provides the links to the aforementioned documents. In this section, you will be provided with the links to:

1. Documentation guide.
2. Testing guide.
3. Logging guide.
4. Configuration guide.
5. DevOps guide.

The [Appendix: Requirements](#appendix-requirements) section provides details on the motivation behind creating CoDoc
and how we intend for users to use ConnectNUS.
In this section, you will be provided with
1. Product Scope.
2. User Stories.
3. Use Cases.
4. Non-functional requirements.

The [Appendix: Instructions for Manual Testing](#appendix-instructions-for-manual-testing) section gives detailed instructions
on how you can perform testing on the features in CoDoc. In this section, you will be provided with:
1. An overview of the command to execute to test the feature.
2. Sample test cases to be executed.
3. The expected behaviour of the test command.

You can jump into the various sections from the Table of Contents to view different sections of the Developer Guide, and
click on [Scroll back to top](#table-of-contents), which can be found at the end of every section, to access the Table
of Contents to quickly jump to another section.

We would recommend you to read the [Glossary](#glossary) section next.

[Scroll back to top](#table-of-contents)

<div style="page-break-after: always;"></div>

## **Glossary**

The glossary illustrated in the table below will help you understand the terminologies used in this
Developer Guide.

<table>
  <tr>
    <th><strong>Terminology</strong></th>
    <th><strong>Meaning / Purpose</strong></th>
  </tr>
  <tr>
    <td><strong>Command Line Interface (CLI)</strong></td>
    <td>
      A text-based interface that is used to operate software (such as ConnectNUS) and operating systems. CLI
      allows a user to perform tasks by entering commands. <br>
      Users enter the specific command, press “Enter”, and then wait for a response.
      After receiving the command, the CLI processes it accordingly and shows the output/result on the screen.
    </td>
  </tr>
  <tr>
    <td><strong>Graphical User Interface (GUI)</strong></td>
    <td>
      A system of interactive visual components for computer software. A GUI displays objects that convey information,
      and represent actions that can be taken by the user. The objects change color, size, or visibility when the user
      interacts with them.
    </td>
  </tr>
  <tr>
    <td><strong>Application Programming Interface (API)</strong></td>
    <td>
      A a set of definitions and protocols for building and integrating application software and simplifies how
      developers integrate new application components into an existing architecture.
    </td>
  </tr>
  <tr>
    <td><strong>Mainstream OS</strong></td>
    <td>
      Windows, Linux, Unix, OS-X.
    </td>
  </tr>
  <tr>
    <td><strong>Private Contact Detail</strong></td>
    <td>
      A contact detail that is not meant to be shared with others.
    </td>
  </tr>
  <tr>
    <td><strong>Architecture</strong></td>
    <td>
      Shows the overall organization of the system and can be viewed as a very high-level design.
      Consists of a set of interacting components that fit together to achieve the required functionality . It is a
      simple and technically viable structure that is well-understood and agreed-upon by everyone in the development
      team, and it forms the basis for the implementation..
    </td>
  </tr>
  <tr>
    <td><strong>Class Diagram</strong></td>
    <td>
      Describe the structure but not the behavior of an Object-Oriented Programming (OOP) solution.
    </td>
  </tr>
  <tr>
    <td><strong>Object-Oriented Programming (OOP)</strong></td>
    <td>
      A computer programming model that organizes software design around data, or objects, rather than functions and logic.
      An object can be defined as a data field that has unique attributes and behavior.
    </td>
  </tr>
  <tr>
    <td><strong>Sequence Diagram</strong></td>
    <td>
      Captures the interactions between multiple objects for a given scenario.
    </td>
  </tr>
  <tr>
    <td><strong>Activity Diagram</strong></td>
    <td>
      Models workflows, which define the flow in which a process or a set of tasks is executed.
    </td>
  </tr>
  <tr>
    <td><strong>Object Diagram</strong></td>
    <td>
      Used to complement class diagrams. Object diagrams can be used to model different object
      structures that can result from a design represented by a given class diagram.
    </td>
  </tr>
  <tr>
    <td><strong>User Stories</strong></td>
    <td>
       Short, simple descriptions of a feature told from the perspective of the person who desires the new capability,
       usually a user or customer of the system.
    </td>
  </tr>
  <tr>
    <td><strong>Use Case</strong></td>
    <td>
      Describes an interaction between the user and the system for a specific functionality of the system.
    </td>
  </tr>
  <tr>
    <td><strong>Teaching Assistant</strong></td>
    <td>
      Employed staff by NUS who teach tutorials for specific modules for undergraduates. They will be guided by the module coordinators or instructors.
    </td>
  </tr>
</table>

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

* {list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

[Scroll back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

[Scroll back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## **Design**

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.
</div>

[Scroll back to top](#table-of-contents)

### Architecture

<img src="images/ArchitectureDiagram.png" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** has two classes called [`Main`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.


**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<img src="images/ComponentManagers.png" width="300" />

The sections below give more details of each component.

[Scroll back to top](#table-of-contents)

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/ui/Ui.java)

![Structure of the UI Component](images/UiClassDiagram.png)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

[Scroll back to top](#table-of-contents)

### Logic component

**API** : [`Logic.java`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<img src="images/LogicClassDiagram.png" width="550"/>

How the `Logic` component works:
1. When `Logic` is called upon to execute a command, it uses the `CodocParser` class to parse the user command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `AddCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to add a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

The Sequence Diagram below illustrates the interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<img src="images/ParserClasses.png" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `CodocParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `CodocParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

[Scroll back to top](#table-of-contents)

### Model component
**API** : [`Model.java`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/model/Model.java)

<img src="images/ModelClassDiagram.png" width="450" />


The `Model` component,

* stores CoDoc data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Skill` list in the `Codoc`, which `Person` references. This allows `Codoc` to only require one `Skill` object per unique skill, instead of each `Person` needing their own `Skill` objects.<br>

<img src="images/BetterModelClassDiagram.png" width="450" />

</div>

[Scroll back to top](#table-of-contents)

### Storage component

**API** : [`Storage.java`](https://github.com/AY2223S2-CS2103T-F12-2/tp/tree/master/src/main/java/seedu/address/storage/Storage.java)

<img src="images/StorageClassDiagram.png" width="550" />

The `Storage` component,
* can save both CoDoc data and user preference data in json format, and read them back into corresponding objects.
* inherits from both `CodocStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

[Scroll back to top](#table-of-contents)

### Common classes

Classes used by multiple components are in the `codoc.commons` package.

[Scroll back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedCodoc`. It extends `Codoc` with an undo/redo history, stored internally as an `codocStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedCodoc#commit()` — Saves the current CoDoc state in its history.
* `VersionedCodoc#undo()` — Restores the previous CoDoc state from its history.
* `VersionedCodoc#redo()` — Restores a previously undone CoDoc state from its history.

These operations are exposed in the `Model` interface as `Model#commitCodoc()`, `Model#undoCodoc()` and `Model#redoCodoc()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedCodoc` will be initialized with the initial CoDoc state, and the `currentStatePointer` pointing to that single CoDoc state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th person in CoDoc. The `delete` command calls `Model#commitCodoc()`, causing the modified state of CoDoc after the `delete 5` command executes to be saved in the `codocStateList`, and the `currentStatePointer` is shifted to the newly inserted CoDoc state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitCodoc()`, causing another modified CoDoc state to be saved into the `codocStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitCodoc()`, so CoDoc state will not be saved into the `codocStateList`.

</div>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoCodoc()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous CoDoc state, and restores CoDoc to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial Codoc state, then there are no previous Codoc states to restore. The `undo` command uses `Model#canUndoCodoc()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoCodoc()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores CoDoc to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `codocStateList.size() - 1`, pointing to the latest CoDoc state, then there are no undone Codoc states to restore. The `redo` command uses `Model#canRedoCodoc()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify CoDoc, such as `list`, will usually not call `Model#commitCodoc()`, `Model#undoCodoc()` or `Model#redoCodoc()`. Thus, the `codocStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitCodoc()`. Since the `currentStatePointer` is not pointing at the end of the `codocStateList`, all CoDoc states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

<img src="images/CommitActivityDiagram.png" width="250" />

[Scroll back to top](#table-of-contents)

#### Design considerations:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire CoDoc.
    * Pros: Easy to implement.
    * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
    * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
    * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

[Scroll back to top](#table-of-contents)

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_

[Scroll back to top](#table-of-contents)


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

[Scroll back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope 🔍️

**Target user profile** 🧑:

There is no platform for students of Computing to easily identify people of similar interest and skills to aid them in
their study and career. The product aims to help students organize and easily identify potential study/project/career
partners that they have encountered over the course of their study and provide necessary contact information for
networking opportunities.

Following are characteristics of people who can benefit from our product:

* has difficulties tracking peers met over the course of study
* has a need to manage a significant number of contacts
* wants to find project partners of similar background
* prefers a full desktop application over other data management
* able to type fast
* comfortable with CLI (command-line interface)

**Value proposition** 🔥:

CoDoc is not only able to help users manage large contact database fast through CLI, it is also able to display
relevant contact information through a comprehensive UI. Furthermore, users can utilize the powerful filtering system
to effectively sort/filter contacts to easily identify people of interest, such as study or project partners.

[Scroll back to top](#table-of-contents)

### User stories 📝

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                                                                   | I want to …​                                         | So that I can…​                                                               |
|---------|---------------------------------------------------------------------------|------------------------------------------------------|-------------------------------------------------------------------------------|
| `* * *` | user                                                                      | add/remove contacts of peers                         | save/manage them                                                              |
| `* * *` | user                                                                      | edit the details of the contacts                     | update my contacts to be accurate and relevant                                |
| `* * `  | student who is interested in joining various coding or programming events | search contacts by skill sets                        | identify potential team members for projects                                  |
| `* * *` | user                                                                      | find a person by name                                | locate a particular person without scrolling the entire list of contacts      |
| `*`     | student                                                                   | find people who have taken a specific module         | I can ask for help related to the module such as upcoming topics to study for |
| `*`     | student                                                                   | find people who are currently taking the same module | work together (discuss questions, find project members, teach each other)     |

*{More to be added}*

[Scroll back to top](#table-of-contents)

### Use cases

(For all use cases below, the **System** is the `CoDoc` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Add a new person**

**MSS**

1. User requests to add a specific person to the list
2. CoDoc displays the list of people with the newly added person and a success message

   Use case ends.

**Extensions**

* 1a. The compulsory prefixes are missing.
    * 1a1. CoDoc shows an error message.

      Use case ends.

**Use case: Edit a person's information**

**MSS**

1. User requests to list persons
2. CoDoc shows a list of all people
3. User requests to view a specific person in the list
4. CoDoc displays the information of that person in the right panel
5. User requests to view a specific attribute of the person in the right panel
6. CoDoc displays the information of that attribute in the right panel
7. User requests to edit a specific attribute of the information
8. CoDoc displays the changes and displays a success message

   Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. CoDoc shows an error message.

      Use case resumes at step 2.

* 5a. The given prefix is invalid.
    * 5a1. CoDoc shows an error message.

      Use case resumes at step 4.

* 7a. The given prefix is invalid.
    * 7a1. CoDoc shows an error message.

      Use case resumes at step 4.

* 7b. The given prefix is `m/`, indicating an edit to the list of modules.
    * 7b1. `a` is given, indicating that the following modules will be added to the list.
    * 7b2. `d` is given, indicating that the following modules at the specified indices will be deleted from the list.
    * 7b3. `u` is given, indicating that the module at the specified index will be updated to the new module.

      Use case resumes at step 8.

* 7c. The given prefix is `w/`, indicating an edit to the work experiences.
    * No further prefix needed.

      Use case resumes at step 8.

* 7d. The given prefix is `c/`, indicating an edit to the contact information.
    * 7d1. `g` is given, indicating that the GitHub link will be edited.
    * 7d2. `e` is given, indicating that the email will be edited.

      Use case resumes at step 8.

**Use case: Find a person by attribute**

**MSS**

1. User requests to list persons
2. CoDoc shows a list of persons
3. User requests to find people in the list based on a given attribute
4. CoDoc displays the list of filtered people

   Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. Valid `prefixes/ATTRIBUTES` include:
    * `c/COURSE`
    * `n/NAME`
    * `e/EMAIL`
    * `m/YEAR MODULECODE`
    * `s/SKILLSETS`

* 3b. The given prefix is invalid.

    * 3b1. CoDoc shows an error message.

      Use case resumes at step 2.
* 4a. There are no matches found based on the input
    * 4a1. CoDoc shows an empty list.

      Use case ends.


**Use case: Delete a person**

**MSS**

1. User requests to list persons
2. CoDoc shows a list of persons
3. User requests to delete a specific person in the list
4. CoDoc deletes the person

   Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. CoDoc shows an error message.

    * Use case resumes at step 2.

*{More to be added}*

[Scroll back to top](#table-of-contents)

### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4. The interface should adhere to the figma diagrams.

*{More to be added}*

[Scroll back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

    1. Download the jar file and copy into an empty folder

    1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

    1. Resize the window to an optimum size. Move the window to a different location. Close the window.

    1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

[Scroll back to top](#table-of-contents)

### Deleting a person

1. Deleting a person while all persons are being shown

    1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

    1. Test case: `delete 1`<br>
       Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

    1. Test case: `delete 0`<br>
       Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

    1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
       Expected: Similar to previous.

1. _{ more test cases …​ }_

[Scroll back to top](#table-of-contents)

### Saving data

1. Dealing with missing/corrupted data files

    1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_

[Scroll back to top](#table-of-contents)

