package maku.mvc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date dateOfPublish;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getPublisher() {
        return user;
    }

    public void setPublisher(User publisher) {
        this.user = publisher;
    }

    public Date getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(Date dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.dateOfPublish, other.dateOfPublish)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", text=" + text + ", publisher=" + user + ", dateOfPublish=" + dateOfPublish + ", post=" + post + '}';
    }

}
