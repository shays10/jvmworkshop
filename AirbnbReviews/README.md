### Third App: "Airbnb Reviews Analyzer"
The Airbnb Reviews Analyzer is an app that can read a CSV file that contains reviews on an Airbnb property, parse it
and figure out how many positive and negative reviews are there, using a super complex algorithm! 

To test that it is working properly, running our app will analyze only the first 1K reviews (out of ~200K reviews)

1. In your terminal navigate to `AirbnbReviews` execute `./compile.sh` and `./run.sh`. 
2. Again, go to the `Monitor` tab in `JVisualVM`. What is wrong? There's one metric that is abnormal.
3. Open the source code, understand the problem and mitigate it. 
4. Rerun the app to make sure that the metric is now within normal limits.

Solution [is here](solution/Solution.md)
