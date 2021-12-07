Progress Report (This is also included in Design Document)

    Jingquan Cao, github name: J-D-CONNOR: My major code work on phase 2 is implementation of auto harvest feature and rearranging 
    files so our project's github repo looks cleaner. As for a significant pull request of mine, I think #137 is the desired one since 
    in this pull, I implement (semi-)auto-harvest feature so that we follow Low Physical Effort Principle from the 7 principle of 
    universal design. With this feature, players no longer need to repeat the 'harvest' action over and over again.
    
    Yi Yang, github name: ZacYiYang: After the phase 1 I reviewed all the problem that pointed by TA, and update our code through the 
    feedback from him. I made some changes in docstring and some structure of code. I think the #139 pull request is a significant 
    contribution for me. In this pull request, I changed the controller into ViewModel to make our code follow the MVVM pattern. This 
    change needs knowledge of the MVVM model. Then I reviewed the lecture notes and recording, also asked my teammate to make sure our 
    thoughts are correct. Then I made this change and got this pull request.
    
    Jason Liu, github name: Jason-YW-L: My major work in phase 2 is to impelment and improve the front-end of the game. Sepecificlly 
    by adding graphics to the UI.  I think the most significant pull request of mine is pull request #151. In this pull request, I
    have completed all the front-end impelmentations.
    
    Harriet Zhu, githubname: primavera-dolce: The most significant pull request: pull request#63. This pull request settles the 
    warehouse's fundamental data storing strategie. We used to use arraylist to store all the elements——including seeds,  plants and 
    items; in this pull request(and other merges), we have not only changed the storing strategy to hashmap but also modified the 
    specific method to access and store each elements. In phase 2, I implemented two features: buying multiple seeds/items with one 
    click and selling all the sellable stuff with one click. Also, I wrote the unit test for all usecases class and part of 
    controller class. In the end, I wrote the AccessibilityReport to demonstrate how our project fits the 7 universal principle.
    
    Saifei Liao, github name: SophieLiao0109: My major work in phase 2 is to remove the presenters and make our project structure to 
    be consistent with the MVVM architecuture. I think the most significant pull request is pull request #140, I delete the presenters 
    and move them into a new class called Message.

    Xuhui Chen, github name: ShangDanLuXian: The first thing I did in phase 2 is to make landManager manage all lands - in our previous
    stage, one landManager will only manage one land so we need many instances of landManagers. And therefore each of our three land 
    system is responsible for all of the lands. This change will significantly reduce the number of requests sent to our database, and 
    it will be easier for us to implement the auto-harvest feature. I also contributed to the front end, I made the customized dialog 
    that will should when the player clicked a commodity in the store. I also add buttons to our new features(harvest all and sell 
    all). The most significant two pull requests I thought I made are #26 and #51, these two request together structured our database 
    implementation.
    
    
Relevent pull request link: 
[#26](https://github.com/CSC207-UofT/course-project-not-a-team/pull/26),
[#51](https://github.com/CSC207-UofT/course-project-not-a-team/pull/51),
[#63](https://github.com/CSC207-UofT/course-project-not-a-team/pull/63),
[#137](https://github.com/CSC207-UofT/course-project-not-a-team/pull/137), 
[#139](https://github.com/CSC207-UofT/course-project-not-a-team/pull/139),
[#140](https://github.com/CSC207-UofT/course-project-not-a-team/pull/140),
[#151](https://github.com/CSC207-UofT/course-project-not-a-team/pull/151).
