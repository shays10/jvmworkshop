"YouTube Likes Statistics" - Solution
-----------------------------------------------

Did the app crash? 
We can see that the app is still working properly for a fairly high load.
Using JVisualVm ->  we can see that the heap usage is quite large, is it due to a leak? or just a case where our app is using a lot of memory?

We can see that the Surviving Generation metric does not indicate on a leak, it's just that our app is over-consuming memory in the parsing process and then releasing it. 

We can increase the heap size or just analyze the file more efficiently instead of loading the entire data set at once.
