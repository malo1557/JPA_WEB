package service;

import java.util.Date;

// 실제 프로젝트 구조에 맞게 Comment 모델과 Repository의 패키지 경로를 수정해야 합니다.
// 여기서는 model.Comment와 repository.CommentRepository가 존재한다고 가정합니다.
// import model.Comment; 
// import repository.CommentRepository; 

// 예시를 위해 Comment 클래스를 CommentService 클래스 안에 임시로 정의합니다.
// 실제 프로젝트에서는 별도의 파일(model/Comment.java)로 분리하는 것이 좋습니다.
class Comment {
	private Long commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
	
	// Getter와 Setter (예시 편의를 위해 일부만 포함)
	public Long getCommentNo() { return commentNo; }
	public void setCommentNo(Long commentNo) { this.commentNo = commentNo; }
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	public Date getRegDate() { return regDate; }
	public void setRegDate(Date regDate) { this.regDate = regDate; }
	public String getCommentContent() { return commentContent; }
	public void setCommentContent(String commentContent) { this.commentContent = commentContent; }
}

// 예시를 위해 CommentRepository 인터페이스를 CommentService 클래스 안에 임시로 정의합니다.
// 실제 프로젝트에서는 별도의 파일(repository/CommentRepository.java)로 분리하는 것이 좋습니다.
interface CommentRepository {
    Comment findById(Long commentNo);
    void save(Comment comment);
    void delete(Long commentNo);
    // Comment findByUserId(String userId); // 필요한 경우 추가
}


public class CommentService {
	
	// 1. 의존성 (CommentRepository) 선언
	// 데이터베이스 접근 로직을 담당하는 Repository 인터페이스에 의존합니다.
	private final CommentRepository commentRepository;

	// 2. 생성자 주입 (Dependency Injection)
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	// 3. 비즈니스 로직 메서드 추가

    /**
     * 댓글 번호(PK)로 댓글 상세 정보를 조회합니다.
     * @param commentNo 조회할 댓글 번호
     * @return Comment 객체
     */
    public Comment getComment(Long commentNo) {
        // 실제 로직: commentRepository를 통해 데이터를 가져옵니다.
        System.out.println("CommentService: 댓글 번호 " + commentNo + "로 조회 시작");
        Comment comment = commentRepository.findById(commentNo);
        
        // 예시: 비즈니스 로직 (ex. 조회수 증가, 권한 확인 등)
        if (comment == null) {
            System.out.println("CommentService: 댓글을 찾을 수 없음.");
        }
        
        return comment;
    }
    
    /**
     * 새로운 댓글을 작성합니다.
     * @param comment 작성할 댓글 정보 (commentNo는 null)
     */
    public void createComment(Comment comment) {
        // 비즈니스 로직: 등록일자 설정
        comment.setRegDate(new Date());
        
        // 실제 로직: commentRepository를 통해 저장
        commentRepository.save(comment);
        System.out.println("CommentService: 새 댓글이 성공적으로 등록됨 (작성자: " + comment.getUserId() + ")");
    }
    
    /**
     * 기존 댓글을 수정합니다.
     * @param comment 수정할 댓글 정보 (commentNo가 반드시 존재해야 함)
     */
    public void updateComment(Comment comment) {
        // 비즈니스 로직: 수정 권한 확인 로직 등이 추가될 수 있습니다.
        
        // 실제 로직: commentRepository를 통해 수정 (대부분 save 메서드로 처리)
        commentRepository.save(comment);
        System.out.println("CommentService: 댓글 번호 " + comment.getCommentNo() + " 수정 완료");
    }
    
    /**
     * 댓글 번호로 댓글을 삭제합니다.
     * @param commentNo 삭제할 댓글 번호
     */
    public void deleteComment(Long commentNo) {
        // 비즈니스 로직: 삭제 권한 확인 로직 등이 추가될 수 있습니다.
        
        // 실제 로직: commentRepository를 통해 삭제
        commentRepository.delete(commentNo);
        System.out.println("CommentService: 댓글 번호 " + commentNo + " 삭제 완료");
    }

}