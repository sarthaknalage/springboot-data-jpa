package com.sarthak.jpa.association.oneToMany;

public interface InterPostService {
	
	public Post savePostEntity(Post post);
	
	public Post readPostEntity(Integer id);
	
	public Boolean deletePostEnitity(Integer id);
	
	public Post updatePostEntity(Post post, Integer id);
}
