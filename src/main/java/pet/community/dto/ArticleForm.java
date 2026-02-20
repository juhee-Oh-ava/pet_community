package pet.community.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pet.community.entity.Article;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
