package com.ei.demo.core.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Care
 *
 */
@Entity

public class Care implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private LocalDateTime dateTime;
	private Duration duration;
	
	@OneToOne
	private Person parent;
	
	@OneToOne
	private Person babysitter;
	
	private static final long serialVersionUID = 1L;

	public Care() {
		super();
	}   
	
	public Care(Person parent, Person babysitter, String description, LocalDateTime dateTime, Duration duration) {
		super();
		this.description = description;
		this.dateTime = dateTime;
		this.duration = duration;
		this.parent = parent;
		this.babysitter = babysitter;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public Person getParent() {
		return parent;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}
	public Person getBabysitter() {
		return babysitter;
	}
	public void setBabysitter(Person babysitter) {
		this.babysitter = babysitter;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((babysitter == null) ? 0 : babysitter.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Care other = (Care) obj;
		if (babysitter == null) {
			if (other.babysitter != null)
				return false;
		} else if (!babysitter.equals(other.babysitter))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Care [id=" + id + ", description=" + description + ", dateTime=" + dateTime + ", duration=" + duration
				+ ", parent=" + parent + ", babysitter=" + babysitter + "]";
	}
   
}
