package com.filter.v5;

/**version 05 能够中断执行filter的责任链
 * 
 * @author zy
 *
 */
public class ChainTest5 {
	
	public static void main(String[] args) {
		 ChainFilter chainFilter = new ChainFilter();
		 chainFilter.add(new NameFilter()).add(new AnimalFilter());
		 chainFilter.doFilter(new Request("req"), new Response("resp"));
	}

}

interface Filter{
	boolean doFilter(Request request, Response response, ChainFilter chainFilter);
}

class NameFilter implements Filter{

	@Override
	public boolean doFilter(Request request, Response response, ChainFilter chainFilter) {
		System.out.println("do request...");
		chainFilter.doFilter(request, response);
		System.out.println("do response...");
		return false;
	}
}

class AnimalFilter implements Filter{

	@Override
	public boolean doFilter(Request request, Response response, ChainFilter chainFilter) {
		System.out.println("do request**");
		chainFilter.doFilter(request, response);
		System.out.println("do response**");
		return true;
	}

}

class ChainFilter{
	class Node{
		Filter node;
		Node next;
	}
	Node head = new Node();
	Node curNode = head;
	public ChainFilter add(Filter f) {
		Node node = new Node();
		node.node = f;
		node.next = head.next;
		head.next = node;
		return this;
	}
	
	public boolean doFilter(Request request, Response response) {
		if(curNode.next==null || curNode.next.node==null) {
			curNode = head;
			return false;
		}else {
			curNode = curNode.next;
			curNode.node.doFilter(request, response, this);
			return true;
		}
	}
	
}