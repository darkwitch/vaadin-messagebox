# MessageBox Add-on for Vaadin 7

MessageBox is an UI component add-on for Vaadin 7.

## Online demo

Try the add-on demo at <url of the online demo>

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/MessageBox

## Building and running demo

git clone <url of the MessageBox repository>

mvm clean package jetty:run

See demo on http://localhost:8080/

## Development with Eclipse IDE

For further development of this add-on, the following tool-chain is recommended:
- Eclipse IDE
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects from SCM

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging server-side

If you have a JRebel license, it makes on the fly code changes faster. Just add JRebel nature to your project by clicking project with right mouse button and choosing JRebel > Add JRebel Nature

To debug project and make code modifications on the fly in the server-side:
- Start the project with Run > Debug configurations... 
- Create a new Maven Build configuration for "package jetty:run"
- If you have JRebel, also enable that from the JRebel tab
- After you run it, you can access the demo application at http://localhost:8080/ and make code modifications on the server-side classes and SCSS files on the fly.

### Debugging client-side

The most common way of debugging and making changes to the client-side code is dev-mode. To run it, create another Maven Build configuration for "vaadin:debug" target. When it is launched, it opens up GWT dev-mode where you can debug client-side code in regular Java. After this, connect a remote debugger to the dev-mode process. In Eclipse this is done by creating a new Debug configuration:
Run > Debug Configurations... > Remote Java Application > New

Another way of debugging client-side is super dev-mode. To enable it, take a look at WidgetSet.gwt.xml for instructions.

 
## Release notes

### Version 0.0.1-SNAPSHOT
- ...
- ...

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, the following features are planned for upcoming releases:
- ...
- ...

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

MessageBox is written by <...>

# Developer Guide

## Getting started

Here is a simple example on how to try out the add-on component:

<...>

For a more comprehensive example, see src/test/java/org/vaadin/template/demo/DemoUI.java

## Features

### Feature A

<...>

### Feature B

<...>

### Feature C

<...>

## API

MessageBox JavaDoc is available online at <...>