package com.sarthak.jpa.association.oneToMany;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "postService")
public class ImplServicePost implements InterPostService {
	
	@Autowired
	InterPostPersistent postRepository;
	
	@Override
	public Post savePostEntity(Post post) {
		if(post!=null) {
			Post savedPost=this.postRepository.save(post);
			System.out.println("** Object is successfully saved!!");
			return post;
		}
		return null;
	}

	@Override
	public Post readPostEntity(Integer id) {
		if(id!=null && id>0) {
			Optional<Post> fetchPost=this.postRepository.findById(id);
			if(fetchPost.isPresent()) {
				return fetchPost.get();
			}else {
				System.out.println("Object with Id of "+id+" is not present !!");
			}
		}
		return null;
	}

	@Override
	public Boolean deletePostEnitity(Integer id) {
		if(this.postRepository.existsById(id)) {
			this.postRepository.deleteById(id);
			return !this.postRepository.existsById(id);
		}
		return false;
	}

	@Override
	public Post updatePostEntity(Post post, Integer id) {
//		we follow the standard approach for updating the post enity
		if(this.postRepository.existsById(id)){
			Post fetchPost=this.postRepository.findById(id).get();
			System.out.println("****Before update");
			System.out.println(fetchPost);
//			now setting the updated properties to fetched the post entity
//			as observation if their is condition of update then their is only changes are made
//			comment list not any as generally consideration
			fetchPost.setCommentList(post.getCommentList());
			System.out.println("After update****");
			System.out.println(fetchPost);
//			now saved the fetched entity
			Post updatedPost=this.postRepository.saveAndFlush(fetchPost);
			return updatedPost;
		}
		return null;
	}

}
