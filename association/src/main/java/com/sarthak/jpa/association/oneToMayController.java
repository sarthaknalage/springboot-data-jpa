package com.sarthak.jpa.association;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sarthak.jpa.association.oneToMany.Comment;
import com.sarthak.jpa.association.oneToMany.Post;
import com.sarthak.jpa.association.oneToMany.PostController;

@Component(value = "oneToMany")
public class oneToMayController  {
//	DI of controller of oneToMany controller in order to apply the operations
//	Here write the logic of OneToMany association
	@Autowired
	private PostController postController;
	
	public void saved() {
		Comment comment1=new Comment("Looking like wow!!",new Date());
		Comment comment2=new Comment("cutie pie",new Date());
		Comment comment3=new Comment("Smartness overloaded!",new Date());
		List<Comment> listComment=List.of(comment1, comment2, comment3);
//		creation of post entity
		Post post=new Post("sarthak_nalage",new Date(),listComment);
		this.postController.savePost(post);
	}
	public void read(int id) {
//		Here we reading the post with the specific id
		this.postController.readPost(id);
		
	}
	
	public void update() {
//		any updation make changes in that
		Comment comment1=new Comment("Looking like cow!!",new Date());
		Comment comment2=new Comment("cutie nonsense",new Date());
		Comment comment3=new Comment("Smartness undergrounded !",new Date());
		List<Comment> listComment=List.of(comment1, comment2, comment3);
		
		Post post=new Post("sarthak_nalage",new Date(),listComment);
//		update this entity
		this.postController.updatePostWithComment(post,1);
		
	}
	
	public void delete(Integer id) {
		this.postController.deleteEntity(id);
	}
}
