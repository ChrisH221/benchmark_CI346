# benchmark_CI346
Benchmark program for CI346

This application is built in Java and aims at benchmarking the various approaches
to concurrency available in Java to a developer. 

The benchmark is a simple test that generates four arrays and populates them with
randomly generated numbers. The four benchmarks then count the number of prime
numbers held in each array, records the time the operation took to complete and then
returns the time. 

The four benchmarks each implement a different form of concurrency. The first
test uses a simple loop to iterate over the dataset. The second features
two raw threads that split the work and then add the individual prime number
counts together. The third uses a threadpool and executor. This test also
splits the array down into smaller chunks based on the number of cores avaiable.
The final benchmark implements a Java 8 Parallel Stream. 

To run the benchmark clone the repository and run the main method contained in the BenchMark Class.
