# CalcPIandSortArray

1. Use Java Thread/Runnables to calculate pi to 12 digits
2. Use AsyncTask to sort an array of 1000 randomly generated numbers

After running the app, select either the "Find Pi" or the "Sort 1000 Integers" button to begin either operation. The output should be displayed underneath each respective button.

![Calc Pi or Sort Random](https://raw.githubusercontent.com/ebrunso/CalcPIandSortArray/master/calcPiandSortRand.png)

Research
1. What are loaders and how do we implement loaders?
	##The Loader API loads data from Content Providers (or other data sources) and transfers it to fragments and fragmentActivities.##
	
	##In order to implement a loader, you will need the following:
		a FragmentActivity or a Fragment
		an instance of LoaderManager
		A CursorLoader to load data with a ContentProvider.
		An implementation for LoaderManager.LoaderCallbacks.
		A way to show the loader data, using SimpleCursorAdapter
		A data source, like ContentProvider
	Use the activity's onCreate() method to initialize a Loader using the initLoader() method, filled with a unique ID, optional arguments (or null), a LoaderManager.LoaderCallbacks implementation, represented by a " this ".##

2. What is an AsyncTaskLoader?
	##An AsyncTaskLoader handles what AsyncTask does. It follows lifecycle changes of both fragments and activities.##


3. What is a Handler Thread for?
	##A Handler Thread is a Thread that holds a Looper. Loopers are used to create Handlers. Handlers run outside an activity's lifecycle.##

4. What are some common threading restrictions in android?
	##Threads should not block the UI thread and should not access the Android UI toolkit from outside the UI thread##

5. What are thread pools and thread pool executors?
	##Thread pools manages a pool (group) of worker threads. A ThreadPoolExecutor executes a task using one of the threads from the pool. The parameters for a ThreadPoolExecutor are: 
		corePoolSize - minimum number of threads in the pool. New threads will be generated as required.
		maximimPoolSize - The maximum number of threads allowed in the pool. 
		keepAliveTime - A 'grace period' given to idle threads when the population exceeds the corePoolSize, they will be terminated.
		unit - unit of time used in keepAliveTime.
		workQueue - The task queue for threads to execute.##
