import java.util.ArrayList;

public class User {
   private long id;
   private String fullName;
   private ArrayList<Post> posts;
   private ArrayList<Comment> comments;
   
   public User(long id, String fullName) {
	   this.id = id;
	   this.fullName = fullName;
	   posts = new ArrayList<Post>();
	   comments = new ArrayList<Comment>();
   }

   void writePost(Post post) {
      if (post != null) {
    	  posts.add(post);
      }
   }

   void deletePost(Post post) throws PostException {
	   posts.remove(post);
   }
   
   void updatePost(Post post) throws PostException {
	   int positionPost = posts.indexOf(post);
	   posts.set(positionPost, post);
   }
   
   void writeSelfComment(Comment comment) {
	   if (comment != null) {
		   comments.add(comment);
	   }
   }
   
   void deleteSelfComment(Comment comment) throws CommentException {
	   comments.remove(comment);
   }
   
   void updateSelfComment(Comment comment) throws CommentException {
	   int positionComment = comments.indexOf(comment);
	   comments.set(positionComment, comment);
   }

}

public class Post {
   private long id;
   private String title;
   private String content;
   private User author;
   private ArrayList<Comment> comments;
   //---- Bổ xung method vào đây. Nhiệm vụ của các bạn đó ! 
}

private class Comment {
   private long id;
   private String title;
   private Post post; //Bài viết mà comment gắn vào
   private User author; //Tác giả của comment
   //---- Bổ xung method vào đây. Nhiệm vụ của các bạn đó !
}