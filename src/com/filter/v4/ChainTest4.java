package com.filter.v4;
import java.util.ArrayList;
import java.util.List;

/**version 04 能够中断执行filter的责任链
 * 
 * @author zy
 *
 */
public class ChainTest4 {
	
	public static void main(String[] args) {
		Message message = new Message();
		message.content="maguangle is a pig .hahahaha!2@";
		ChainFilter chainFilter = new ChainFilter();
		chainFilter.add(new NameFilter()).add(new AnimalFilter());
		chainFilter.doFilter(message);
		System.out.println(message.content);
	}

}

interface Filter{
	boolean doFilter(Message m);
}

class Message{
	String content;
}

class NameFilter implements Filter{

	@Override
	public boolean doFilter(Message m) {
		m.content = m.content.replace("maguangle", "zhangyang");
		return false;
	}
	
}

class AnimalFilter implements Filter{

	@Override
	public boolean doFilter(Message m) {
		m.content = m.content.replace("pig", "lovely bird");
		if(m.content.equals("maguangle"))
			return false;
		else 
			return true;
	}
	
}

class ChainFilter implements Filter{
	List<Filter> filters = new ArrayList<>();
	public ChainFilter add(Filter f) {
		filters.add(f);
		return this;
	}
	@Override
	public boolean doFilter(Message message) {
		for(Filter filter : filters) {
			if(!filter.doFilter(message)) {
				break;
			}
		}
		return true;
	}
	
}