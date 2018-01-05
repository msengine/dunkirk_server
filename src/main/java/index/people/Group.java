package index.people;

import java.util.ArrayList;

public class Group {

	private String id;
	private String name;
	private String organization;
	private ArrayList<String> groupMemberList;

	public Group(String id, String name, String organization, ArrayList<String> groupMemberList) {
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.groupMemberList = groupMemberList;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOganization(String organization) {
		this.organization = organization;
	}

	public String getName() {
		return name;
	}

	public String getOrganization() {
		return organization;
	}

	public ArrayList<String> getGroupMemberList() {
		return groupMemberList;
	}

	public void setGroupMemberList(ArrayList<String> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	
}
