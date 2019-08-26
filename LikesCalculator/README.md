### Fourth App: "YouTube Likes Calculator"
The YouTube Likes Calculator is an app that can read CSV files that contains data on YouTube videos such as: views, likes review dates and more.
 
The app goes over the data and calculates the average likes for video per country.

1. In your terminal navigate to `LikesCalculator` execute `./compile.sh` and `./run.sh`.  Your Jetty server should be up and running.
2. Run `curl localhost:8080/` to fire up a single request. You app has crashed!
3. Maybe run the app with more memory. `java -Xmx512M -jar target/LikesCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar`
4. In a separate terminal window run `./create_load.sh`. This will fire 10K requests. 
5. What is happening? Is there a leak? (Try to use the `Surviving Generations` metric again).

Solution [is here](/LikesCalculator/solution/Solution.md)