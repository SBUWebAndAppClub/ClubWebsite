# THIS IS THE VERBOSE BRANCH. BEWARE OF *HEAVILY COMMENTED CODE.*

## How does all this work?!

### Dependencies

First, we define our **dependencies**. Dependencies are libraries, scripts, reusable code, preprocessors, etc...
 
Simply put, a dependency is code created by talented developers to facilitate our development 
process by letting us focus on our project(webpage) and not on reinventing the wheel, like HTTP.

Dependencies are defined in the `pom.xml` in XML.
````
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>3.8.1</version>
    <scope>test</scope>
</dependency>
````

### Thymeleaf

We can generate HTML dynamically with Thymeleaf.

For example:
````HTML
<div th:if="${not #lists.isEmpty(projects)}">
    <!-- content -->
</div>
````
All thymeleaf attributes start with `th`. Following that is always a `:` followed by some
directive, like `if`, `each`,`for`, etc. (Read the docs).

All expressions are surrounded with `${...}`. This tells thymeleaf to interpret the expression.
In this snippet, if the expression `${not #lists.isEmpty(projects)}"` returns true, ie, the list `projects` is not empty.

`${not #lists.isEmpty(projects)` in Java roughly translates to 
 ````java
 if ( !projects.isEmpty() ){
    // do stuff
 }
 ````
`#lists` and `not` are thymeleaf keywords.

### Spring

BUT where did `projects` come from? `ProjectService.java`

````java
@RequestMapping(value = "/projects", method = RequestMethod.GET)
public String list(Model model){
  model.addAttribute("projects", projectService.getAllProjects());
  return "projects";
} 
````
We add `key=projects` and its`value= projectService.getAllProjects()` to the `Model` so we can reference them in the HTML template. `projects.html`.

