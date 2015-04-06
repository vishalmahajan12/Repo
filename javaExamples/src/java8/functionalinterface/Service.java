package java8.functionalinterface;

public interface Service {
	default String getName(){
		return "Service";
	}
	int getValue(int i, int j);
}
