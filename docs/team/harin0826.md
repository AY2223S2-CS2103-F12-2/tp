---
layout: page
title: Nam Harin's Project Portfolio Page
---

### Project: CoDoc

CoDoc is a desktop contact management application. The user interacts with it using a CLI, and it has a GUI created with JavaFX.
It is mainly written in Java, and I have contributed about 1800 LoC.

Given below are my contributions to the project.

* **Code contributed**: [Repo Sense](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=harin0826&tabRepo=AY2223S2-CS2103T-F12-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Major Feature Added**: Info Panel system design. ([#38](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/38), [#47](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/47), [#68](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/68))
    * What it does: Info Panel is a key element of CoDoc that allows users to view specific details of a contact stored
  in a concise manner through a multi-tab system.
    * Justification: A `Person` stored in the database could hold a long list of `Module` and `Skill`. Having a separate
  Info Panel that organizes such information in a neat vertical list allows users to compare between and within contacts
  easily.
    * Highlights: Abstraction of user information through split pane UI.


* **New Feature**: `protagonist` system in the CoDoc model. ([#47](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/47))
  * What it does: Facilitates smooth interaction of Info Panel and CoDoc database, as well as execution of various commands.
  * Justification: Implementation of Info Panel led to a need for dedicating a special `Person` object that will be
  "staged" to the Info Panel, and also become the target for commands such as Edit Command. The `protagonist` system
  allows CoDoc model to keep a special `Person` reference to be used for UI and commands.
  * Highlights: Interactive panel design that is able to update itself after every user input (through CLI or GUI).


* **New Feature**: View Command. ([#68](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/68))
  * What it does: Primary way of users to interact with the Info panel through the CLI.
  * Justification: Main target audience for CoDoc are users who are able to type fast and benefit off CLI. Implemented
  View Command and its parser to properly handle user commands to load up `protagonist` in the Info Panel and view different
  tabs. This is also able to keep the same tab when switching between persons in the list to make comparing between contacts
  easy.
  * Highlights: Simple and responsive command that allows user interaction with the Info Panel and easy comparison between
  contacts.


* **UI Overhaul**: New Theme for CoDoc. ([#71](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/71))
  * What it does: Update color scheme and various layouts to improve UI design.
  * Justification: To give CoDoc a modern look, popular designs were referenced and implemented to make it look more
  polished. Bright pastel highlights over white & gray body gives it a simple yet bright looking UI. Popular font (Roboto)
  was also added to make it more professional yet not overwhelming.
  * Highlights: Clean looking UI that greatly improves readability and user experience.
  * *Credits*: Referenced Apple's UI design. Roboto Font obtained from [Google fonts](https://fonts.google.com/specimen/Roboto), used under [Apache license](https://en.wikipedia.org/wiki/Apache_License).


* **Enhancements to existing features**:
    * Improved display of person list for more concise display. ([#72](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/72))
    * Improved implementation of Edit Command to follow Software Engineering principles. ([#105](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/105))
    * Enhanced implementation of GUI clicking function by [Linus](https://ay2223s2-cs2103t-f12-2.github.io/tp/team/harin0826.html)
  to improve code quality and remove errors. ([#129](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/129), [#133](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/133))
    * Implement auto-scroll and highlight feature to improve user experience when interacting through GUI and View Command. ([#161](https://github.com/AY2223S2-CS2103T-F12-2/tp/pull/161))
    * Overall enhancements to code quality to better follow Software Engineering principles and Design fundamentals.


* **Documentation**:
    * User Guide:
        * (To be added)
        * (To be added)
    * Developer Guide:
        * A(To be added)


* **Project management**:
  * (To be added)



* **Community**:
    * (To be added)
    * (To be added)
    * (To be added)
    * (To be added)

* **Tools**:
    * (To be added)
    * (To be added)

* _{you can add/remove categories in the list above}_
