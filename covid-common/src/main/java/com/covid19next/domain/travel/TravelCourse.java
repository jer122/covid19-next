package com.covid19next.domain.travel;

import com.covid19next.domain.BaseTime;
import com.covid19next.domain.city.City;
import com.covid19next.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
public class TravelCourse extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long id;
    private String courseName;
    private Long starPoint;
    @Lob
    private String content;
    @Lob
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public void update(String courseName, String content) {
        this.courseName = courseName;
        this.content = content;
    }

    public void updateStarPoint(Long starPoint) {
        this.starPoint = (starPoint + this.starPoint) / 2;
//        return this.starPoint;
    }

    @Builder
    public TravelCourse(Long id, String courseName, Long starPoint, String content, String image, Member member, City city) {
        this.id = id;
        this.courseName = courseName;
        this.starPoint = starPoint;
        this.content = content;
        this.image = image;
        this.member = member;
        this.city = city;
//        createImage();
    }

    //    @Builder
//    public TravelCourse(String courseName, String content, Member member, City city, Long starPoint) {
//        this.courseName = courseName;
//        this.content = content;
//        this.member = member;
//        this.city = city;
//        this.starPoint = starPoint;
//        this.image = createImage();
//    }


    public TravelCourse createImage() {
        String image = this.content;
        int imageFirstNumber = image.indexOf("data:image");
        if (imageFirstNumber > -1) {
            image = image.substring(imageFirstNumber);
            int imageLastNumber = image.indexOf("\" alt=");
            this.image = image.substring(0, imageLastNumber);
        } else {
            this.image = null;
        }
        return this;
//        return image;
    }
}
