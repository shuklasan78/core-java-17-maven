package Interview.jvm;

public class JVMClass {

    public static void main(String[] args) {
        //getTotalProcessor();
        //totalAmountOfMemoryInJVM();
        getFreeMemory();
    }

    //program to Find out total Number Of Processors Available

    private static void getTotalProcessor() {
        Runtime runtime = Runtime.getRuntime();
        int numberOfProcessors = runtime.availableProcessors();
        System.out.println("total Number Of Processors Available to "
                + "JVM (Java virtual machine) In your System = "+numberOfProcessors);
    }

    //total Amount Of Memory In JVM

    private static void totalAmountOfMemoryInJVM() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemoryInJVM = runtime.totalMemory();

        System.out.println("Total amount of memory in the "
                + "JVM (Java virtual machine) in bytes = "+ totalMemoryInJVM);

        long maximumMemoryThatJVMAttemptsToUse = runtime.maxMemory();
        System.out.println("Maximum Memory That "
                + "JVM (Java virtual machine) will try to use "
                + "in bytes = "+ maximumMemoryThatJVMAttemptsToUse);
        //teminate JVM
        runtime.halt(1); //pass status as 1
        runtime.exit(1); //pass status as 1 to exit method
        System.out.println("JVM (Java virtual machine) halted"); //This line won't be printed



    }

    //Find Free Memory Available In Java virtual machine

    private static void getFreeMemory() {
        Runtime runtime = Runtime.getRuntime();
        long freeMemoryAvailableInJVM = runtime.freeMemory();
        System.out.println("Total amount of free memory available in the "
                + "JVM (Java virtual machine) in bytes = "+ freeMemoryAvailableInJVM);
    }
}
