package functions;

public class RecurringFunctions {


    interface Movie{
        boolean isThriller(int movieId);
    }

    // Get an employee given an id
    interface Employee{
        Employee fetch(int empId);
    }
//
//    // Admit the patient
//    interface Hospital{
//        void admit(Patient patient);
//    }

    // Custom functions

    // Interface for checking conditionality
    interface Tester<T>{
        boolean test(T t);
    }

    // Interface for Producing objects
    interface Producer<T>{
        T produce(int id);
    }


}
