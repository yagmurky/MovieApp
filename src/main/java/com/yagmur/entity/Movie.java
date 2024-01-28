package com.yagmur.entity;

import com.yagmur.utility.EGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private EGenre genre;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Column(length = 3000)
    private String summary;
    private  String premiered;
    private String url;

    @ElementCollection
    private List<Long> genres;
    @ElementCollection
    private List<MovieComment> comments;
    /**
     *     MovieCommentte  private Long userId;
     *     private Long movieId; tuttuğumuz için buradakii
     *     @ElementCollection
     *     private List<MovieComment> comments;
     *     ve userdaki    @ElementCollection
     *     private List<Long> comments;
     *     bu her an uçurulabilir.
     */

}
