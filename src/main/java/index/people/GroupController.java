package index.people;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

	ArrayList<Group> groups = new ArrayList<Group>();
	private final AtomicLong counter = new AtomicLong();

	/* select groups */
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public ArrayList<Group> groups() {
		return groups;
	}

	/* input sample data */
	@RequestMapping(value = "/group/sampledata", method = RequestMethod.PUT)
	public boolean putGroupTestData() {
		groups.add(new Group(Long.toString(counter.incrementAndGet()), "myeongseong", "church"));
		groups.add(new Group(Long.toString(counter.incrementAndGet()), "lg", "company"));
		groups.add(new Group(Long.toString(counter.incrementAndGet()), "seoul", "university"));

		return true;
	}

	/* add new group */
	@RequestMapping(value = "/group", method = RequestMethod.POST)
	public String putNewGroup(@RequestParam(value = "name") String name,
			@RequestParam(value = "organization") String organization) {
		groups.add(new Group(Long.toString(counter.incrementAndGet()), name, organization));
		return "true";
	}
}
