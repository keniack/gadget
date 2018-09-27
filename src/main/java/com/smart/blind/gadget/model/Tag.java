package com.smart.blind.gadget.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6704281615195448384L;

	@Id
	@SequenceGenerator(name="seq-gen",sequenceName="tag_seq", allocationSize=1)
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
	private Long id;

	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tag other = (Tag) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Tag{" + "id=" + id + ", name=" + name + '}';
	}

}
