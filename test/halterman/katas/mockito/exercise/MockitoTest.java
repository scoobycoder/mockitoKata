package halterman.katas.mockito.exercise;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoTest {

	@Mock
	MyDatabase databaseMock;
	private ClassToTest myClass;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		myClass = new ClassToTest(databaseMock);
		myClass.queryMyDatabase("select * from everything;");
	}
	
	@Test
	public void testSimpleVerify() {
		verify(databaseMock).query("select * from everything;");
	}

	@Test
	public void testWhenVerify() {
		when(myClass.queryMyDatabase("Blah")).thenReturn(false);
		
		verify(databaseMock).query("select * from everything;");
	}
	
	@Test
	public void testAlternateWhenVerify() {
		doReturn(false).when(databaseMock).query("Blah");
		
		verify(databaseMock).query("select * from everything;");
	}
	@Test
	public void testSpy() {
		List list = new LinkedList();
		List spyList = spy(list);

		doReturn("foo").when(spyList).get(0);

		when(spyList.get(0)).thenReturn("foo"); 
	}
	
	
	
}
