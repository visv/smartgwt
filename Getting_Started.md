Getting Started

# Introduction #

To install into an existing GWT project, add smartgwt.jar to your classpath and add
```
  <inherits name="com.smartgwt.SmartGwt"/>
```
to your .gwt.xml file.

Remove any pre-existing imports of standard GWT themes.  These contain CSS settings that style fundamental HTML elements (eg TD - table cell) and interfere with Smart GWT and other widgets.

Alternatively, the distribution includes a basic "helloworld" sample project that you can use as a starting point.

**For Smart GWT Pro/EE**, download [from here](http://forums.smartclient.com/showthread.php?t=4839) instead.  Pro/EE packages include sample projects demonstrating various integration approaches (Spring, Hibernate, JPA, SQL, ..).  You can import these projects into Eclipse, build them with Ant, or follow step-by-step instructions to add Pro/EE features to an existing project (see the README in each sample).

All documentation, including JavaDoc and conceptual overviews, is linked from [the Smart GWT FAQ](http://forums.smartclient.com/showthread.php?t=8159).

Use Google's [getting start guide](http://code.google.com/webtoolkit/gettingstarted.html) if you are not already familiar with GWT.  Alternatively, several users have created [Tutorials](Tutorials.md) of the setup process.

**You must use GWT 1.5.3 (or greater).** Earlier versions of GWT are not supported.