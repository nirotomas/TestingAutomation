# TestingAutomation
TAE

Definition of Test Automation:
 Test Automation is the use of special software (separate from the software being tested) to control the execution 
 of tests and the comparison of actual outcomes with predicted outcomes. Test automation can automate some repetitive 
 but necessary tasks in a formalized testing process already in place, or add additional testing that would be difficult 
 to perform manually.
 
Practico1
  This was my first experience with testing, y used mostly xpath locators, and mostly there wasnt problems
  
Practico2
  At this point i started to use xpath locators also, but this presented some troubles mostly because the page was dinamic 
  and the xpath given by firepath plug-in didn't worked. So, y continue using absolute xpath, wich works, but is really tricky.
  Absolute xpath doesnt work if the HTML of the page change a little.

Conclution: Best way to locate elements in a dinamyc page its with WebDriver.findElement and concatene another findElement 
              till you get to the desired object. This is for sure de most performant way but youll need more documentation 
              in code to understand what you did. 

Optional: Practico2_mod1:
  This exercice runs in parallel the Test case8 in Chrome and IExplorer browsers. The configuration its in "test.xml" file.
  To run it, you'll need to execute te next comands in the directory where you have the jars involved:
  
  java -jar selenium-server-standalone-2.45.0.jar -role node -hub http://localhost:4441/grid/register -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.ie.driver=iedriverserver.exe
  
  And in another shell:
  
  java -jar selenium-server-standalone-2.45.0.jar -role hub -port 4441

 Conclution: The DOM in diferent browsers changes, so no all the test cases works.I I think, if you want all the test cases   to work youll have to program one code for each browser. Couldn't sol this problem
 
Plataform: Eclipse-Maven-Selenium-TestNG-FireBug-Firepath
           Optional: Grid Server
