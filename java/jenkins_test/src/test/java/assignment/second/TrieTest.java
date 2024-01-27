package assignment.second.revised;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class TrieTest {
    Trie trie = new Trie();
    List<String> words = List.of(
            "Boom", "BAN", "Band", "Bank", "be",
            "Eat", "Ear");

    @Test
    void returnFalse_whenWordContainsNumber() {
        words = List.of(
                "1");
        words.forEach(word -> assertFalse(trie.addWord(word)));
    }

    @Test
    void returnTrue_whenWordIsAddedToTrie() {
        assertTrue(trie.addWord(("Bang")));
    }

    @Test
    void returnFalse_whenWordIsNotInTrie() {
        assertFalse(trie.find("some Word"));
    }

    @Test
    void returnTrue_whenWordIsInTrie() {
        generateTrie();
        assertTrue(trie.find("Ear"));
        assertTrue(trie.find("bOoM"));
        assertTrue(trie.find("BE"));
    }

    @Test
    void returnListOfWords_whenLetterHasWordsInTrie() {
        generateTrie();
        List<String> trieWords = trie.getWords('b');
        assertTrue(trieWords.containsAll(List.of("BAN", "BAND", "BANK", "BE", "BOOM")));
    }

    @Test
    void returnEmptyList_whenLetterHasNoWordsInTrie() {
        assertTrue(trie.getWords('s').isEmpty());
    }

    @Test
    void returnFalse_whenDeletingNodeWithLeaves() {
        generateTrie();
        assertFalse(trie.delete("ban")); //is a pre-fix/non-terminating leaf
    }

    @Test
    void returnTrue_whenDeletingNodeWithNoLeaves() {
        generateTrie();
        assertTrue(trie.delete("bank"));
        assertFalse(trie.find("bank"));
        assertTrue(trie.find("ban")); //pre-fix word is present
    }

    private void generateTrie() {
        words.forEach(trie::addWord);
    }
}