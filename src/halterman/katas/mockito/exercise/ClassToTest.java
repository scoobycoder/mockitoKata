package halterman.katas.mockito.exercise;

public class ClassToTest {

	private MyDatabase database;

	public ClassToTest(MyDatabase database) {
		this.database = database;
	}
	
	public boolean queryMyDatabase(String queryString){
		return database.query(queryString);
	}
	
}
