package com.sarthak.jpa.association.oneToMany;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cmt_id")
	private Integer commentId;
	
	@Column(name="cmt_msg")
	private String commentMsg;
	
	@Column(name="cmt_date")
	private Date commentDate;
	
	public Comment() {
		
	}

	public Comment(String commentMsg, Date commentDate) {
		super();
		this.commentMsg = commentMsg;
		this.commentDate = commentDate;
	}

	public Integer getCommentId() {
		return commentId;
	}
	public String getCommentMsg() {
		return commentMsg;
	}

	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentMsg=" + commentMsg + ", commentDate=" + commentDate + "]";
	}
	
	
}
