package index.people;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

	ArrayList<Group> groups = new ArrayList<Group>();
	ArrayList<String> members = new ArrayList<String>();
	private final AtomicLong counter = new AtomicLong();

	/* select groups */
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public ArrayList<Group> groups() {
		return groups;
	}

	/* input sample data */
	@RequestMapping(value = "/group/sampledata", method = RequestMethod.PUT)
	public boolean putGroupTestData() {
		groups.add(
				new Group(Long.toString(counter.incrementAndGet()), "myeongseong", "church", addMembers()));
		groups.add(new Group(Long.toString(counter.incrementAndGet()), "lg", "company", members));
		groups.add(new Group(Long.toString(counter.incrementAndGet()), "seoul", "university", members));

		return true;
	}

	/* add new group */
	@RequestMapping(value = "/group", method = RequestMethod.POST)
	public String addGroup(@RequestParam(value = "name") String name,
			@RequestParam(value = "organization") String organization) {
		groups.add(new Group(Long.toString(counter.incrementAndGet()), name, organization, new ArrayList<String>()));
		return "true";
	}

	/* add member to group */
	@RequestMapping(value = "/group/{name:.+}", method = RequestMethod.PUT)
	public boolean addMemberToGroup(@RequestParam(value = "name") String name,
			@RequestParam(value = "member") String member) {
		Group group = findGroupByName(name);
		ArrayList<String> updateArralyList = group.getGroupMemberList();

		if (findMemberByName(updateArralyList, member))
			updateArralyList.add(member);

		group.setGroupMemberList(updateArralyList);

		return true;
	}

	/* select group members */
	@RequestMapping(value = "/group/{name}", method = RequestMethod.GET)
	public ArrayList<String> getGroupMemberList(@PathVariable(value = "name") String name) {
		Group group = findGroupByName(name);
		return group.getGroupMemberList();

	}

	private Group findGroupByName(String name) {
		for (Group group : groups) {
			if (name.equals(group.getName())) {
				return group;
			}
		}
		return null;
	}

	private boolean findMemberByName(ArrayList<String> arrayList, String member) {
		for (String name : arrayList) {
			if (member.equals(name))
				return false;
		}
		return true;
	}
	
	public ArrayList<String> addMembers(){
		members.add("name1");
		members.add("name2");
		members.add("name3");
		
		return members;
	}
}
