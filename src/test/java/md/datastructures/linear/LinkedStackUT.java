package md.datastructures.linear;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LinkedStackUT {

	Stack<Integer> emptyStack;
	
	Stack<Integer> nonEmptyStack;

	
	@BeforeEach
	public void beforeEveryTest() {
		emptyStack = new ListStack<Integer>();
		nonEmptyStack = new ListStack<Integer>();
		nonEmptyStack.push(1);
	}
	
	@Test
	public void pullOfEmptyStackShouldReturnEmptyOptional() {
		Optional<Integer> result = emptyStack.pull();
		assertThat(result.isEmpty(),is(true));		
	}

	@Test
	public void pullOfNonEmptyStackShouldReturnOptional() {
		Optional<Integer> result = nonEmptyStack.pull();
		assertThat(result.isEmpty(),is(false));		
		assertThat(result.isPresent(),is(true));
	}

	@Test
	void pushOnStackInitialOfTwoShouldScale() {
		nonEmptyStack.push(1);
		nonEmptyStack.push(2);
		nonEmptyStack.push(3);
		Optional<Integer> three = nonEmptyStack.pull();
		assertThat(three.isPresent(),is(true));
		assertThat(three.get(),is(3));
		Optional<Integer> two = nonEmptyStack.pull();
		assertThat(two.isPresent(),is(true));
		assertThat(two.get(),is(2));
		Optional<Integer> one = nonEmptyStack.pull();
		assertThat(one.isPresent(),is(true));
		assertThat(one.get(),is(1));
		
	}

	@Test
	void pushAfterPeekShouldReturnElement() {
		nonEmptyStack.push(1);
		nonEmptyStack.push(2);
		nonEmptyStack.push(3);
		Optional<Integer> threePeek = nonEmptyStack.peek();
		assertThat(threePeek.get(),is(3));
		
		Optional<Integer> three = nonEmptyStack.pull();
		assertThat(three.isPresent(),is(true));
		assertThat(three.get(),is(3));

		Optional<Integer> twoPeek = nonEmptyStack.peek();
		assertThat(twoPeek.get(),is(2));

		Optional<Integer> two = nonEmptyStack.pull();
		assertThat(two.isPresent(),is(true));
		assertThat(two.get(),is(2));
		
		Optional<Integer> onePeek = nonEmptyStack.peek();
		assertThat(onePeek.get(),is(1));
		
		Optional<Integer> one = nonEmptyStack.pull();
		assertThat(one.isPresent(),is(true));
		assertThat(one.get(),is(1));
		
	}

	@Test
	public void peekOnEmptyStackShouldReturnEmptyOptional() {
		Optional<Integer> result = emptyStack.peek();
		assertThat(result.isEmpty(),is(true));		
	}
}
