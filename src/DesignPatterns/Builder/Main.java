package DesignPatterns.Builder;

public class Main {
    public static void main(String[] args) {
        Post post = new Post.Builder().setTitle("Yo").setContents("Balle").build();
    }
}
