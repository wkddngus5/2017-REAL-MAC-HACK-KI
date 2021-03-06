package com.amigotrip.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by NEXT on 2017. 11. 15..
 */
@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelerArticle {

    @Id
    @Column(name = "traveler_article_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @OneToMany
    @JoinColumn(name = "traveler_reply_id")
    private Set<TravelerReply> replies;

    private String location;

    private String contents;

    private LocalDateTime createDate;

    private String beginDate;

    private String endDate;

    public boolean isMatchWriter(User writer) {
        return this.writer == writer;
    }

    public void updateArticle(TravelerArticle article) {
        this.beginDate = article.beginDate;
        this.endDate = article.endDate;
        this.contents = article.contents;
    }

    public void addReply(TravelerReply reply) {
        replies.add(reply);
    }

    public void deleteReply(TravelerReply reply) {
        replies.remove(reply);
    }
}
