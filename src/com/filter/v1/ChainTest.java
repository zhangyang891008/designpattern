package com.filter.v1;
import java.util.ArrayList;
import java.util.List;

/**version 01 最初的责任链
 * 
 * @author zy
 *
 */
public class ChainTest {
	
	public static void main(String[] args) {
		Message message = new Message();
		message.content="maguangle is a pig .hahahaha!2@";
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(new NameFilter());
		filters.add(new AnimalFilter());
		for(Filter filter:filters) {
			filter.doFilter(message);
		}
		System.out.println(message.content);
	}

}

interface Filter{
	void doFilter(Message m);
}

class Message{
	String content;
}

class NameFilter implements Filter{

	@Override
	public void doFilter(Message m) {
		m.content = m.content.replace("maguangle", "zhangyang");
	}
	
}

class AnimalFilter implements Filter{

	@Override
	public void doFilter(Message m) {
		m.content = m.content.replace("pig", "lovely bird");
	}
	
}