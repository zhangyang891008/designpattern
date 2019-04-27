package com.filter.v2;
import java.util.ArrayList;
import java.util.List;

/**version 02 有filterchain的责任链
 * 
 * @author zy
 *
 */
public class ChainTest2 {
	
	public static void main(String[] args) {
		Message message = new Message();
		message.content="maguangle is a pig .hahahaha!2@";
		ChainFilter chainFilter = new ChainFilter();
		chainFilter.add(new NameFilter());
		chainFilter.add(new AnimalFilter());
		chainFilter.doFilter(message);
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

class ChainFilter{
	List<Filter> filters = new ArrayList<>();
	public void add(Filter f) {
		filters.add(f);
	}
	public void doFilter(Message message) {
		for(Filter filter : filters) {
			filter.doFilter(message);
		}
	}
	
}