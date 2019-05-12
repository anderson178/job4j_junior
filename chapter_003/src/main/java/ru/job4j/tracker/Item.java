package ru.job4j.tracker;

import java.util.*;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.09.2018
 */

public class Item {
	private String id;
	private String name;
	private String description;
	private String create;

	
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Item id: %s, Name: %s, Description: %s Create: %s", this.id, this.name, this.description, this.create);
	}

	public String getId() {
		return this.id;
	}
	public String setId(String id) {
		this.id = id;
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String setName(String name) {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public String setDescription(String desc) {
		return this.description;
	}
	public String getCreate() {
		return this.create;
	}
	public String setCreate(String create) {
		this.create = create;
		return this.create;
	}
}
