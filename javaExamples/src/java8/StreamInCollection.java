package java8;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;

public class StreamInCollection {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(2);
		list.add(3);

		testSequentailStream(list);
		testParallelStream(list);

	}

	private static void testParallelStream(List<Integer> list) {
		OptionalDouble distance = list.parallelStream().map(p -> new Point(p*1, p*2)).mapToDouble( d -> d.distance(0, 0)).max();
		System.out.println(distance);

	}

	private static void testSequentailStream(List<Integer> list) {

		OptionalDouble distance = list.stream().map(p -> new Point(p*1, p*2)).mapToDouble( d -> d.distance(0, 0)).max();
		System.out.println(distance);

	}

	Comparator<Point> byX = (p1, p2) ->	Double.compare(p1.getX(), p2.getX());
	Comparator<Point> byXimpovment = comparing(p-> p.getX());


	public static <T,U> Comparator<T> comparing(Function<T,U> keyExtractor) {
		return (c1, c2) -> ((Double) keyExtractor.apply(c1)).compareTo((Double)keyExtractor.apply(c2));
	}
}


