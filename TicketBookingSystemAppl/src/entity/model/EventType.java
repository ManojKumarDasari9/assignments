package entity.model;

public enum EventType {
	Movie("movie"),
	Sports("sports"),
	Concert("concert");

	EventType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private String name;


}
