package md.datastructures.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

class GraphTest {

	Graph<String> graph1;
	
	@BeforeEach
	public void init() {
		graph1 = new Graph<String>();
		graph1.addNodo("A")
		.addNodo("B")
		.addNodo("C")
		.addNodo("D")
		.addNodo("E")
		.addNodo("F")
		.addNodo("G");
		
		graph1.conectar("A", "B",3)
		.conectar("A", "C",6)
		.conectar("B", "C",2)
		.conectar("B", "D",5)
		.conectar("B", "E",2)
		.conectar("B", "F",9)
		.conectar("C", "E",1)
		.conectar("C", "G",4)
		.conectar("D", "F",2)
		.conectar("E", "G",4)
		.conectar("E", "D",3)	
		.conectar("F", "G",3);
		

	}
	@Test
	void test() {
		Map<String,Integer>  result = graph1.minimumPathDijkstra("A");
		System.out.println(result);

		assertTrue(true);
		
	}

}
