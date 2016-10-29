# SBU Web and App Club Website

This is a website for the club to serve as our first project and showcase for our members and upcoming projects. The website is constructed with a combination of Spring (Java Back-end) and HTML, CSS, and Javascript (Front-end) with a responsive design.

## Website Features

1. Homepage with smoothscrolling and parallax (maybe?)
2. Members page showcasing personal projects, bio, and contact information.
3. Idea submission board for the public.
4. Maybe a club logo?

### Haven't Started:
  - Member.java  
  - members.html  
  - members.css  
  - Project.java  
  - Framework.java  
  - MemberController.java
  - ideas.html
  - projects.html
  - index.html
  
# Note: Html files have to be inside src/main/resources/templates/ in order for Spring to see them!

### In Progress:



### Finished:



# Webpages
1. Members
2. Projects
3. Homepage
4. Idea Submissions

## Members Webpage 
  - Member.java:

    ```
    String mFullname
    String mEmail  
    String mMajor  
    String mImagePath  
    List<Project> mProjects  
    HashMap<String, String> mUrls
    ```
  - members.html  
  - members.css  
  - Project.java  
  - Framework.java  
  - MemberController.java
  
## Projects Webpage
  - projects.html
   - CSS file naming pending
   - Redirects to project.html
   - Lists all fields in project.java except the list of members.
   - Possible final look of page(Tell me what you think!) https://s10.postimg.org/ctojbi9x5/possiblelookforprojectspage.png
  - project.html (View of one entire project)
   - CSS file?
  - Project.java
   - Project Name
   - Description
   - Image URL
   - Creator (Represented as a member class)
   - ArrayList of members.
  - ProjectController.java
   - Routes users who type in "projects/" in URL bar.
   - Also handles "projects/{name of project}"
  -ProjectService.java
   - Pulls requested data from wherever it's stored.
  


## Homepage
   - index.html
     - regular.css (Standard css for default view)
     - mobile.css (Mobile optimized css)
     - app.js (If we need it)
    


## Idea Submissions Webpage
  - ideas.html
   - CSS file naming pending


### Resources

- Hungarian Notation (as discussed by Chris)
  - [Hungarian Notation examples](https://en.wikipedia.org/wiki/Hungarian_notation#Examples, "If you're reading this, you are cool.")
