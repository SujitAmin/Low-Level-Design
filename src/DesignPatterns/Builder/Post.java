package DesignPatterns.Builder;

public class Post {
    private String title;
    private String contents;
    Post(Builder builder) {
        this.title = builder.getTitle();
        this.contents = builder.getContents();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public static class Builder {
        private String title;
        private String contents;



        public String getContents() {
            return contents;
        }

        public String getTitle() {
            return title;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContents(String contents) {
            this.contents = contents;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}
