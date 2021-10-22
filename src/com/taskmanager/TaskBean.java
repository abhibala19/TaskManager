package com.taskmanager;

import java.util.Date;

public class TaskBean {
private String taskName;
private String description;
private String tag;
private int priority;
private Date date;
public String getTaskName() {
	return taskName;
}
public void setTaskName(String taskName) {
	taskName = taskName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTag() {
	return tag;
}
public void setTag(String tag) {
this.tag = tag;
}
public int getPriority() {
	return priority;
}
public void setPriority(int priority) {
	this.priority = priority;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public TaskBean() {
	// TODO Auto-generated constructor stub
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + priority;
	result = prime * result + ((tag == null) ? 0 : tag.hashCode());
	result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
	return result;
}
public TaskBean(String taskName, String description, String tag, int priority, Date date) {
	super();
	this.taskName = taskName;
	this.description = description;
	this.tag = tag;
	this.priority = priority;
	this.date = date;
}
@Override
public String toString() {
	return "TaskBean [taskName=" + taskName + ", description=" + description + ", tag=" + tag + ", priority=" + priority
			+ ", date=" + date + "]";
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TaskBean other = (TaskBean) obj;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (priority != other.priority)
		return false;
	if (tag == null) {
		if (other.tag != null)
			return false;
	} else if (!tag.equals(other.tag))
		return false;
	if (taskName == null) {
		if (other.taskName != null)
			return false;
	} else if (!taskName.equals(other.taskName))
		return false;
	return true;
}
}
