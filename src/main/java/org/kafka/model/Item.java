package org.kafka.model;

public class Item {

	private String title;
	private String description;
	
	public Item()
	{
	}

	public Item(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", description=" + description + "]";
	}
	
}
