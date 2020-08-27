package pl.adambaranowski.springmvcthymeleaf.model;

import java.util.Objects;

public class Article {
    private String title;
    private String content;
    private String tags;


    public Article() {
    }

    public Article(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(content, article.content) &&
                Objects.equals(tags, article.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, tags);
    }
}
