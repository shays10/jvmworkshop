"YouTube likes statistics" - Solution
-----------------------------------------------

Did the app crushed? what is the problem.
go to JVisualVm -> check the heap usage, we can see that the heap is full, is it do to a bug or the business logic of the app.
the app loads a data set file of youtube statistics and analyze it.
in this case some optimizations can be done:
1. increase the xmx parameter to:
1. change the what the app work by reading chuncks of the file...


