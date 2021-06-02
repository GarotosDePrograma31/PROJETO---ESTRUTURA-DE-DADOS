package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pilha.ArrayStack;
import pilha.EmptyStackException;
import pilha.FullStackException;

class ArrayStackTest {

	static final ArrayStack<Integer> a = new ArrayStack<Integer>(3);	
	@Test	
	void pilhaInteiros() {
		a.push(7);
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
		a.push(9);
		assertEquals("[7, 9]", a.toString(), "Deve imprimir [7, 9]");
		a.push(1);
		assertEquals("[7, 9, 1]", a.toString(), "Deve imprimir [7, 9, 1]");
		Assertions.assertThrows(FullStackException.class, () -> { a.push(2); });
		assertEquals(1, a.pop(), "Deve ter desempilhado 1");
		assertEquals("[7, 9]", a.toString(), "Deve imprimir [7, 9]");
		assertEquals(9, a.pop(), "Deve ter desempilhado 9");
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
		assertEquals(7, a.pop(), "Deve ter desempilhado 7");
		assertEquals("[]", a.toString(), "Deve imprimir []");
		assertTrue(a.isEmpty());
		Assertions.assertThrows(EmptyStackException.class, () -> { a.pop(); });		
		a.push("lucas");
		assertEquals("[lucas]", a.toString(), "Deve imprimir [lucas]");
	}
}
