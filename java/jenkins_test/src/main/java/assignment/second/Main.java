package assignment.second.revised;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        List<String> words = List.of(
                "Boom", "BAN", "Band", "Bank", "be",
                "Eat", "Ear",
                "1");
        words.forEach(trie::addWord);
        System.out.println(trie.getWords('B'));
    }
}
