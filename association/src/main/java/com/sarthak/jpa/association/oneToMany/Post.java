package com.sarthak.jpa.association.oneToMany;


import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer postId;

	@Column(name = "post_owner")
	private String postOwner;

	@Column(name = "post_date")
	private Date postDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_post_id") // Here fk-column is created inside the target entity so give naming
										// accordingly.
	private List<Comment> commentList;

	public Post() {

	}

	public Post(String postOwner, Date postDate, List<Comment> commentList) {
		super();
		this.postOwner = postOwner;
		this.postDate = postDate;
		this.commentList = commentList;
	}

	public Integer getPostId() {
		return postId;
	}

	public String getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(String postOwner) {
		this.postOwner = postOwner;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postOwner=" + postOwner + ", postDate=" + postDate + ", commentList="
				+ commentList + "]";
	}

}
