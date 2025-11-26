package model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reply")
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reply implements Serializable {

    @Id
    @Column(name = "reply_no")
    private Long replyNo;

    @Column(name = "comment_no")
    private Long commentNo;   // 필요하면 @ManyToOne 관계로 바꿔도 됩니다.

    @Column(name = "user_id")
    private String userId;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reg_date")
    private Date regDate;
}