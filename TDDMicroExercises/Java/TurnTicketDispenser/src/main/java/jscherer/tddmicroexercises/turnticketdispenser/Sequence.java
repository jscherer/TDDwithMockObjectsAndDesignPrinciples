package jscherer.tddmicroexercises.turnticketdispenser;

public interface Sequence<E> {
	
	/**
	 * Returns the next element like Iterator.next().
	 * 
	 * @return next Element
	 */
	E next();

}