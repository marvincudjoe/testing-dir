package assignment.second.revised;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Trie {
    private static final Logger logger = LoggerFactory.getLogger(Trie.class);
    private final TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }


    boolean addWord(String word) {
        if (!validWord(word)) {
            return false;
        }

        word = word.toUpperCase(Locale.ROOT);
        TrieNode currentNode = root;
        /*
         * For each character count in the word
         * set the previous node as the parent node
         * while the next node, if not null, as the child of the parent
         * */
        for (char character : word.toUpperCase(Locale.ROOT).toCharArray()) {
            TrieNode child = currentNode.innerChild(character);
            TrieNode previousNode = currentNode;
            if (child != null) {
                currentNode = child;
                child.parent = previousNode;
            } else {
                currentNode.children.add(new TrieNode(character));
                currentNode = currentNode.innerChild(character);
                currentNode.parent = previousNode;
            }
            currentNode.count++;
        }
        currentNode.isEnd = true;
        return true;

    }

    // check if a word is present in the Trie
    boolean find(String word) {
        word = word.toUpperCase();
        TrieNode currentNode = root;
        for (char character : word.toCharArray()) {
            if (currentNode.innerChild(character) == null) {
                return false;
            } else {
                currentNode = currentNode.innerChild(character);
            }
        }
        return currentNode.isEnd;//Will be false
    }

    // returns list of all words in a trie that begin with
    List<String> getWords(char c) {
        TrieNode currentNode = root;
        currentNode = currentNode.innerChild(Character.toUpperCase(c));
        if (currentNode == null) {
            return new ArrayList<>();
        }
        return currentNode.listOfWords();
    }

    /**.
     * Removes a given word from the Tree
     * @param word - Word to delete from the Trie
     * @return True or false dependent on the word being deleted
     */
    boolean delete(String word) {
        if (validWord(word)) {
            return false;
        }
        word = word.toUpperCase();
        TrieNode currentNode = root;
        for (char character : word.toUpperCase(Locale.ROOT).toCharArray()) {
            TrieNode child = currentNode.innerChild(character);
            if (child.count == 1) {
                currentNode.children.remove(child);
                return true;
            } else {
                child.count--;
                currentNode = child;
            }
        }
        logger.info("Cannot delete {} as it's last character does not end end in a single leaf", word);
        currentNode.isEnd = false;
        return false;
    }

    private boolean validWord(String word) {
        if (!isLetter(word)) {
            logger.error("Skipping word, {},as it contains a non alphabetical value", word);
            return false;
        }
        return !find(word);
    }

    private boolean isLetter(String word) {
        return word.matches("^[a-zA-Z]+$");
    }

}
