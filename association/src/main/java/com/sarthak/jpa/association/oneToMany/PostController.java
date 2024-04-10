package com.sarthak.jpa.association.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {
	@Autowired
	private InterPostService postService;
	
	public void savePost(Post post) {
		Post savedPost=this.postService.savePostEntity(post);
		System.out.println(savedPost);
	}
	
	public void readPost(Integer id) {
		Post retrievedPost=this.postService.readPostEntity(id);
		System.out.println(retrievedPost);
	}
	
	public void updatePostWithComment(Post post, Integer id) {
		Post updatedPost=this.postService.updatePostEntity(post,id);
		System.out.println("Updated Post Entity with the new updated features");
		System.out.println(updatedPost);
	}
	
	public void deleteEntity(Integer id) {
		System.out.println("Deleting the Entity with ID "+id);
		Boolean ans=this.postService.deletePostEnitity(id);
		if(ans) {
			System.out.println("deleting process completed!!");
		}
	}
}
